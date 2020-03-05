package com.example.my_ap_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText ed_txt_1;
    EditText ed_txt_2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_txt_1=findViewById(R.id.ed_txt_1);
        ed_txt_2=findViewById(R.id.ed_txt_2);
        result=findViewById(R.id.txt_result);
    }
    public void sum(View v){
        result.setText(String.valueOf(Integer.parseInt(ed_txt_1.getText().toString())+Integer.parseInt(ed_txt_2.getText().toString())));
    }
    public void substraction(View v){
        result.setText(String.valueOf(Integer.parseInt(ed_txt_1.getText().toString())-Integer.parseInt(ed_txt_2.getText().toString())));
    }
    public void multiplication(View v){
        result.setText(String.valueOf(Integer.parseInt(ed_txt_1.getText().toString())*Integer.parseInt(ed_txt_2.getText().toString())));
    }
    public void division(View v){
        result.setText(String.valueOf(Integer.parseInt(ed_txt_1.getText().toString())/Integer.parseInt(ed_txt_2.getText().toString())));
    }

}
