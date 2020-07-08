package com.example.test2;

import android.os.Bundle;
import com.example.test2.Recycler.RecData;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.ImageView;

public class MessageActivity extends AppCompatActivity {
    private RecData MsgData=new RecData(0,"default","default");
    private ImageView Header;
    private TextView Name;
    private TextView Msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_window);
        MsgData.id=getIntent().getIntExtra("id",R.drawable.b01);
        MsgData.name=getIntent().getStringExtra("name");
        MsgData.message=getIntent().getStringExtra("message");
        Header=findViewById(R.id.header);
        Name=findViewById(R.id.name);
        Msg=findViewById(R.id.message);
        Header.setImageResource(MsgData.id);
        Name.setText(MsgData.name);
        Msg.setText("\t\t"+MsgData.message+"\t\t");
    }
}
