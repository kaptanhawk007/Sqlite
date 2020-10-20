package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper=new DatabaseHelper(this);
        try  {
            SQLiteDatabase database = databaseHelper.getWritableDatabase();
            database.query("students",null,null,null,null,null,null);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}