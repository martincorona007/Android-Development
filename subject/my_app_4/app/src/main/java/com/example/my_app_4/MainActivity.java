package com.example.my_app_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.my_app_4.R.id.option_time;

public class MainActivity extends AppCompatActivity {
    private RadioGroup getOption2;
    private RadioButton getOption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getOption2=(RadioGroup) findViewById(R.id.option_time);
    }
    public void method_select(View v){
        if(getOption2.getCheckedRadioButtonId()==R.id.rb1){
            String text = "You had studied English for 1-2 years.";
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }
        if (getOption2.getCheckedRadioButtonId()==R.id.rb2){
            String text = "You had studied English for 3-4 years.";
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }
        if(getOption2.getCheckedRadioButtonId()==R.id.rb3){
            String text = "You had studied English for 5-6 years.";
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }
    }
}
