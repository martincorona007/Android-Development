package com.example.my_ap_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Oncreate",Toast.LENGTH_LONG).show();
    }
    protected void onStart(){
        super.onStart();
        Toast.makeText(this,"OnStart",Toast.LENGTH_LONG).show();
    }
    protected void onResume(){
        super.onResume();
        Toast.makeText(this,"OnResume",Toast.LENGTH_LONG).show();
    }
    protected void onPause(){
        super.onPause();
        Toast.makeText(this,"OnPause",Toast.LENGTH_LONG).show();
    }
    protected void onStop(){
        super.onStop();
        Toast.makeText(this,"OnStop",Toast.LENGTH_LONG).show();
    }
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this,"OnRestart",Toast.LENGTH_LONG).show();
    }
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"OnDestroy",Toast.LENGTH_LONG).show();
    }


}
