package com.example.pv_sisto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBSQLite extends SQLiteOpenHelper {

    public DBSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE users(name text,email text,pwas text,typer text)");
        db.execSQL("CREATE TABLE products(code INTEGER,name text,price REAL)");
        db.execSQL("CREATE TABLE sales_a(ID_ch INTEGER PRIMARY KEY AUTOINCREMENT, subtot REAL,iv REAL,tota REAL)");
        db.execSQL("CREATE TABLE sales_b(FK_ID_ch int,code int,FOREIGN KEY(FK_ID_ch) REFERENCES sales_a(ID_ch)); ");


    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
}
