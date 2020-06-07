package com.example.sqllitebookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class deleteActivity extends AppCompatActivity {
    EditText txt_bung,txtparser,text_1,text_2,text_3;
    SQLiteDatabase DB;
    Cursor consulta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        text_1=findViewById(R.id.txt_1);


    }
    public void delete(View view){
        String s1=text_1.getText().toString();

        if(s1.isEmpty()){
            Toast.makeText(this,"Some field can't be empty",Toast.LENGTH_SHORT).show();
        }else{
            DBSQLite gestor=new DBSQLite(this,"prueba",null,1);
            SQLiteDatabase DB1=gestor.getWritableDatabase();

            int consultaTemp = DB1.delete("books "," isbn='" + s1 + "'", null);
           if(consultaTemp>0){
               Toast.makeText(this, "Book deleted", Toast.LENGTH_SHORT).show();
           }else{
               Toast.makeText(this, "Book not deleted", Toast.LENGTH_SHORT).show();
           }



        }
    }
}
