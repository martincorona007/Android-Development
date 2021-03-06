package com.example.pv_sisto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class homeActivity extends AppCompatActivity {
    EditText text_1,text_2,text_search,text2,text3,text4,text5,text6,text7,text8,text9;
    String login;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    Cursor consult;
    String store;
    TextView ivat, totalt, subTotalt;
    TextView r1,r2,r3,r4,r5,r6,r7,r8;
    boolean sect_1,sect_2,sect_3,sect_4;
    boolean aux_1,aux_2,aux_3,aux_4;
    int iter=0,n=0;
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
    public void viewSales(View view){
        Intent act=new Intent(this,view_sales_Activity.class);
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
                iter-=1;
                Toast.makeText(this, "Product do not exist", Toast.LENGTH_SHORT).show();
            }

        }

    }



    public void enableButtonSearch(){
        if((sect_1==true&&sect_2==true)&&(sect_3==true&&sect_4==true)){
            btn6.setEnabled(false);
        }
    }
    public void calculate(View view){

        int a1=0,a2=0,a3=0,a4=0;
        double iva,total,sub_total,res1=0,res2=0,res3=0,res4=0;
        double c1=0,c2=0,c3=0,c4=0;
        DecimalFormat newFormat = new DecimalFormat("#.##");

        if(iter==1){
            aux_1=true;
        }else if(iter==2){
            aux_2=true;
            aux_1=true;

        }else if(iter==3){
            aux_3=true;
            aux_2=true;
            aux_1=true;

        }else if(iter==4){
            aux_4=true;
            aux_3=true;
            aux_2=true;
            aux_1=true;

        }
        if(aux_1){
            if(text2.getText().toString().isEmpty()){
                Toast.makeText(this, "Quantity cannot be empty", Toast.LENGTH_SHORT).show();

            }else{
            n+=a1=Integer.parseInt(text2.getText().toString());
            c1=Double.parseDouble(r1.getText().toString());
            res1=Double.valueOf(newFormat.format(a1*c1));
            r5.setText(String.valueOf(res1));
            }
        }
        if(aux_2){
            if(text3.getText().toString().isEmpty()){

                Toast.makeText(this, "Quantity cannot be empty", Toast.LENGTH_SHORT).show();

            }else{
                n+=a2=Integer.parseInt(text3.getText().toString());
                c2=Double.parseDouble(r2.getText().toString());
                res2=Double.valueOf(newFormat.format(a2*c2));
                r6.setText(String.valueOf(res2));
            }


        }
        if(aux_3){
            if(text4.getText().toString().isEmpty()){

                Toast.makeText(this, "Quantity cannot be empty", Toast.LENGTH_SHORT).show();

            }else{
                n+=a3=Integer.parseInt(text4.getText().toString());
                c3=Double.parseDouble(r3.getText().toString());
                res3=Double.valueOf(newFormat.format(a3*c3));
                r7.setText(String.valueOf(res3));
            }
        }
        if(aux_4){
            if(text5.getText().toString().isEmpty()){

                Toast.makeText(this, "Quantity cannot be empty", Toast.LENGTH_SHORT).show();

            }else{
                n+=a4=Integer.parseInt(text5.getText().toString());
                c4=Double.parseDouble(r4.getText().toString());
                res4=Double.valueOf(newFormat.format(a4*c4));
                r8.setText(String.valueOf(res4));
            }


        }

        sub_total=res1+res2+res3+res4;
        iva=sub_total*0.16;
        total=sub_total+iva;



        subTotalt.setText(newFormat.format(sub_total));
        ivat.setText(newFormat.format(iva));
        totalt.setText(newFormat.format(total));
    }
    public void sellProducts(View view){
        DBSQLite gestorr=new DBSQLite(this,"prueba",null,1);
        SQLiteDatabase DB1=gestorr.getReadableDatabase();


        String subT=subTotalt.getText().toString();
        String iv=ivat.getText().toString();
        String tot=totalt.getText().toString();

        if(subT.isEmpty()||iv.isEmpty()||tot.isEmpty()||iter==0){
            Toast.makeText(this,"Can not make a sell",Toast.LENGTH_SHORT).show();
        }else{

            Cursor consultaTemp;

            ContentValues register=new ContentValues();
            register.put("subtot",Double.parseDouble(subT));
            register.put("iv",Double.parseDouble(iv));
            register.put("tota",Double.parseDouble(tot));
            register.put("quantit",n);
            DB1.insert("sales_a",null,register);


            Toast.makeText(this, "Sale added successfully", Toast.LENGTH_SHORT).show();

            DB1.close();

            r1.setText("0.0");
            r2.setText("0.0");
            r3.setText("0.0");
            r4.setText("0.0");

            r5.setText("0.0");
            r6.setText("0.0");
            r7.setText("0.0");
            r8.setText("0.0");

            subTotalt.setText("0.0");
            ivat.setText("0.0");
            totalt.setText("0.0");

            text2.setText("");
            text3.setText("");
            text4.setText("");
            text5.setText("");

            text6.setText("");
            text7.setText("");
            text8.setText("");
            text9.setText("");
            text_search.setText("");
            iter=0;
            aux_1=false;
            aux_2=false;
            aux_3=false;
            aux_4=false;
            int a1=0,a2=0,a3=0,a4=0;
            double iva,total,sub_total,res1=0,res2=0,res3=0,res4=0;
            double c1=0,c2=0,c3=0,c4=0;
        }

    }

}
