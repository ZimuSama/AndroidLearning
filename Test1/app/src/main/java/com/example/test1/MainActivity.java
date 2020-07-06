package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.lang.reflect.Parameter;

public class MainActivity extends AppCompatActivity {
    static boolean flag=false;
    static int num = 0;
    static String bin="";
    private CheckBox ch1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = findViewById(R.id.Display);
        ch1=(CheckBox)findViewById(R.id.checkBox);
    findViewById(R.id.button0).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427) {
                num = num * 10;
                Log.i("Btn0", "Done");
            }
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.button1).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427) {
                num = num * 10 + 1;
                Log.i("Btn1", "Done");
            }
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.button2).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427) {
                num = num * 10 + 2;
                Log.i("Btn2", "Done");
            }
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.button3).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427) {
                num = num * 10 + 3;
                Log.i("Btn3", "Done");
            }
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.button4).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427) {
                num = num * 10 + 4;
                Log.i("Btn4", "Done");
            }
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.button5).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427) {
                num = num * 10 + 5;
                Log.i("Btn5", "Done");
            }
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.button6).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427) {
                num = num * 10 + 6;
                Log.i("Btn6", "Done");
            }
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.button7).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427) {
                num = num * 10 + 7;
                Log.i("Btn7", "Done");
            }
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.button8).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427){
                num=num*10+8;
                Log.i("Btn8", "Done");
            }
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.button9).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num<=52427) {
                num = num * 10 + 9;
                Log.i("Btn9", "Done");
            }
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.CLR).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(num!=0) {
                num = 0;
                Log.i("BtnCLR", "Clear Done");
            }
            if(bin!="") {
                bin = "";
                Log.i("BtnCLR", "Clear Done");
            }
            flag=false;
            tv.setText(String.valueOf(num));
        }
    });
    findViewById(R.id.GO).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(!flag){
                bin="";
                flag=true;
                while(num!=0) {
                    bin=num%2+bin;
                    num=num/2;
                }
                Log.i("BtnGO", "Conversion Succeeded");
            }
            num=0;
            tv.setText(bin);
        }
    });
        ch1.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (ch1.isChecked()) {
                findViewById(R.id.imageView).setVisibility(View.VISIBLE);
                Log.i("CheckBox", "Now picture visible");
            }
            else {
                findViewById(R.id.imageView).setVisibility(View.INVISIBLE);
                Log.i("CheckBox", "Now picture invisible");
            }
        }
    });
    Log.i("Nice", "Run Successfully!");
    }
}
