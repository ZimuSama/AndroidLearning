package com.example.test2;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.test2.Recycler.RecDecoration;
import com.example.test2.Recycler.MessageAdapter;
import com.example.test2.Recycler.RecData;
import com.example.test2.Recycler.RecDataSet;

import android.view.View;
import android.view.ViewGroup;

import static com.example.test2.R.id.at;
import static com.example.test2.R.id.com;
import static com.example.test2.R.id.fans;
import static com.example.test2.R.id.like;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "TAG";
    private RecyclerView recyclerView;
    private MessageAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private GridLayoutManager gridLayoutManager;
    private ContextWrapper buf=this;
    private MessageAdapter.IOnItemClickListener MyListener=new MessageAdapter.IOnItemClickListener() {
        @Override
        public void onItemCLick( int position, RecData data){
            Intent intent = new Intent(buf, MessageActivity.class);
            intent.putExtra("id",data.id);
            intent.putExtra("name",data.name);
            intent.putExtra("message",data.message);
            startActivity(intent);
            Log.i(TAG, "clicked");
        }
        @Override
        public void onItemLongCLick ( int position, RecData data){
            Log.i(TAG, "longclicked");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Log.i(TAG, "View Count"+(this.layoutManager.getItemCount()*3+4*2+1));
    }
    private void initView(){
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MessageAdapter(RecDataSet.getData());
        mAdapter.setOnItemClickListener(MyListener);
        recyclerView.setAdapter(mAdapter);
        RecDecoration itemDecoration = new RecDecoration(Color.GRAY);
        recyclerView.addItemDecoration(itemDecoration);
        findViewById(fans).setOnClickListener(this);
        findViewById(like).setOnClickListener(this);
        findViewById(at).setOnClickListener(this);
        findViewById(com).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(buf, MenuActivity.class);
        Log.i(TAG, "menuclicked");
        switch(v.getId()){
            case fans:
                intent.putExtra("color","#4F88FB");//79,136,251
                intent.putExtra("label","粉丝");
                break;
            case like:
                intent.putExtra("color","#F8355F");//248,53,95
                intent.putExtra("label","赞");
                break;
            case at:
                intent.putExtra("color","#1CC162");//28,193,98
                intent.putExtra("label","@我的");
                break;
            case com:
                intent.putExtra("color","#C468FB");//196,107,251
                intent.putExtra("label","评论");
                break;
        }
        startActivity(intent);
    }
}
