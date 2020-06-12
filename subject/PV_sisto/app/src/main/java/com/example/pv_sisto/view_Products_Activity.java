package com.example.pv_sisto;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class view_Products_Activity extends AppCompatActivity {
    Cursor consult;
    EditText text_1,text_2,text_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__products_);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        text_1=findViewById(R.id.txt_1);
        text_2=findViewById(R.id.txt_2);
        text_3=findViewById(R.id.txt_3);

        DBSQLite gestor=new DBSQLite(this,"prueba",null,1);
        SQLiteDatabase DB=gestor.getReadableDatabase();

        consult=DB.rawQuery("SELECT * FROM products",null);
        consult.moveToFirst();

        text_1.setText(consult.getString(0));
        text_2.setText(consult.getString(1));
        text_3.setText(consult.getString(2));
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
}
