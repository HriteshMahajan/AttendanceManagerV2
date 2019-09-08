package com.example.attendancemanagerv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.attendancemanagerv2.MainActivity.db;

public class Main5Activity extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    Button plus,minus,cal,reset;
    public static final String Col1="ID";
    public static final String Col5="SUB";
    public static final String Col2="PRESENT";
    public static final String Col3="ABSENT";
    public static final String Col4="PERCENTAGE";
    static SQLiteDatabase attn_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        db=openOrCreateDatabase("student.db",MODE_PRIVATE,null);
        db.execSQL("update maths set SUB='"+"Numerical Analysis"+"' where ID=1");
        db.execSQL("update maths set SUB='"+"Operating Systems"+"' where ID=2");
        db.execSQL("update maths set SUB='"+"Computer Networking"+"' where ID=3");
        db.execSQL("update maths set SUB='"+"Discrete Mathematics"+"' where ID=4");
        db.execSQL("update maths set SUB='"+"Engineering Drawing 2"+"' where ID=5");
        db.execSQL("update maths set SUB='"+"Invention and Innovation"+"' where ID=6");
        db.execSQL("update maths set SUB='"+"Engineering Materials"+"' where ID=7");


        attn_db = openOrCreateDatabase("student.db", MODE_PRIVATE, null);

        vdata();
        maths();
        //sdata();

    }
    public void vdata(){
        t1=(TextView)findViewById(R.id.textView42);
        t2=(TextView)findViewById(R.id.textView41);
        t3=(TextView)findViewById(R.id.textView44);
        t4=(TextView)findViewById(R.id.textView40);
        t4.setText(getIntent().getExtras().getString("subject"));
        //Cursor res=db.rawQuery("select * from maths",null);
        Cursor res=db.rawQuery("select * from maths where SUB='"+ t4.getText().toString() +"'",null);
        //Toast.makeText(Main5Activity.this,res.getCount(),Toast.LENGTH_SHORT).show();

        if(res.getCount()==0) {
           maths();
        } else {
            while (res.moveToNext()) {
                //res.moveToLast();
                t1.setText(res.getString(1));
                t2.setText(res.getString(2));
                t3.setText(res.getString(3));
            }
        }
    }
    public void maths(){
        t1=(TextView)findViewById(R.id.textView42);
        t2=(TextView)findViewById(R.id.textView41);
        t3=(TextView)findViewById(R.id.textView44);
        plus=(Button)findViewById(R.id.button22);
        minus=(Button)findViewById(R.id.button21);
        cal=(Button)findViewById(R.id.button23);
        reset=(Button)findViewById(R.id.button24);


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double i=Double.parseDouble(t1.getText().toString());
                double j=Double.parseDouble(t2.getText().toString());
                i++;
                t1.setText(Integer.toString((int)i));
                double per=(i/(i+j))*100;
                t3.setText(Integer.toString((int)per));
               // Toast.makeText(Main5Activity.this,)
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
                    Toast.makeText(Main5Activity.this, "You need to attend " + (int) clas + " classes to get back on track", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Main5Activity.this, "You are on track", Toast.LENGTH_SHORT).show();
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
        t1=(TextView)findViewById(R.id.textView42);
        t2=(TextView)findViewById(R.id.textView41);
        t3=(TextView)findViewById(R.id.textView44);
        t4=(TextView)findViewById(R.id.textView40);
       ContentValues content=new ContentValues();
        content.put(Col2,t1.getText().toString());
        content.put(Col3,t2.getText().toString());
        content.put(Col4,t3.getText().toString());
        db.insert("maths",null,content);
        //db.update("maths",content,"SUB='"+t4.getText().toString()+"'",null);
        //db.execSQL("update maths set Col2='20' where id=1");
        db.execSQL("update maths set PRESENT='"+ t1.getText().toString() +"' where SUB='"+t4.getText().toString()+"'");
        db.execSQL("update maths set ABSENT='"+ t2.getText().toString() +"' where SUB='"+t4.getText().toString()+"'");
        db.execSQL("update maths set PERCENTAGE='"+ t3.getText().toString() +"' where SUB='"+t4.getText().toString()+"'");

    }
}

