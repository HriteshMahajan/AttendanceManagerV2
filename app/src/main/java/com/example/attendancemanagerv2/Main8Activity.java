package com.example.attendancemanagerv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main8Activity extends AppCompatActivity {
    TextView nameu;
    ListView list;
    ArrayList<String> names=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
       // nameu=(TextView)findViewById(R.id.textVie82);
        //nameu.setText("Hi!! "+getIntent().getExtras().getString("value"));
        lists();
    }
    public void lists(){
        list=(ListView)findViewById(R.id.list2);
        names.add("Numerical Analysis");
        names.add("Operating Systems");
        names.add("Computer Networks");
        names.add("Engineering Drawing 2");
        names.add("Discrete Mathematics");
        names.add("Invention and Innovation");
        names.add("Engineering Materials");
        ArrayAdapter<String> adapt=new ArrayAdapter<String>(this,R.layout.name_list,names);
        list.setAdapter(adapt);
        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String val =(String) list.getItemAtPosition(i);
                        Intent a=new Intent("android.intent.action.mat");
                        a.putExtra("subject",val);
                        startActivity(a);
                    }
                }
        );
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
    public void  login(View v){
        Intent i=new Intent(this,Main3Activity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        finish();
    }
}