package com.example.rajbaba.smsapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class class1 extends AppCompatActivity {
    String selected="";
    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    Button button,btni,backs,badd,bdel,bup;
    EditText eds,edm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class1);
        adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,listItems);
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        eds=(EditText)findViewById(R.id.username);
        edm=(EditText)findViewById(R.id.mobile);
        backs=(Button)findViewById(R.id.btnbacks);
        backs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(class1.this,Class_List.class);
                startActivity(i); 
            }
        });
        eds.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                class1.this.adapter.getFilter().filter(editable);
            }
        });

        button=(Button)findViewById(R.id.btndisp);
        btni=(Button)findViewById(R.id.btns);
        badd=(Button)findViewById(R.id.btnadd);

        SQLiteDatabase data = openOrCreateDatabase("databaseone", MODE_PRIVATE, null);
        String s = "select * from one ";
        Cursor cursor = data.rawQuery(s, null);
        int row_counts=0;
        row_counts=cursor.getCount();
        cursor.moveToFirst();
        String cnames=cursor.getColumnName(0);
        String cmobs=cursor.getColumnName(1);
        int colindexs= cursor.getColumnIndex(cnames);
        int colindexms= cursor.getColumnIndex(cmobs);
        int j=0;
        while(j<row_counts){
            listItems.add((cursor.getPosition()+1)+". "+cursor.getString(colindexs).toUpperCase()+" "+cursor.getString(colindexms));
           // listItems.add(" "+" "+" "+cursor.getString(colindexms));
            adapter.notifyDataSetChanged();
            j++;
            cursor.moveToNext();
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selected =(String) (listView.getItemAtPosition(i));
                Toast toast = Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT);
                toast.show();

            }
        });

        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = (eds.getText().toString().toUpperCase()).trim();
                String f = (edm.getText().toString().toUpperCase()).trim();
                if (u.equals("") || f.equals("")) {
                    Toast.makeText(class1.this, "*ALL MANDATORY", Toast.LENGTH_LONG).show();
                } else {
                    if (f.length() != 10) {
                        Toast.makeText(class1.this, "MOBILE NUMBER INVALID", Toast.LENGTH_SHORT).show();
                    } else {
                        SQLiteDatabase data = openOrCreateDatabase("databaseone", MODE_PRIVATE, null);
                        data.execSQL("create table if not exists one (username varchar,mobilenumber varchar)");
                        String s = "select * from one WHERE username='" + u + "'";
                        Cursor cursor = data.rawQuery(s, null);
                        if (cursor.getCount() > 0) {
                            Toast.makeText(class1.this, "Student Name Exist", Toast.LENGTH_LONG).show();
                        } else {
                            data.execSQL("insert into one values('" + u + "','" + f + "')");
                            Toast.makeText(class1.this, "ADDED", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }

        });
        btni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(class1.this,messageindi.class);
                i.putExtra("keys",String.valueOf(selected));
                startActivity(i); 

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent i=new Intent(class1.this,msgall1.class);
                 startActivity(i); 

            }
        });
        bdel=(Button)findViewById(R.id.button18);
bdel.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
            String u = (eds.getText().toString().toUpperCase()).trim();
            String f = (edm.getText().toString().toUpperCase()).trim();
            if (u.equals("") || f.equals("")) {
                Toast.makeText(class1.this, "*ALL MANDATORY", Toast.LENGTH_LONG).show();
            } else {
                if (f.length() != 10) {
                    Toast.makeText(class1.this, "MOBILE NUMBER INVALID", Toast.LENGTH_SHORT).show();
                } else {
                    SQLiteDatabase data = openOrCreateDatabase("databaseone", MODE_PRIVATE, null);
                    String s = "select * from one WHERE username='" + u + "' AND mobilenumber='" + f + "'";
                    Cursor cursor = data.rawQuery(s, null);
                    if (cursor.getCount() > 0) {
                        String strSQL = "DELETE from one WHERE username ='"+u+"' and mobilenumber='"+f +"'";
                        data.execSQL(strSQL);
                        Toast.makeText(class1.this, "Deleted", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(class1.this, "Invalid Data", Toast.LENGTH_LONG).show();

                    }
                }
            }
        }
});

        bup=(Button)findViewById(R.id.button19);
        bup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = (eds.getText().toString().toUpperCase()).trim();
                String f = (edm.getText().toString().toUpperCase()).trim();
                if (u.equals("") || f.equals("")) {
                    Toast.makeText(class1.this, "*ALL MANDATORY", Toast.LENGTH_LONG).show();
                } else {
                    if (f.length() != 10) {
                        Toast.makeText(class1.this, "MOBILE NUMBER INVALID", Toast.LENGTH_SHORT).show();
                    } else {
                        SQLiteDatabase data = openOrCreateDatabase("databaseone", MODE_PRIVATE, null);
                        String s = "select * from one WHERE username='" + u + "'";
                        Cursor cursor = data.rawQuery(s, null);
                        if (cursor.getCount() > 0) {
                            String strSQL = "UPDATE one SET  mobilenumber='"+f +"' WHERE username ='"+u+"' ";
                            Toast.makeText(class1.this, "UPDATED", Toast.LENGTH_LONG).show();
                            data.execSQL(strSQL);

                        } else {
                            Toast.makeText(class1.this, "Invalid Data", Toast.LENGTH_LONG).show();

                        }
                    }
                }
            }
        });
    }

        }