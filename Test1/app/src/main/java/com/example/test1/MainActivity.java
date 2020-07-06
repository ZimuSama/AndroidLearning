package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static boolean flag=false;
    static int num = 0;
    static String bin="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = findViewById(R.id.Display);
    findViewById(R.id.button0).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427)
            num=num*10;
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.button1).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427)
            num=num*10+1;
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.button2).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427)
            num=num*10+2;
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.button3).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427)
            num=num*10+3;
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.button4).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427)
            num=num*10+4;
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.button5).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427)
            num=num*10+5;
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.button6).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427)
            num=num*10+6;
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.button7).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427)
            num=num*10+7;
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.button8).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427)
            num=num*10+8;
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.button9).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427)
            num=num*10+9;
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.CLR).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            num=0;
            bin="";
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.GO).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(flag==false){
                bin="";
                flag=true;
                while(num!=0) {
                    bin=num%2+bin;
                    num=num/2;
                }
            }
            num=0;
            tv.setText(bin);
        }
    });
    Log.i("Nice", "Run Successfully!");
    }
}
