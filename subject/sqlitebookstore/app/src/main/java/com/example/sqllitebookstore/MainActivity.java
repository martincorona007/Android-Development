package com.example.sqllitebookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;


import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txt_bung,txtparser;

    Cursor consultilla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_bung=findViewById(R.id.txt_email);
        txtparser=findViewById(R.id.txt_password);

        //String bung=txt_bung.getText().toString();
        //String parser=txtparser.getText().toString();

        DBSQLite gestor=new DBSQLite(this,"prueba",null,1);
        SQLiteDatabase DB=gestor.getWritableDatabase();

        Cursor query=DB.rawQuery("SELECT * FROM users",null);
        if(!query.moveToFirst()){
            ContentValues register=new ContentValues();
            register.put("name","donnadie");
            register.put("email","donnadie@gmail.com");
            register.put("pwas","123456789");
            register.put("typer","admin");
            DB.insert("users",null,register);

            ContentValues register1=new ContentValues();
            register1.put("name","donquijote");
            register1.put("isbn","1");
            register1.put("price","520");
            DB.insert("books",null,register1);

            DB.close();
            Toast.makeText(this, "admin created", Toast.LENGTH_SHORT).show();
        }
    }
        public void loddedewgIn(View view){
            DBSQLite gestorr=new DBSQLite(this,"prueba",null,1);
            SQLiteDatabase DB1=gestorr.getReadableDatabase();

            String bung=txt_bung.getText().toString();
            String parser=txtparser.getText().toString();

            if(bung.isEmpty()||parser.isEmpty()){
                Toast.makeText(this,"User or password empty",Toast.LENGTH_SHORT).show();
            }else{
                Cursor registers=DB1.rawQuery("SELECT * FROM users WHERE email='"+bung+"' AND pwas='"+parser+"'",null);
                if(registers.moveToFirst()){
                    //consultilla=DB1.rawQuery("SELECT * FROM users WHERE email='"+bung+"' AND pwas='"+parser+"'",null);

                    /*Intent act=new Intent(this,addActivity.class);
                    //act.putExtra("login",registers.getString(3));
                    startActivity(act);
                    */

                    Intent act=new Intent(this,operationsActivity.class);
                    act.putExtra("log",registers.getString(3));
                    DB1.close();
                    startActivity(act);

                }else{
                    Toast.makeText(this,"User or password invalid",Toast.LENGTH_SHORT).show();
                    DB1.close();
                }

            }
        }
    public void signup(View view){
        Intent act=new Intent(this,userActivity.class);
        //act.putExtra("typer",consultilla.getString(3));
        startActivity(act);
    }





}
