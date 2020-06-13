package com.example.pv_sisto;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class view_Products_Activity extends AppCompatActivity {

    ListView listViewProducts;
    ArrayList<String> listaInformacion;
    ArrayList<cls_product> listaProducts;
    DBSQLite conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__products_);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        conn=new DBSQLite(this,"prueba",null,1);
        listViewProducts=(ListView)findViewById(R.id.listViewProducts);
        consultProduct();

        //present the info
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        listViewProducts.setAdapter(adapter);
        /*

        text_1.setText(consult.getString(0));
        text_2.setText(consult.getString(1));
        text_3.setText(consult.getString(2));*/


    }

    private void consultProduct() {
        SQLiteDatabase DB=conn.getReadableDatabase();
        cls_product product=null;
        listaProducts=new ArrayList<cls_product>();
        Cursor cursor=DB.rawQuery("SELECT * FROM products",null);
        while (cursor.moveToNext()){
            product=new cls_product();
            product.setCode(cursor.getInt(0));
            product.setName(cursor.getString(1));
            product.setPrice(cursor.getDouble(2));
            listaProducts.add(product);
        }
        getList();
    }

    private void getList() {
        listaInformacion=new ArrayList<String>();
        for (int i=0; i<listaProducts.size();i++){
            listaInformacion.add(listaProducts.get(i).getCode()+"   "+listaProducts.get(i).getName()+"   "+listaProducts.get(i).getPrice());
        }
    }
/*
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
    }*/
}
