package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonA;
    Button buttonB;
    Button buttonC;
    TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonA=(Button)findViewById(R.id.btn1);
        buttonB=(Button)findViewById(R.id.btn2);
        buttonC=(Button)findViewById((R.id.btn3));
        txtView=(TextView)findViewById(R.id.txt);
        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn1){
            txtView.setText("A is clicked");
        }
        if(view.getId()==R.id.btn2){
            txtView.setText("B now");
        }
        if(view.getId()==R.id.btn3){
            txtView.setText("C Finally");
        }
    }






















}
