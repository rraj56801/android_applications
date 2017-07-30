package com.example.rajbaba.smsapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class Class_List extends AppCompatActivity {
Button bl,bu,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,bnt,bt,exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class__list);
        ScrollView scrollView=(ScrollView)findViewById(R.id.scrol);
        scrollView.setVerticalScrollBarEnabled(true);
        bl=(Button)findViewById(R.id.button2);
        bu=(Button)findViewById(R.id.button3);
        b1=(Button)findViewById(R.id.button4);
        b2=(Button)findViewById(R.id.button5);
        b3=(Button)findViewById(R.id.button6);
        b4=(Button)findViewById(R.id.button7);
        b5=(Button)findViewById(R.id.button8);
        b6=(Button)findViewById(R.id.button9);
        b7=(Button)findViewById(R.id.button10);
        b8=(Button)findViewById(R.id.button11);
        b9=(Button)findViewById(R.id.button12);
        b10=(Button)findViewById(R.id.button13);
        bnt=(Button)findViewById(R.id.button14);
        bt=(Button)findViewById(R.id.button15);
        exit=(Button)findViewById(R.id.button16);
exit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(Class_List.this,loginpage.class);
        startActivity(i); 

    }
});

        bl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase data = openOrCreateDatabase("databaselkg", MODE_PRIVATE, null);
                data.execSQL("create table if not exists lkg (username varchar,mobilenumber varchar)");
                Intent i=new Intent(Class_List.this,classlkg.class);
                startActivity(i);
            }
        });
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase data = openOrCreateDatabase("databaseukg", MODE_PRIVATE, null);
                data.execSQL("create table if not exists ukg (username varchar,mobilenumber varchar)");
                Intent i=new Intent(Class_List.this,classukg.class);
                startActivity(i); 
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase data = openOrCreateDatabase("databaseone", MODE_PRIVATE, null);
                data.execSQL("create table if not exists one (username varchar,mobilenumber varchar)");
                Intent i = new Intent(Class_List.this, class1.class);
                startActivity(i); 
            }
        });
            b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SQLiteDatabase data = openOrCreateDatabase("databasetwo", MODE_PRIVATE, null);
                        data.execSQL("create table if not exists two (username varchar,mobilenumber varchar)");
                        Intent i = new Intent(Class_List.this, class2.class);
                        startActivity(i); 
                    }
                });
                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SQLiteDatabase data = openOrCreateDatabase("databasethree", MODE_PRIVATE, null);
                        data.execSQL("create table if not exists three (username varchar,mobilenumber varchar)");
                        Intent i = new Intent(Class_List.this, class3.class);
                        startActivity(i); 
                    }
                });
                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SQLiteDatabase data = openOrCreateDatabase("databasefour", MODE_PRIVATE, null);
                        data.execSQL("create table if not exists four (username varchar,mobilenumber varchar)");
                        Intent i = new Intent(Class_List.this, class4.class);
                        startActivity(i); 
                    }
                });
                b5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SQLiteDatabase data = openOrCreateDatabase("databasefive", MODE_PRIVATE, null);
                        data.execSQL("create table if not exists five (username varchar,mobilenumber varchar)");
                        Intent i = new Intent(Class_List.this, class5.class);
                        startActivity(i); 
                    }
                });
                b6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SQLiteDatabase data = openOrCreateDatabase("databasesix", MODE_PRIVATE, null);
                        data.execSQL("create table if not exists six (username varchar,mobilenumber varchar)");
                        Intent i = new Intent(Class_List.this, class6.class);
                        startActivity(i); 
                    }
                });
                b7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SQLiteDatabase data = openOrCreateDatabase("databaseseven", MODE_PRIVATE, null);
                        data.execSQL("create table if not exists seven (username varchar,mobilenumber varchar)");
                        Intent i = new Intent(Class_List.this, class7.class);
                        startActivity(i); 
                    }
                });
                b8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SQLiteDatabase data = openOrCreateDatabase("databaseeight", MODE_PRIVATE, null);
                        data.execSQL("create table if not exists eight (username varchar,mobilenumber varchar)");
                        Intent i = new Intent(Class_List.this, class8.class);
                        startActivity(i); 
                    }
                });
                b9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SQLiteDatabase data = openOrCreateDatabase("databasenine", MODE_PRIVATE, null);
                        data.execSQL("create table if not exists nine (username varchar,mobilenumber varchar)");
                        Intent i = new Intent(Class_List.this, class9.class);
                        startActivity(i); 
                    }
                });
                b10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SQLiteDatabase data = openOrCreateDatabase("databaseten", MODE_PRIVATE, null);
                        data.execSQL("create table if not exists ten (username varchar,mobilenumber varchar)");
                        Intent i = new Intent(Class_List.this, class10.class);
                        startActivity(i); 
                    }
                });
                bnt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SQLiteDatabase data = openOrCreateDatabase("databasenon", MODE_PRIVATE, null);
                        data.execSQL("create table if not exists non (username varchar,mobilenumber varchar)");
                        Intent i = new Intent(Class_List.this, nonteach.class);
                        startActivity(i); 
                    }
                });
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {SQLiteDatabase data = openOrCreateDatabase("databaseteach", MODE_PRIVATE, null);
                        data.execSQL("create table if not exists teach (username varchar,mobilenumber varchar)");
                        Intent i = new Intent(Class_List.this, teach.class);
                        startActivity(i); 
                    }
                });
            }
        }