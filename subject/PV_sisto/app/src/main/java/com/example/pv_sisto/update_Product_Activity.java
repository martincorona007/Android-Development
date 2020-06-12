package com.example.pv_sisto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class update_Product_Activity extends AppCompatActivity {
    EditText txt1,text_1,text_2;
    String store;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__product_);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txt1=findViewById(R.id.txt_search);

        text_1=findViewById(R.id.txt_1);
        text_2=findViewById(R.id.txt_2);

    }
    public void searchProduct(View view){
        String is=txt1.getText().toString();
        store=is;
        if(is.isEmpty()){
            Toast.makeText(this,"Fill is empty",Toast.LENGTH_SHORT).show();
        }else{
            DBSQLite gestor=new DBSQLite(this,"prueba",null,1);
            SQLiteDatabase DB1=gestor.getWritableDatabase();

            Cursor consult;
            consult = DB1.rawQuery("SELECT * FROM products WHERE code='" + is + "'", null);
            if(!consult.moveToNext())
                consult.moveToLast();

            text_1.setText(consult.getString(1));
            text_2.setText(consult.getString(2));

        }
    }
    public void updateProduct(View view){
        String s1=text_1.getText().toString();
        String s2=text_2.getText().toString();

        if(s1.isEmpty()||s2.isEmpty()){
            Toast.makeText(this,"Some field can't be empty",Toast.LENGTH_SHORT).show();
        }else{
            DBSQLite gestor=new DBSQLite(this,"prueba",null,1);
            SQLiteDatabase DB1=gestor.getWritableDatabase();
            //text_1.setText(txt1.getText().toString());
            Cursor consultaTemp;
            consultaTemp = DB1.rawQuery("SELECT * FROM products WHERE code='" + store + "'", null);
            if(consultaTemp.moveToFirst()){
                ContentValues register=new ContentValues();
                register.put("name",s1);
                register.put("price",Double.parseDouble(s2));

                DB1.update("products",register,"code='"+store+"'",null);

                Toast.makeText(this, "Product Updated successfully", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Product do not exist", Toast.LENGTH_SHORT).show();
            }



        }
    }

}
