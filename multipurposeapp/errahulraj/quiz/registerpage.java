package com.example.errahulraj.quiz;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class registerpage extends AppCompatActivity {
    Button login,register;
    EditText usernam,firs,las,emai,mobil,passwor,confir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerpage);

        login=(Button)findViewById(R.id.login123);
        register=(Button)findViewById(R.id.register123);
        usernam=(EditText)findViewById(R.id.username);
        firs=(EditText)findViewById(R.id.firstname);
        las=(EditText)findViewById(R.id.lastname);
        emai=(EditText)findViewById(R.id.email);
        mobil=(EditText)findViewById(R.id.mobile);
        passwor=(EditText)findViewById(R.id.password);
        confir=(EditText)findViewById(R.id.confirmpassword);

        register.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.DONUT)
            @Override
            public void onClick(View view) {
                String u=usernam.getText().toString();
                String f=firs.getText().toString();
                String l=las.getText().toString();
                String cl=emai.getText().toString();
                String m=mobil.getText().toString();
                String p= passwor.getText().toString();
                String cn= confir.getText().toString();
                if(u.equals("")||f.equals("")||cl.equals("")||m.equals("")||p.equals("")){
                    Toast.makeText(registerpage.this,"*ALL MANDATORY",Toast.LENGTH_LONG).show();
                }
                 else {
                    if (m.length() != 10) {
                        Toast.makeText(registerpage.this, "MOBILE NUMBER INVALID", Toast.LENGTH_SHORT).show();
                    } else {
                        if (p.length() < 8) {
                            Toast.makeText(registerpage.this, "MINIMUM 8 CHARS", Toast.LENGTH_SHORT).show();
                        } else {
                            if (!p.equals(cn)) {
                                Toast.makeText(registerpage.this, "PASSWORD NOT MATCH", Toast.LENGTH_SHORT).show();
                            } else {
                                SQLiteDatabase data = openOrCreateDatabase("raj", MODE_PRIVATE, null);
                                data.execSQL("create table if not exists quiz (username varchar,firstname varchar,lastname varchar,email varchar,mobilenumber varchar,passwords varchar)");
                                String s = "select * from quiz WHERE username='" + u + "'";
                                Cursor cursor = data.rawQuery(s, null);
                                if (cursor.getCount() > 0) {
                                    Toast.makeText(registerpage.this, "USERNAME EXIST", Toast.LENGTH_LONG).show();
                                } else {
                                    int r=Integer.parseInt(p);
                                    int n=(r*r+r)/7;
                                    Random rnd = new Random();
                                    rnd.setSeed(n);
                                    data.execSQL("insert into quiz values('" + u + "','" + f + "','" + l + "','" + cl + "','" + m + "','" + p + "')");
                                    String otp = Integer.toString(n);
                                    SmsManager smsManager = SmsManager.getDefault();
                                    smsManager.sendTextMessage(m, null, " " + otp + " " + u + "", null, null);
                                    Toast.makeText(registerpage.this, "OTP SENT TO " + m + "", Toast.LENGTH_LONG).show();
                                    Toast.makeText(registerpage.this, "SigningUp Successful", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(registerpage.this, loginpage.class);
                                    startActivity(i);

                                }

                            }
                        }
                    }
                }


            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(registerpage.this,loginpage.class));
                finish();
            }
        });
    }
}
