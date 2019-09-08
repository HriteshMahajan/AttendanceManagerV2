package com.example.attendancemanagerv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }
    public void  math(View v){
        Intent i=new Intent(this,Main5Activity.class);
        startActivity(i);
        finish();
    }
    public void  physic(View v){
        Intent i=new Intent(this,Main6Activity.class);
        startActivity(i);
        finish();
    }
    /*public void  feedback(View v){
        Intent i=new Intent(this,Main4Activity.class);
        startActivity(i);
    }*/
    public void  login(View v){
        Intent i=new Intent(this,Main3Activity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
