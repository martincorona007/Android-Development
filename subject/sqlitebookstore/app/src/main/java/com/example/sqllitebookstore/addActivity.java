package com.example.sqllitebookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addActivity extends AppCompatActivity {
    EditText txt_bung,txtparser,text_1,text_2,text_3;
    SQLiteDatabase DB;
    Cursor consulta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        text_1=findViewById(R.id.txt_1);
        text_2=findViewById(R.id.txt_2);
        text_3=findViewById(R.id.txt_3);

    }

    public void adding(View view){
        String s1=text_1.getText().toString();
        String s2=text_2.getText().toString();
        String s3=text_3.getText().toString();
        if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()){
            Toast.makeText(this,"Some field can't be empty",Toast.LENGTH_SHORT).show();
        }else{
            DBSQLite gestor=new DBSQLite(this,"prueba",null,1);
            SQLiteDatabase DB1=gestor.getWritableDatabase();

            Cursor consultaTemp;
            consultaTemp = DB1.rawQuery("SELECT * FROM books WHERE isbn='" + s2 + "'", null);
            if(!consultaTemp.moveToFirst()){
                ContentValues register=new ContentValues();
                register.put("name",s1);
                register.put("isbn",s2);
                register.put("price",s3);
                DB1.insert("books",null,register);
                consulta=DB1.rawQuery("SELECT * FROM books",null);
                consulta.moveToLast();
                //DB1.close();
                Toast.makeText(this, "Book added successfully", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Book already register", Toast.LENGTH_SHORT).show();
            }



        }
    }
}
