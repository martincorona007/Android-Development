package com.example.pv_sisto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class homeActivity extends AppCompatActivity {
    EditText txt_bung,txtparser,text_1,text_2,text_3;
    String login;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    Cursor consult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        login=getIntent().getStringExtra("log");

        txt_bung=findViewById(R.id.txt_email);
        txtparser=findViewById(R.id.txt_password);
        btn1=findViewById(R.id.btn_1);
        btn2=findViewById(R.id.btn_2);
        btn3=findViewById(R.id.btn_3);
        btn4=findViewById(R.id.btn_4);
        btn5=findViewById(R.id.btn_5);



        if(login.equals("admin")){
            btn1.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);
            btn3.setVisibility(View.VISIBLE);
            btn4.setVisibility(View.VISIBLE);
            btn5.setVisibility(View.VISIBLE);

        }else{
            btn1.setVisibility(View.INVISIBLE);
            btn2.setVisibility(View.INVISIBLE);
            btn3.setVisibility(View.INVISIBLE);
            btn4.setVisibility(View.INVISIBLE);
            btn5.setVisibility(View.INVISIBLE);

        }

    }
    public void addProduct(View view){
        Intent act=new Intent(this,add_Product_Activity.class);
        startActivity(act);
    }
    public void deleteProduct(View view){
        Intent act=new Intent(this,delete_Product_Activity.class);
        startActivity(act);
    }
    public void updateProduct(View view){
        Intent act=new Intent(this,update_Product_Activity.class);
        startActivity(act);
    }
    public void viewProduct(View view){
        Intent act1=new Intent(this,view_Products_Activity.class);
        startActivity(act1);
    }
    public void addAdmin(View view){
        Intent act=new Intent(this,add_admin_Activity.class);
        startActivity(act);
    }
    public void addUser(View view){
        Intent act=new Intent(this,add_user_Activity.class);
        startActivity(act);
    }

}
