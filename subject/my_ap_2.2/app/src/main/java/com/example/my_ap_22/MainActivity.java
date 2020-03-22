package com.example.my_ap_22;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=findViewById(R.id.txt_1);//
        txt2=findViewById(R.id.txt_2);
        txt3=findViewById(R.id.txt_3);//
        txt4=findViewById(R.id.txt_4);//
        txt5=findViewById(R.id.txt_5);
        txt6=findViewById(R.id.txt_6);//
        txt7=findViewById(R.id.txt_7);//
        txt8=findViewById(R.id.txt_8);
        txt9=findViewById(R.id.txt_9);//
        r1=findViewById(R.id.txt_view11);
        r2=findViewById(R.id.txt_view12);
        r3=findViewById(R.id.txt_view13);
        totalt=findViewById(R.id.txt_view9);
        ivat=findViewById(R.id.txt_view8);
        subTotalt=findViewById(R.id.txt_view7);
        btn1=findViewById(R.id.button);

    }
    public void operation(View v){
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

}
