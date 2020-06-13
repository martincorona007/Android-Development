package com.example.pv_sisto;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class delete_Product_Activity extends AppCompatActivity {
    EditText text_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete__product_);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        text_1=findViewById(R.id.txt_1);
    }
    public void deleteProduct(View view){
        String s1=text_1.getText().toString();

        if(s1.isEmpty()){
            Toast.makeText(this,"Some field can't be empty",Toast.LENGTH_SHORT).show();
        }else{
            DBSQLite gestor=new DBSQLite(this,"prueba",null,1);
            SQLiteDatabase DB1=gestor.getWritableDatabase();

            int consultaTemp = DB1.delete("products "," code='" + s1 + "'", null);
            if(consultaTemp>0){
                Toast.makeText(this, "Product deleted", Toast.LENGTH_SHORT).show();
                text_1.setText("");
            }else{
                Toast.makeText(this, "Product not deleted", Toast.LENGTH_SHORT).show();
            }



        }
    }
}
