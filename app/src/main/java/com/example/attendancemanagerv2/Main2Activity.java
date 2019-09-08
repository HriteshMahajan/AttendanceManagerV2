package com.example.attendancemanagerv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.attendancemanagerv2.MainActivity.Col2;
import static com.example.attendancemanagerv2.MainActivity.Col3;
import static com.example.attendancemanagerv2.MainActivity.Col4;
import static com.example.attendancemanagerv2.MainActivity.Col5;
import static com.example.attendancemanagerv2.MainActivity.db;
public class Main2Activity extends AppCompatActivity {
/*static SQLiteDatabase db;
    public static final String databasename="student.db";
    public static final String tablename="table";
    public static final String Col1="ID";
    public static final String Col2="Name";
    public static final String Col3="email";
    public static final String Col4="password";
    public static final String Col5="mobile";*/
    Button submit;
    EditText name,email,pass,num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       // db = openOrCreateDatabase("student.db", MODE_PRIVATE, null);
        //db.execSQL("create table if not exists tablename (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, EMAIL TEXT, PASSWORD TEXT,MOBILE INTEGER)");
        insert();



    }
   public void insert(){
        name=(EditText)findViewById(R.id.editText);
        email=(EditText)findViewById(R.id.editText2);
        num=(EditText)findViewById(R.id.editText3);
        pass=(EditText)findViewById(R.id.editText4);
        submit=(Button)findViewById(R.id.button3) ;
       submit.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       if(name.getText().toString().isEmpty())
                       {
                           Toast.makeText(Main2Activity.this,"Fill Username",Toast.LENGTH_SHORT).show();
                       }
                       else if(email.getText().toString().isEmpty())
                       {
                           Toast.makeText(Main2Activity.this,"Fill Email",Toast.LENGTH_SHORT).show();
                       }
                       else if(num.getText().toString().isEmpty())
                       {
                           Toast.makeText(Main2Activity.this,"Fill Mobile No.",Toast.LENGTH_SHORT).show();
                       }
                       else if(pass.getText().toString().isEmpty())
                       {
                           Toast.makeText(Main2Activity.this,"Fill Password",Toast.LENGTH_SHORT).show();
                       }
                       else {
                           ContentValues content = new ContentValues();
                           content.put(Col2, name.getText().toString());
                           content.put(Col3, email.getText().toString());
                           content.put(Col4, pass.getText().toString());
                           content.put(Col5, num.getText().toString());
                           long result = db.insert("tablename", null, content);
                           if (result == -1) {
                               Toast.makeText(Main2Activity.this, "Some error occurred", Toast.LENGTH_SHORT).show();
                           } else {
                               Toast.makeText(Main2Activity.this, "You have signed in!!", Toast.LENGTH_SHORT).show();
                               Intent i = new Intent("android.intent.action.login1");
                               startActivity(i);
                           }
                       }
                   }
               }

       );


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }

}
