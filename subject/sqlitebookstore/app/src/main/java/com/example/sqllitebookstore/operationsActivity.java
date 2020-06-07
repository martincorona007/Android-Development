package com.example.sqllitebookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class operationsActivity extends AppCompatActivity {

    EditText txt_bung,txtparser,text_1,text_2,text_3;
    String login;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    Cursor consult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        login=getIntent().getStringExtra("log");

        txt_bung=findViewById(R.id.txt_email);
        txtparser=findViewById(R.id.txt_password);
        btn1=findViewById(R.id.btn_add);
        btn2=findViewById(R.id.btn_delte);
        btn3=findViewById(R.id.btn_update);
        btn4=findViewById(R.id.btn_addUser);
        btn5=findViewById(R.id.btn_addAdmin);
        btn6=findViewById(R.id.btn_backward);
        btn7=findViewById(R.id.btn_next);
        text_1=findViewById(R.id.txt_1);
        text_2=findViewById(R.id.txt_2);
        text_3=findViewById(R.id.txt_3);

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
        DBSQLite gestor=new DBSQLite(this,"prueba",null,1);
        SQLiteDatabase DB=gestor.getReadableDatabase();

        consult=DB.rawQuery("SELECT * FROM books",null);
        consult.moveToFirst();
        text_1.setText(consult.getString(0));
        text_2.setText(consult.getString(1));
        text_3.setText(consult.getString(2));

    }
    public void cargarMainActivity(View view){
        Intent actvMain=new Intent(this,MainActivity.class);
        startActivity(actvMain);
    }
    public void next(View view){

        if(!consult.moveToNext()) consult.moveToLast();

        text_1.setText(consult.getString(0));
        text_2.setText(consult.getString(1));
        text_3.setText(consult.getString(2));
    }

    public void back(View view){
        if(!consult.moveToPrevious()) consult.moveToFirst();

        text_1.setText(consult.getString(0));
        text_2.setText(consult.getString(1));
        text_3.setText(consult.getString(2));
    }

    public void add(View view){
        Intent act=new Intent(this,addActivity.class);
        startActivity(act);
    }
    public void delete(View view){
        Intent act=new Intent(this,deleteActivity.class);
        startActivity(act);
    }
    public void update(View view){
        Intent act=new Intent(this,updateActivity.class);
        startActivity(act);
    }
    public void addUser(View view){
        Intent act=new Intent(this,userActivity.class);
        startActivity(act);
    }
    public void addAdmin(View view){
        Intent act=new Intent(this,adminActivity.class);
        startActivity(act);
    }




}
