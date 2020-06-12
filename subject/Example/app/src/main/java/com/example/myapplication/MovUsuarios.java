package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
public class MovUsuarios extends AppCompatActivity {

    EditText etUsuario, etContrasena;
    ImageButton imgBtnAgregar, imgBtnEliminar, imgBtnActualizar;
    String login;

    GestorSQLite gestor;
    SQLiteDatabase baseDeDatos;

    Cursor consulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mov_usuarios);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        login= getIntent().getStringExtra("login");

        etUsuario=findViewById(R.id.etUsuario);
        etContrasena=findViewById(R.id.etContrasena);
        imgBtnAgregar=findViewById(R.id.imgBtnAgregar);
        imgBtnEliminar=findViewById(R.id.imgBtnEliminar);
        imgBtnActualizar=findViewById(R.id.imgBtnActualizar);

        if(login.equals("admin")){
            imgBtnAgregar.setVisibility(View.VISIBLE);
            imgBtnEliminar.setVisibility(View.VISIBLE);
            imgBtnActualizar.setVisibility(View.VISIBLE);
        }else{
            imgBtnAgregar.setVisibility(View.INVISIBLE);
            imgBtnEliminar.setVisibility(View.INVISIBLE);
            imgBtnActualizar.setVisibility(View.INVISIBLE);
        }

        gestor=new GestorSQLite(this,"usuarios",null,1);
        baseDeDatos=gestor.getReadableDatabase();

        consulta= baseDeDatos.rawQuery("SELECT * FROM tblUsuarios",null);

        consulta.moveToFirst();
        etUsuario.setText(consulta.getString(0));
        etContrasena.setText(consulta.getString(1));
    }

    public void cargarMainActivity(View view){
        Intent actvMain=new Intent(this,MainActivity.class);
        startActivity(actvMain);
    }

    public void siguiente(View view){
        if(!consulta.moveToNext()) consulta.moveToLast();

        etUsuario.setText(consulta.getString(0));
        etContrasena.setText(consulta.getString(1));
    }

    public void anterior(View view){
        if(!consulta.moveToPrevious()) consulta.moveToFirst();

        etUsuario.setText(consulta.getString(0));
        etContrasena.setText(consulta.getString(1));
    }

    public void agregar(View view){
        String usuario=etUsuario.getText().toString();
        String contrasena=etContrasena.getText().toString();

        if(usuario.isEmpty()||contrasena.isEmpty())
            Toast.makeText(this,"Usuario o contraseña no puede ser vacio",Toast.LENGTH_SHORT).show();
        else {
            Cursor consultaTemp;
            consultaTemp = baseDeDatos.rawQuery("SELECT * FROM tblUsuarios WHERE usuario='" + usuario + "'", null);
            if (!consultaTemp.moveToFirst()) {
                ContentValues registro = new ContentValues();
                registro.put("usuario", usuario);
                registro.put("contrasena", contrasena);
                baseDeDatos.insert("tblUsuarios", null, registro);
                consulta = baseDeDatos.rawQuery("SELECT * FROM tblUsuarios", null);
                consulta.moveToLast();
                //baseDeDatos.close();
                Toast.makeText(this, "Usuario Registrado", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Ya existe el usuario", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void eliminar(View view){
        String usuario=etUsuario.getText().toString();
        if(!usuario.equals("admin")) {
            int eliminados = baseDeDatos.delete("tblUsuarios", "usuario='" + usuario + "'", null);
            if (eliminados > 0) {
                Toast.makeText(this, "Usuario eliminado", Toast.LENGTH_SHORT).show();
                consulta = baseDeDatos.rawQuery("SELECT * FROM tblUsuarios", null);
                etUsuario.setText("");
                etContrasena.setText("");
            } else {
                Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show();
            }
        }else
            Toast.makeText(this, "No puede eliminar al administrador", Toast.LENGTH_SHORT).show();
    }

    public void actualizar(View view){
        String usuario=etUsuario.getText().toString();
        String contrasena=etContrasena.getText().toString();

        if(usuario.isEmpty()||contrasena.isEmpty())
            Toast.makeText(this,"Usuario o contraseña no puede ser vacio",Toast.LENGTH_SHORT).show();
        else {
            Cursor consultaTemp;
            consultaTemp = baseDeDatos.rawQuery("SELECT * FROM tblUsuarios WHERE usuario='" + usuario + "'", null);
            if (consultaTemp.moveToFirst()) {
                ContentValues registro = new ContentValues();
                registro.put("usuario", usuario);
                registro.put("contrasena", contrasena);
                baseDeDatos.update("tblUsuarios",registro,"usuario='"+usuario+"'",null);
                consulta = baseDeDatos.rawQuery("SELECT * FROM tblUsuarios", null);
                //consulta.moveToLast();
                //baseDeDatos.close();
                Toast.makeText(this, "Contraseña actualizada", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "No existe el usuario", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
