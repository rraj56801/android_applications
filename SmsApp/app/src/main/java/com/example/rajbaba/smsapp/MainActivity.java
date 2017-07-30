package com.example.rajbaba.smsapp;

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
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button login, register;
    TextView tv;
    EditText usernam, firs, las, emai, mobil, passwor, confir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.log);
        register = (Button) findViewById(R.id.reg);
        usernam = (EditText) findViewById(R.id.username);
        firs = (EditText) findViewById(R.id.firstname);
        las = (EditText) findViewById(R.id.lastname);
        emai = (EditText) findViewById(R.id.email);
        mobil = (EditText) findViewById(R.id.mobile);
        passwor = (EditText) findViewById(R.id.passworx);
        confir = (EditText) findViewById(R.id.confirmpassworx);

        register.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.DONUT)
            @Override
            public void onClick(View view) {
                String u = usernam.getText().toString();
                String f = firs.getText().toString();
                String l = las.getText().toString();
                String cl = emai.getText().toString();
                String m = mobil.getText().toString();
                String p = passwor.getText().toString();
                String cn = confir.getText().toString();
                if (u.equals("") || f.equals("") || cl.equals("") || m.equals("") || p.equals("")) {
                    Toast.makeText(MainActivity.this, "*ALL MANDATORY", Toast.LENGTH_LONG).show();
                } else {
                    if (u.length()<4){
                        Toast.makeText(MainActivity.this, "USERNAME:MIN 4 CHARS", Toast.LENGTH_LONG).show();
                    }else{
                        if(p.length()>=10){
                            Toast.makeText(MainActivity.this, "MAX CHAR: 9", Toast.LENGTH_SHORT).show();

                        }else {
                            if (m.length() != 10) {
                                Toast.makeText(MainActivity.this, "MOBILE NUMBER INVALID", Toast.LENGTH_SHORT).show();
                            } else {
                                if (p.length() < 4) {
                                    Toast.makeText(MainActivity.this, "MINIMUM CHAR: 4", Toast.LENGTH_SHORT).show();
                                } else {
                                    if (!p.equals(cn)) {
                                        Toast.makeText(MainActivity.this, "PASSWORD NOT MATCH", Toast.LENGTH_SHORT).show();
                                    } else {
                                        SQLiteDatabase data = openOrCreateDatabase("databaseca", MODE_PRIVATE, null);
                                        data.execSQL("create table if not exists catable (username varchar,firstname varchar,lastname varchar,email varchar,mobilenumber varchar,passwords varchar)");
                                        String s = "select * from catable WHERE username='" + u + "'";
                                        Cursor cursor = data.rawQuery(s, null);
                                        if (cursor.getCount() > 0) {
                                            Toast.makeText(MainActivity.this, "USERNAME EXIST", Toast.LENGTH_LONG).show();
                                        } else {
                                            int r=Integer.parseInt(p);
                                            double q=Math.PI;
                                            int n=(int)((r*r+r+q*q)/7+10000);
                                            Random rnd = new Random();
                                            rnd.setSeed(n);
                                            String otps = Integer.toString(n);
                                            String otp=otps;
                                            if(otp.length()>4){
                                                otp= otp.substring(otp.length()-4);
                                                data.execSQL("insert into catable values('" + u + "','" + f + "','" + l + "','" + cl + "','" + m + "','" + p + "')");
                                                ;
                                                SmsManager smsManager = SmsManager.getDefault();
                                                smsManager.sendTextMessage(m, null, " " + otp + " " +"@"+ u + "", null, null);
                                                Toast.makeText(MainActivity.this, "CODE SENT: " + m + "", Toast.LENGTH_SHORT).show();
                                                Toast.makeText(MainActivity.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                                                Intent i = new Intent(MainActivity.this, loginpage.class);
                                                startActivity(i);
                                                finish();
                                            }else {

                                                data.execSQL("insert into catable values('" + u + "','" + f + "','" + l + "','" + cl + "','" + m + "','" + p + "')");
                                                ;
                                                SmsManager smsManager = SmsManager.getDefault();
                                                smsManager.sendTextMessage(m, null, " " + otp + " " + "@"+u + "", null, null);
                                                Toast.makeText(MainActivity.this, "CODE SENT: " + m + "", Toast.LENGTH_SHORT).show();
                                                Toast.makeText(MainActivity.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                                                Intent i = new Intent(MainActivity.this, loginpage.class);
                                                startActivity(i);
                                                finish();
                                            }
                                        }
                                    }
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
                startActivity(new Intent(MainActivity.this, loginpage.class));

            }
        });

    }
}