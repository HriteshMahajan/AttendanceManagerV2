package com.example.attendancemanagerv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.attendancemanagerv2.MainActivity.db;

public class Main6Activity extends AppCompatActivity {
    TextView t1,t2,t3;
    Button plus,minus,cal,reset;
    EditText user;
    public static final String Col1="ID";
    public static final String Col2="PRESENT";
    public static final String Col3="ABSENT";
    public static final String Col4="PERCENTAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        vdata();
        physics();

    }

    public void vdata(){
        t1=(TextView)findViewById(R.id.textView50);
        t2=(TextView)findViewById(R.id.textView51);
        t3=(TextView)findViewById(R.id.textView52);
        Cursor res=db.rawQuery("select * from physics",null);
        //Toast.makeText(Main5Activity.this,res.getCount(),Toast.LENGTH_SHORT).show();

        if(res.getCount()==0) {
            physics();
        } else {
            res.moveToLast();
            t1.setText(res.getString(1));
            t2.setText(res.getString(2));
            t3.setText(res.getString(3));
        }
    }
    public void physics(){
        t1=(TextView)findViewById(R.id.textView50);
        t2=(TextView)findViewById(R.id.textView51);
        t3=(TextView)findViewById(R.id.textView52);
        plus=(Button)findViewById(R.id.button32);
        minus=(Button)findViewById(R.id.button31);
        cal=(Button)findViewById(R.id.button33);
        user=(EditText)findViewById(R.id.editText5);
        reset=(Button)findViewById(R.id.button34);


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double i=Double.parseDouble(t1.getText().toString());
                double j=Double.parseDouble(t2.getText().toString());
                i++;
                t1.setText(Integer.toString((int)i));
                double per=(i/(i+j))*100;
                t3.setText(Integer.toString((int)per));
                //Toast.makeText(Main6Activity.this,user.getText().toString(),Toast.LENGTH_SHORT).show();
                sdata();

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double i=Double.parseDouble(t1.getText().toString());
                double j=Double.parseDouble(t2.getText().toString());
                j++;
                t2.setText(Integer.toString((int)j));
                double per=(i/(i+j))*100;
                t3.setText(Integer.toString((int)per));
                sdata();
            }
        });
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double i=Double.parseDouble(t1.getText().toString());
                double j=Double.parseDouble(t2.getText().toString());
                double clas=3*j-i;
                if(clas>0) {
                    Toast.makeText(Main6Activity.this, "You need to attend " + (int) clas + " classes to get back on track", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Main6Activity.this, "You are on track", Toast.LENGTH_SHORT).show();
                }


            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText(Integer.toString(0));
                t2.setText(Integer.toString(0));
                t3.setText(Integer.toString(0));
                sdata();

            }
        });
    }
    public void sdata(){
        t1=(TextView)findViewById(R.id.textView50);
        t2=(TextView)findViewById(R.id.textView51);
        t3=(TextView)findViewById(R.id.textView52);
        ContentValues content=new ContentValues();
        content.put(Col2,t1.getText().toString());
        content.put(Col3,t2.getText().toString());
        content.put(Col4,t3.getText().toString());
        db.insert("physics",null,content);
        //db.update("maths",content,"ID=1",null);
        //db.execSQL("update maths set Col2='20' where id=1");
    }


}

