package com.example.attendancemanagerv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.attendancemanagerv2.MainActivity.db;

public class Main3Activity extends AppCompatActivity {
 EditText user1,pass1;
Button login1;
int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        db = openOrCreateDatabase("student.db", MODE_PRIVATE, null);
        log();
    }
    public void log() {
       final EditText user1=(EditText)findViewById(R.id.editText5);
        pass1=(EditText)findViewById(R.id.editText6);
        login1=(Button)findViewById(R.id.button4) ;
        login1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(user1.getText().toString().isEmpty())
                        {
                            Toast.makeText(Main3Activity.this,"Fill Username!!",Toast.LENGTH_SHORT).show();
                        }
                        else if(pass1.getText().toString().isEmpty())
                        {
                            Toast.makeText(Main3Activity.this,"Fill Password",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Cursor res = db.rawQuery("select * from tablename where NAME = '"+ user1.getText().toString() +"' and PASSWORD = '"+pass1.getText().toString()+"'", null);
                            if (res.getCount() == 0)
                            {
                                a=0;
                            }
                            else a = 1;
                            if (a == 1) {
                                String value=user1.getText().toString();

                                Toast.makeText(Main3Activity.this, "You Have Logged In", Toast.LENGTH_SHORT).show();
                                Intent i1 = new Intent("android.intent.action.loggedin");
                                i1.putExtra("value",value);
                                startActivity(i1);
                                finish();
                            } else {
                                Toast.makeText(Main3Activity.this, "Incorrect Details", Toast.LENGTH_SHORT).show();
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
