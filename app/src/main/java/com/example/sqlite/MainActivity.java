package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        ArrayList<Students> student=new ArrayList<>();
        databaseHelper=new DatabaseHelper(this);
        try  {
            SQLiteDatabase database = databaseHelper.getWritableDatabase();
            Cursor cursor=database.query("students",null,null,null,null,null,null);
            if (cursor!=null){
                if(cursor.moveToFirst()){
                    for (int i=0;i<cursor.getCount();i++){
                        Students s=new Students();
                        int id=cursor.getInt(cursor.getColumnIndex("id"));
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        String email=cursor.getString(cursor.getColumnIndex("email"));
                        s.setId(id);
                        s.setName(name);
                        s.setEmail(email);
                        cursor.moveToNext();
                        student.add(s);
                    }
                    cursor.close();
                    database.close();
                }else {
                    cursor.close();
                    database.close();
                }
            }else {
                database.close();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        String text="";
        for (Students s: student){
            text +=s.getId()+"\n"+s.getName()+"\n"+s.getEmail()+"\n**************\n";

        }
        textView.setText(text);

    }
}