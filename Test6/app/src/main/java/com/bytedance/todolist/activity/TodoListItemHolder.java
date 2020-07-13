package com.bytedance.todolist.activity;

import android.app.Activity;
import android.content.ContentProvider;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.contentcapture.ContentCaptureContext;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.todolist.R;
import com.bytedance.todolist.database.TodoListDao;
import com.bytedance.todolist.database.TodoListDatabase;
import com.bytedance.todolist.database.TodoListEntity;
import com.google.android.material.snackbar.Snackbar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author wangrui.sh
 * @since Jul 11, 2020
 */
public class TodoListItemHolder extends RecyclerView.ViewHolder {
    private TextView mContent;
    private TextView mTimestamp;
    private CheckBox checkBox;
    private View view;
    TodoListEntity mEntity;
    public TodoListItemHolder(@NonNull View itemView) {
        super(itemView);
        final Context mcontext = itemView.getContext();
        mContent = itemView.findViewById(R.id.tv_content);
        mTimestamp = itemView.findViewById(R.id.tv_timestamp);
        checkBox=itemView.findViewById(R.id.check);
        view=itemView.findViewById(R.id.fork);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if(isChecked) {
                            mContent.setPaintFlags(mContent.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            mContent.setTextColor(Color.GRAY);
                            new Thread() {
                                @Override
                                public void run() {
                                    final TodoListDao dao = TodoListDatabase.inst(mcontext).todoListDao();
                                    dao.delete(mEntity);
                                    mEntity.setFinish(true);
                                    dao.addTodo(mEntity);
                                }
                            }.start();
                        }
                        else {
                            mContent.setPaintFlags(mContent.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                            mContent.setTextColor(Color.BLACK);
                            new Thread() {
                                @Override
                                public void run() {
                                    final TodoListDao dao = TodoListDatabase.inst(mcontext).todoListDao();
                                    dao.delete(mEntity);
                                    mEntity.setFinish(false);
                                    dao.addTodo(mEntity);
                                }
                            }.start();
                        }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {
                    @Override
                    public void run() {
                        final TodoListDao dao = TodoListDatabase.inst(mcontext).todoListDao();
                        dao.delete(mEntity);
                        final Activity mActivity=(Activity)mcontext;
                        final List<TodoListEntity> entityList = dao.loadAll();
                        mActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                RecyclerView mRv= mActivity.findViewById(R.id.rv_list);
                                TodoListAdapter mAdapter= (TodoListAdapter)mRv.getAdapter();
                                mAdapter.setData(entityList);
                            }
                        });
                    }
                }.start();
            }
        });
    }

    public void bind(TodoListEntity entity) {
        mEntity=entity;
        mContent.setText(entity.getContent());
        if(entity.isFinish()){
            mContent.setPaintFlags(mContent.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            mContent.setTextColor(Color.GRAY);
        }
        else{
            mContent.setPaintFlags(mContent.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            mContent.setTextColor(Color.BLACK);
        }
        mTimestamp.setText(formatDate(entity.getTime()));
    }

    private String formatDate(Date date) {
        DateFormat format = SimpleDateFormat.getDateInstance();
        return format.format(date);
    }
}
