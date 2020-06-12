package com.example.pv_sisto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class homeActivity extends AppCompatActivity {
    EditText text_1,text_2,text_search,text2,text3,text4,text5,text6,text7,text8,text9;
    String login;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    Cursor consult;
    String store;
    TextView ivat, totalt, subTotalt;
    TextView r1,r2,r3,r4,r5,r6,r7,r8;
    boolean sect_1,sect_2,sect_3,sect_4;
    boolean add_1,add_2,add_3,add_4;
    int iter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        login=getIntent().getStringExtra("log");

        text_search=findViewById(R.id.txt_1);
        text2=findViewById(R.id.txt_2);
        text3=findViewById(R.id.txt_3);
        text4=findViewById(R.id.txt_4);
        text5=findViewById(R.id.txt_5);
        text6=findViewById(R.id.txt_6);
        text7=findViewById(R.id.txt_7);
        text8=findViewById(R.id.txt_8);
        text9=findViewById(R.id.txt_9);

        btn1=findViewById(R.id.btn_1);
        btn2=findViewById(R.id.btn_2);
        btn3=findViewById(R.id.btn_3);
        btn4=findViewById(R.id.btn_4);
        btn5=findViewById(R.id.btn_5);
        btn6=findViewById(R.id.btn_6);

        /*=====================================*/
        r1=findViewById(R.id.lbl_5);
        r2=findViewById(R.id.lbl_6);
        r3=findViewById(R.id.lbl_7);
        r4=findViewById(R.id.lbl_8);

        r5=findViewById(R.id.lbl_9);
        r6=findViewById(R.id.lbl_10);
        r7=findViewById(R.id.lbl_11);
        r8=findViewById(R.id.lbl_12);
        /*=====================================*/
        subTotalt=findViewById(R.id.lbl_21);
        ivat=findViewById(R.id.lbl_22);
        totalt=findViewById(R.id.lbl_23);
        /*=====================================*/

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

    }
    public void addProduct(View view){
        Intent act=new Intent(this,add_Product_Activity.class);
        startActivity(act);
    }
    public void deleteProduct(View view){
        Intent act=new Intent(this,delete_Product_Activity.class);
        startActivity(act);
    }
    public void updateProduct(View view){
        Intent act=new Intent(this,update_Product_Activity.class);
        startActivity(act);
    }
    public void viewProduct(View view){
        Intent act1=new Intent(this,view_Products_Activity.class);
        startActivity(act1);
    }
    public void addAdmin(View view){
        Intent act=new Intent(this,add_admin_Activity.class);
        startActivity(act);
    }
    public void addUser(View view){
        Intent act=new Intent(this,add_user_Activity.class);
        startActivity(act);
    }
    public void searchProduct(View view){
        String is=text_search.getText().toString();
        store=is;
        iter+=1;

        if(is.isEmpty()){
            Toast.makeText(this,"Fill is empty",Toast.LENGTH_SHORT).show();
        }else{
            DBSQLite gestor=new DBSQLite(this,"prueba",null,1);
            SQLiteDatabase DB1=gestor.getWritableDatabase();

            Cursor consult;
            consult = DB1.rawQuery("SELECT * FROM products WHERE code='" + is + "'", null);
            if(consult.moveToFirst()){
                if(iter==1){
                    text6.setText(consult.getString(1));
                    r1.setText(consult.getString(2));

                    sect_1=true;
                }
                if(iter==2){
                    text7.setText(consult.getString(1));
                    r2.setText(consult.getString(2));
                    sect_2=true;

                }
                if(iter==3){
                    text8.setText(consult.getString(1));
                    r3.setText(consult.getString(2));
                    sect_3=true;

                }
                if(iter==4){
                    text9.setText(consult.getString(1));
                    r4.setText(consult.getString(2));
                    sect_4=true;
                }
                enableButtonSearch();
                Toast.makeText(this, "Product Added", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Product do not exist", Toast.LENGTH_SHORT).show();
            }

        }

    }
    public void enableButtonSearch(){
        if((sect_1==true&&sect_2==true)&&(sect_3==true&&sect_4==true)){
            btn6.setEnabled(false);
        }
    }

}
