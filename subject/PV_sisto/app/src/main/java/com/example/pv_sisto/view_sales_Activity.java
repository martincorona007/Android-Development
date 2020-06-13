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

public class view_sales_Activity extends AppCompatActivity {
    ListView listViewSales;
    ArrayList<cls_sales> listaSalesA;
    ArrayList<String> listaInformacion;



    DBSQLite conn;
  //EditText text_1,text_2,text_3,text_4,text_5;
   // Cursor consult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_sales_);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        conn=new DBSQLite(this,"prueba",null,1);
        listViewSales=(ListView)findViewById(R.id.listViewSales);

        consultSalesA();


        //present the info
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        listViewSales.setAdapter(adapter);


       /* text_1=findViewById(R.id.txt_1);
        text_2=findViewById(R.id.txt_2);
        text_3=findViewById(R.id.txt_3);
        text_4=findViewById(R.id.txt_4);
        text_5=findViewById(R.id.txt_5);
        DBSQLite gestor=new DBSQLite(this,"prueba",null,1);
        SQLiteDatabase DB=gestor.getReadableDatabase();

        consult=DB.rawQuery("SELECT * FROM sales_a",null);
        consult.moveToFirst();

        text_1.setText(consult.getString(0));
       text_2.setText(consult.getString(1));
        text_3.setText(consult.getString(2));
        text_4.setText(consult.getString(3));
        text_5.setText(consult.getString(4));*/

    }
   /* public void next(View view){

        if(!consult.moveToNext()) consult.moveToLast();

        text_1.setText(consult.getString(0));
        text_2.setText(consult.getString(1));
        text_3.setText(consult.getString(2));
        text_4.setText(consult.getString(3));
        text_5.setText(consult.getString(4));
    }

    public void back(View view){
        if(consult.moveToPrevious()) consult.moveToFirst();

        text_1.setText(consult.getString(0));
        text_2.setText(consult.getString(1));
        text_3.setText(consult.getString(2));
        text_4.setText(consult.getString(3));
        text_5.setText(consult.getString(4));
    }*/






    private void consultSalesA() {
        SQLiteDatabase DB=conn.getReadableDatabase();
        cls_sales salesa=null;
        listaSalesA=new ArrayList<cls_sales>();
        Cursor cursor=DB.rawQuery("SELECT * FROM sales_a",null);
        while (cursor.moveToNext()){
            salesa=new cls_sales();
            salesa.setID_ch(cursor.getInt(0));
            salesa.setSubtot(cursor.getDouble(1));
            salesa.setIv(cursor.getDouble(2));
            salesa.setTota(cursor.getDouble(3));
            salesa.setQuantit(cursor.getInt(4));
            listaSalesA.add(salesa);
        }
        getList();
    }

    private void getList() {
        listaInformacion=new ArrayList<String>();
        for (int i=0; i<listaSalesA.size();i++){
            listaInformacion.add(listaSalesA.get(i).getID_ch()+" "+listaSalesA.get(i).getSubtot()+" "+listaSalesA.get(i).getIv()+" "+listaSalesA.get(i).getTota()+" "+listaSalesA.get(i).getQuantit());
        }
    }
}
