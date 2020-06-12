package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etUsuario, etContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario=findViewById(R.id.etUsuario);
        etContrasena=findViewById(R.id.etContrasena);

        String usuario=etUsuario.getText().toString();
        String contrasena=etContrasena.getText().toString();

        GestorSQLite gestor=new GestorSQLite(this,"usuarios",null,1);
        SQLiteDatabase baseDeDatos=gestor.getWritableDatabase();

        Cursor consulta= baseDeDatos.rawQuery("SELECT * FROM tblUsuarios",null);
        if(!consulta.moveToFirst()){
            ContentValues registro=new ContentValues();
            registro.put("usuario","admin");
            registro.put("contrasena","admin");
            baseDeDatos.insert("tblUsuarios",null,registro);
            baseDeDatos.close();
            Toast.makeText(this, "Se ha creado usuario predetermionado admin:admin", Toast.LENGTH_SHORT).show();
        }
    }

    public void consultarUsuario(View view){
        GestorSQLite gestor=new GestorSQLite(this,"usuarios",null,1);
        SQLiteDatabase baseDeDatos=gestor.getReadableDatabase();

        String usuario=etUsuario.getText().toString();
        String contrasena=etContrasena.getText().toString();

        if(usuario.isEmpty()||contrasena.isEmpty())
            Toast.makeText(this,"Usuario o contraseña no puede ser vacio",Toast.LENGTH_SHORT).show();
        else {

            Cursor registro= baseDeDatos.rawQuery("SELECT * FROM tblUsuarios WHERE usuario='"+usuario+"' AND contrasena='"+contrasena+"'",null);
            if(registro.moveToFirst()) {
                Toast.makeText(this, "Usuario valido", Toast.LENGTH_SHORT).show();
                baseDeDatos.close();
                Intent actvMovUsuarios = new Intent(this, MovUsuarios.class);
                actvMovUsuarios.putExtra("login",usuario.toString());
                startActivity(actvMovUsuarios);
            }
            else
                Toast.makeText(this,"Usuario o contraseña incorrectos",Toast.LENGTH_SHORT).show();
            baseDeDatos.close();
        }
    }
}
