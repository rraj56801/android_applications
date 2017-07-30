package com.example.rajbaba.smsapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class msgallnon extends AppCompatActivity {
    EditText txtm;
    Button btn;
    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msgallnon);
        adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,listItems);
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        txtm=(EditText)findViewById(R.id.msg);
        btn=(Button)findViewById(R.id.btnsend);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String msgs=(txtm.getText().toString()).trim();
                if (msgs.equals("")){
                    Toast.makeText(msgallnon.this,"TYPE YOUR MESSAGE",Toast.LENGTH_SHORT).show();
                }else {
                    SQLiteDatabase data = openOrCreateDatabase("databasenon", MODE_PRIVATE, null);
                    String s = "select * from non ";
                    Cursor cursor = data.rawQuery(s, null);
                    int row_count = 0;
                    int column_count = 0;
                    row_count = cursor.getCount();
                    column_count = cursor.getColumnCount();
                    cursor.moveToFirst();
                    String cname = cursor.getColumnName(0);
                    String cmob = cursor.getColumnName(1);
                    int colindex = cursor.getColumnIndex(cname);
                    int colindexm = cursor.getColumnIndex(cmob);
                    int i = 0;
                    while (i < row_count) {
                        listItems.add(cursor.getString(colindex));
                        listItems.add(cursor.getString(colindexm));
                        adapter.notifyDataSetChanged();
                        i++;
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage((cursor.getString(colindexm)), null,String.valueOf(msgs), null, null);
                        cursor.moveToNext();
                    }
                    Toast.makeText(msgallnon.this,"Message Sent to all",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(msgallnon.this,Class_List.class);
                    startActivity(intent); finish();
                }
            }
        });
    }
}
