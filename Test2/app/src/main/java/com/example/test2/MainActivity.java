package com.example.test2;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.test2.Recycler.MessageAdapter;
import com.example.test2.Recycler.RecData;
import com.example.test2.Recycler.RecDataSet;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    private RecyclerView recyclerView;
    private MessageAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private GridLayoutManager gridLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        recyclerView = findViewById(R.id.recycler);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MessageAdapter(RecDataSet.getData());
        MessageAdapter.IOnItemClickListener newListner=new MessageAdapter.IOnItemClickListener() {
            @Override
            public void onItemCLick(int position, RecData data) {
                Log.i(TAG, "clicked");
            }
            @Override
            public void onItemLongCLick(int position, RecData data) {
                Log.i(TAG, "longclicked");
            }
        };
        mAdapter.setOnItemClickListener(newListner);
        recyclerView.setAdapter(mAdapter);
//        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Main onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Main onResume");
    }
}
