package com.example.pv_sisto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class add_user_Activity extends AppCompatActivity {
    EditText txt_bung,txtparser,txt_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txt_name=findViewById(R.id.txt_name);
        txt_bung=findViewById(R.id.txt_email);
        txtparser=findViewById(R.id.txt_password);
    }
    public void addEmploy(View view){
        DBSQLite gestorr=new DBSQLite(this,"prueba",null,1);
        SQLiteDatabase DB1=gestorr.getReadableDatabase();

        String bung=txt_bung.getText().toString();
        String parser=txtparser.getText().toString();
        String name=txt_name.getText().toString();
        if(bung.isEmpty()||parser.isEmpty()||name.isEmpty()){
            Toast.makeText(this,"User or password or name empty",Toast.LENGTH_SHORT).show();
        }else{

            Cursor consultaTemp;

            ContentValues register=new ContentValues();
            register.put("name",name);
            register.put("email",bung);
            register.put("pwas",parser);
            register.put("typer","user");
            DB1.insert("users",null,register);
            txt_name.setText("");
            txt_bung.setText("");
            txtparser.setText("");
            DB1.close();
            Toast.makeText(this, "User added successfully", Toast.LENGTH_SHORT).show();


        }
    }
}
