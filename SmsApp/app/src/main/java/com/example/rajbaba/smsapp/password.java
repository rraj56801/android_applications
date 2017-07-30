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
import android.widget.Toast;

import java.util.Random;

public class password extends AppCompatActivity {
EditText usernam,mobil,newp,cnfp;
    Button submi,bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        submi=(Button)findViewById(R.id.submits);
        usernam=(EditText)findViewById(R.id.usernames);
        mobil=(EditText)findViewById(R.id.mobiles);
        newp=(EditText)findViewById(R.id.passwords);
        cnfp=(EditText)findViewById(R.id.cnfpasswords);
        bt=(Button)findViewById(R.id.logs);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(password.this,loginpage.class);
                startActivity(i);
            }
        });
        submi.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.DONUT)
            @Override
            public void onClick(View view) {
                String u=(usernam.getText().toString()).trim();
                String  m=(mobil.getText().toString()).trim();
                String nw=(newp.getText().toString()).trim();
                String cnf=(cnfp.getText().toString()).trim();
                if(u.equals("")||m.equals("")||nw.equals("")||cnf.equals("")){
                    Toast.makeText(password.this,"FILL ALL",Toast.LENGTH_SHORT).show();
                }else {
                    if (nw.length() >= 10) {
                        Toast.makeText(password.this, "INVALID PASSWORD", Toast.LENGTH_SHORT).show();
                    } else {
                            if (!nw.equals(cnf)) {
                                Toast.makeText(password.this, "PASSWORD NOT MATCHED", Toast.LENGTH_SHORT).show();
                            } else {
                                SQLiteDatabase data = openOrCreateDatabase("databaseca", MODE_PRIVATE, null);
                                String s = "SELECT * from catable WHERE username='" + u + "' and mobilenumber='" + m + "'";
                                Cursor cursor = data.rawQuery(s, null);
                                if (cursor.getCount() > 0) {
                                    String strSQL = "UPDATE catable SET passwords = '" + nw + "' WHERE username ='" + u + "' and mobilenumber='" + m + "'";
                                    data.execSQL(strSQL);
                                    int r = Integer.parseInt(nw);
                                    double q = Math.PI;
                                    int n = (int) ((r * r + r + q * q) / 7 + 10000);
                                    Random rnd = new Random();
                                    rnd.setSeed(n);
                                    String otps = Integer.toString(n);
                                    String otp = otps;
                                    if (otp.length() > 4) {
                                        otp = otp.substring(otp.length() - 4);
                                        SmsManager smsManager = SmsManager.getDefault();
                                        smsManager.sendTextMessage(m, null, " " + otp + " " + u + "", null, null);
                                        Toast.makeText(password.this, "CODE SENT:" + m + "", Toast.LENGTH_LONG).show();
                                        Toast.makeText(password.this, "PASSWORD UPDATED", Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(password.this, loginpage.class);
                                        startActivity(i);
                                    } else {
                                        SmsManager smsManager = SmsManager.getDefault();
                                        smsManager.sendTextMessage(m, null, " " + otp + " "+"@" + u + "", null, null);
                                        Toast.makeText(password.this, "CODE SENT: " + m + "", Toast.LENGTH_LONG).show();
                                        Toast.makeText(password.this, "PASSWORD UPDATED", Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(password.this, loginpage.class);
                                        startActivity(i);
                                    }
                                } else {
                                    Toast.makeText(password.this, "USER NOT EXIST", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                }
            }
        });

    }
}
