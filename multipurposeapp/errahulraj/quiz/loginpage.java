package com.example.errahulraj.quiz;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.errahulraj.questionlist;

import java.util.Random;

public class loginpage extends AppCompatActivity {
Button log,forgot,newuser;
    EditText  usernam,passwor,conf,ot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
        log=(Button)findViewById(R.id.login);
        forgot=(Button)findViewById(R.id.forgot);
        newuser=(Button)findViewById(R.id.newuser);

        usernam=(EditText)findViewById(R.id.username);
        passwor=(EditText)findViewById(R.id.password);
        conf= (EditText) findViewById(R.id.confirmpassword);
        ot=(EditText)findViewById(R.id.otp);


        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginpage.this,forgotpassword.class));
                finish();
            }
        });
        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginpage.this,registerpage.class));
                finish();
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u=usernam.getText().toString();
                String p=passwor.getText().toString();
                String cf=conf.getText().toString();
                String o=ot.getText().toString();


                if(u.equals("")||p.equals("")||o.equals("")) {
                    Toast.makeText(loginpage.this, "FILL ALL", Toast.LENGTH_SHORT).show();
                } else {
                    if (!p.equals(cf)) {
                        Toast.makeText(loginpage.this, "PASSWORD NOT MATCHED", Toast.LENGTH_SHORT).show();
                    } else {
                        int r=Integer.parseInt(p);
                        int n=(r*r+r)/7;
                        Random rnd = new Random();
                        rnd.setSeed(n);
                        String otp=Integer.toString(n);
                        if (!o.equals(otp)) {
                            Toast.makeText(loginpage.this, "OTP NOT MATCHED", Toast.LENGTH_SHORT).show();
                        }else{
                            SQLiteDatabase data=openOrCreateDatabase("raj",MODE_PRIVATE,null);
                            String s="select * from quiz WHERE username='"+u+"' and passwords='"+p+"'";
                            Cursor cursor=data.rawQuery(s,null);
                            if(cursor.getCount()==0){
                                Toast.makeText(loginpage.this, "USER NOT EXIST", Toast.LENGTH_LONG).show();
                            }else {
                                Toast.makeText(loginpage.this,"Log In Successful...Best OF Luck",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(loginpage.this,indexpage1.class));
                                finish();
                            }
                        }
                    }
                }
            }
        });
    }
}
