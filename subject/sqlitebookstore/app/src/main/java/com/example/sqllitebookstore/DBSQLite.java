package com.example.sqllitebookstore;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

public class DBSQLite extends SQLiteOpenHelper {

    public DBSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE users(name text,email text,types text)");
        db.execSQL("CREATE TABLE books(name text,isbn text,price real)");

    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
}
