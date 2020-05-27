package com.example.appx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nombre;
    private EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre=findViewById(R.id.txtNombre);
        email=findViewById(R.id.txtCorreo);
        SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
        nombre.setText(preferencias.getString("nombre","" ));
        email.setText(preferencias.getString("email","" ));
    }
    public void guardarPreferencias(View view){
        SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =preferencias.edit();
        editor.putString("nombre",nombre.getText().toString());
        editor.putString("email",email.getText().toString());

        editor.commit();

    }

}
