package com.example.test2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity{
    private TextView Label;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_window);
        Label=findViewById(R.id.Label);
        String color=getIntent().getStringExtra("color");
        Label.setBackgroundColor(android.graphics.Color.parseColor(color));
        String label=getIntent().getStringExtra("label");
        Label.setText(label);
    }
}
