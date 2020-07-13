package com.bytedance.todolist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.bytedance.todolist.R;
import com.bytedance.todolist.database.TodoListDao;
import com.bytedance.todolist.database.TodoListDatabase;
import com.bytedance.todolist.database.TodoListEntity;
import com.google.android.material.snackbar.Snackbar;

import java.util.Date;
import java.util.List;

public class AddItemActivity extends AppCompatActivity {
    private Button mButton;
    private EditText mText;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item_activity_layout);
        mButton=findViewById(R.id.Add);
        mText=findViewById(R.id.Text);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String AddString=mText.getText().toString();
                new Thread() {
                    @Override
                    public void run() {
                        TodoListDao dao = TodoListDatabase.inst(getApplicationContext()).todoListDao();
                        dao.addTodo(new TodoListEntity(AddString, new Date(System.currentTimeMillis())));
                    }
                }.start();
                AddItemActivity.this.finish();
            }
        });
    }
}
