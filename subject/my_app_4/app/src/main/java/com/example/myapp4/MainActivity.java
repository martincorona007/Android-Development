package com.example.myapp4;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView ivat;
    TextView totalt;
    TextView subTotalt;
    TextView r1;
    TextView r2;
    TextView r3;

    EditText txt1;
    EditText txt2;
    EditText txt3;
    EditText txt4;
    EditText txt5;
    EditText txt6;
    EditText txt7;
    EditText txt8;
    EditText txt9;
    Button btn1;
    boolean a1,a2,a3,a4,a5,a6,a7,a8,a9;
    boolean sect_1,sect_2,sect_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=(EditText) findViewById(R.id.txt_1);//
        txt2=(EditText)findViewById(R.id.txt_2);
        txt3=(EditText)findViewById(R.id.txt_3);//
        txt4=(EditText)findViewById(R.id.txt_4);//
        txt5=(EditText)findViewById(R.id.txt_5);
        txt6=(EditText)findViewById(R.id.txt_6);//
        txt7=(EditText)findViewById(R.id.txt_7);//
        txt8=(EditText)findViewById(R.id.txt_8);
        txt9=(EditText)findViewById(R.id.txt_9);//
        r1=findViewById(R.id.txt_view11);
        r2=findViewById(R.id.txt_view12);
        r3=findViewById(R.id.txt_view13);
        totalt=findViewById(R.id.txt_view9);
        ivat=findViewById(R.id.txt_view8);
        subTotalt=findViewById(R.id.txt_view7);
        btn1=findViewById(R.id.button);

        txt1.addTextChangedListener(operationWatcher);
        txt2.addTextChangedListener(operationWatcher);
        txt3.addTextChangedListener(operationWatcher);
        txt4.addTextChangedListener(operationWatcher);
        txt5.addTextChangedListener(operationWatcher);
        txt6.addTextChangedListener(operationWatcher);
        txt7.addTextChangedListener(operationWatcher);
        txt8.addTextChangedListener(operationWatcher);
        txt9.addTextChangedListener(operationWatcher);
    }

    private TextWatcher operationWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(txt1.hasFocus()){
                try{
                    a1=true;
                }catch (Exception e){

                }
            }
            if(txt2.hasFocus()){
                try{
                    a2=true;
                }catch (Exception e){

                }
            }
            if(txt3.hasFocus()){
                try{
                    a3=true;
                }catch (Exception e){

                }
            }

            /*===================================================*/
            if(txt4.hasFocus()){
                try{
                    a4=true;
                }catch (Exception e){

                }
            }
            if(txt5.hasFocus()){
                try{
                    a5=true;
                }catch (Exception e){

                }
            }
            if(txt6.hasFocus()){
                try{
                    a6=true;
                }catch (Exception e){

                }
            }

            /*========================================================*/
            if(txt7.hasFocus()){
                try{
                    a7=true;
                }catch (Exception e){

                }
            }
            if(txt8.hasFocus()){
                try{
                    a8=true;
                }catch (Exception e){

                }
            }
            if(txt9.hasFocus()){
                try{
                    a9=true;
                }catch (Exception e){

                }
            }
            /*====================================================*/
            /*====================================================*/
            /*====================================================*/
            if(a1==true ){
                if(a2==true){
                    if(a3==true){
                        sect_1=true;
                    }
                }
            }
            if(a4==true ){
                if(a5==true){
                    if(a6==true){
                        sect_2=true;
                    }
                }
            }
            if(a7==true ){
                if(a8==true){
                    if(a9==true){
                        sect_3=true;
                    }
                }
            }
            if(sect_1){
                int a1,b2,sub_total=0,res1;
                double iva,total;

                a1=Integer.parseInt(txt1.getText().toString());
                b2=Integer.parseInt(txt3.getText().toString());

                res1=a1*b2;

                sub_total+=res1;
                iva=sub_total*0.16;
                total=sub_total+iva;
                //Log.d("CREATION ",String.valueOf(a1));

                r1.setText(String.valueOf(res1));
                subTotalt.setText(String.valueOf(sub_total));
                ivat.setText(Double.toString(iva));
                totalt.setText(Double.toString(total));
            }
            if(sect_1 && sect_2){
                int a1,b2,a2,b3,sub_total,res1,res2;
                double iva,total;

                a1=Integer.parseInt(txt1.getText().toString());
                b2=Integer.parseInt(txt3.getText().toString());
                a2=Integer.parseInt(txt4.getText().toString());
                b3=Integer.parseInt(txt6.getText().toString());

                res1=a1*b2;
                res2=a2*b3;

                sub_total=res1+res2;
                iva=sub_total*0.16;
                total=sub_total+iva;
                //Log.d("CREATION ",String.valueOf(a1));

                r1.setText(String.valueOf(res1));
                r2.setText(String.valueOf(res2));
                subTotalt.setText(String.valueOf(sub_total));
                ivat.setText(Double.toString(iva));
                totalt.setText(Double.toString(total));
            }
            if(sect_1 && sect_2 && sect_3){
                int a1,b2,a2,b3,a3,b4,sub_total,res1,res2,res3;
                double iva,total;

                a1=Integer.parseInt(txt1.getText().toString());
                b2=Integer.parseInt(txt3.getText().toString());
                a2=Integer.parseInt(txt4.getText().toString());
                b3=Integer.parseInt(txt6.getText().toString());
                a3=Integer.parseInt(txt7.getText().toString());
                b4=Integer.parseInt(txt9.getText().toString());

                res1=a1*b2;
                res2=a2*b3;
                res3=a3*b4;
                sub_total=res1+res2+res3;
                iva=sub_total*0.16;
                total=sub_total+iva;
                //Log.d("CREATION ",String.valueOf(a1));

                r1.setText(String.valueOf(res1));
                r2.setText(String.valueOf(res2));
                r3.setText(String.valueOf(res3));
                subTotalt.setText(String.valueOf(sub_total));
                ivat.setText(Double.toString(iva));
                totalt.setText(Double.toString(total));
            }

            /*==================================================*/
        }

        @Override
        public void afterTextChanged(Editable s) {

        }

    };
    public void operation(){
            txt3.setText(null);
            txt2.setText(null);
            txt1.setText(null);
         /*   txt4.getText().clear();
            txt5.getText().clear();
            txt6.getText().clear();
            txt7.getText().clear();
            txt8.getText().clear();
            txt9.getText().clear();*/
  /*          r1.setText("");
            r2.setText("");
            r3.setText("");
            totalt.setText("");
            ivat.setText("");
            subTotalt.setText("");
*/

    }
}
