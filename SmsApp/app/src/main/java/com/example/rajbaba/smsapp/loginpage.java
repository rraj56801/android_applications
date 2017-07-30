package com.example.rajbaba.smsapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class loginpage extends AppCompatActivity {
    Button rv,log,forgott,newuser,ex;
    EditText  usernam,passwor,conf,ot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        rv=(Button)findViewById(R.id.btnrev);
        rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(loginpage.this,Messagepage.class);
                startActivity(i);
            }
        });
forgott=(Button)findViewById(R.id.btnf);
        forgott.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(loginpage.this,password.class);
                startActivity(i);
            }
        });
        log=(Button)findViewById(R.id.login);
        newuser=(Button)findViewById(R.id.newuser);
    ex=(Button)findViewById(R.id.button17);
        usernam=(EditText)findViewById(R.id.username);
        passwor=(EditText)findViewById(R.id.passwordsss);
        conf= (EditText) findViewById(R.id.confirmpasswordsss);
        ot=(EditText)findViewById(R.id.otp);
ex.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        System.exit(0);
    }
});
        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginpage.this,MainActivity.class));
                finish();
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u=(usernam.getText().toString()).trim();
                String p=(passwor.getText().toString()).trim();
                String cf=(conf.getText().toString()).trim();
                String o=(ot.getText().toString()).trim();
                if(u.equals("")||p.equals("")||o.equals("")) {
                    Toast.makeText(loginpage.this, "FILL ALL", Toast.LENGTH_SHORT).show();
                } else {
                    if (p.length() >= 10) {
                        Toast.makeText(loginpage.this, "INVALID PASSWORD", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!p.equals(cf)) {
                            Toast.makeText(loginpage.this, "PASSWORD NOT MATCHED", Toast.LENGTH_SHORT).show();
                        } else {
                            int r = Integer.parseInt(p);
                            double q = Math.PI;
                            int n = (int) ((r * r + r + q * q) / 7 + 10000);
                            Random rnd = new Random();
                            rnd.setSeed(n);
                            String otps = Integer.toString(n);
                            String otp = otps;
                            if (otp.length() > 4) {
                                otp = otp.substring(otp.length() - 4);
                                if (!o.equals(otp)) {
                                    Toast.makeText(loginpage.this, "Invalid Code", Toast.LENGTH_SHORT).show();
                                } else {
                                    SQLiteDatabase data = openOrCreateDatabase("databaseca", MODE_PRIVATE, null);
                                    String s = "select * from catable WHERE username='" + u + "' and passwords='" + p + "'";
                                    Cursor cursor = data.rawQuery(s, null);
                                    if (cursor.getCount() == 0) {
                                        Toast.makeText(loginpage.this, "USER NOT EXIST", Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(loginpage.this, "Log In Successful...Best OF Luck", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(loginpage.this, Class_List.class));
                                    }
                                }
                            } else {
                                if (!o.equals(otp)) {
                                    Toast.makeText(loginpage.this, "Invalid Code", Toast.LENGTH_SHORT).show();
                                } else {
                                    SQLiteDatabase data = openOrCreateDatabase("databaseca", MODE_PRIVATE, null);
                                    String s = "select * from catable WHERE username='" + u + "' and passwords='" + p + "'";
                                    Cursor cursor = data.rawQuery(s, null);
                                    if (cursor.getCount() == 0) {
                                        Toast.makeText(loginpage.this, "USER NOT EXIST", Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(loginpage.this, "LogIn Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(loginpage.this, Class_List.class));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }
}
