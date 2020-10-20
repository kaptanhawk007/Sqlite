package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import javax.xml.xpath.XPathFactory;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="university";
    public static final int DB_VERSION=1;



    public DatabaseHelper(@Nullable Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlStatements="CREATE TABLE students(id int PRIMARY KEY, name TEXT,email TEXT);";
        db.execSQL(sqlStatements);

        ContentValues values= new ContentValues();
        values.put("id",1);
        values.put("name","Kaptan");
        values.put("email","kaptanyadav007@gmail.com");
        long id=db.insert("students",null,values);
        ContentValues secondValues= new ContentValues();
        secondValues.put("name","Muneem");
        secondValues.put("email","Muneem@gmail.com");
        secondValues.put("id",2);
        db.insert("students",null,secondValues);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
