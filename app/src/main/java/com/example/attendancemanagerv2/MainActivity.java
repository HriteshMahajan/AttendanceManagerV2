package com.example.attendancemanagerv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    static SQLiteDatabase db;
    public static final String databasename="student.db";
    public static final String tablename="table";
    public static final String Col1="ID";
    public static final String Col2="Name";
    public static final String Col3="email";
    public static final String Col4="password";
    public static final String Col5="mobile";
Button login,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("student.db", MODE_PRIVATE, null);
        db.execSQL("create table if not exists tablename (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, EMAIL TEXT, PASSWORD TEXT,MOBILE INTEGER)");
        db.execSQL("create table if not exists maths (ID INTEGER PRIMARY KEY AUTOINCREMENT , PRESENT TEXT,ABSENT TEXT ,PERCENTAGE TEXT, SUB TEXT)");
        db.execSQL("create table if not exists physics (ID INTEGER PRIMARY KEY AUTOINCREMENT , PRESENT TEXT,ABSENT TEXT ,PERCENTAGE TEXT)");
    }
    public void l(View v){
        Intent i=new Intent(this,Main3Activity.class);
        startActivity(i);
        finish();

    }

    public void s(View v){
        Intent i=new Intent(this,Main2Activity.class);
        startActivity(i);
        finish();
    }
    public void skip(View v){
        Intent i=new Intent(this,Main8Activity.class);
        startActivity(i);
        finish();
    }
}
