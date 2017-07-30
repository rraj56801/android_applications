package com.example.rajbaba.smsapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Messagepage extends AppCompatActivity {
    EditText txtm, txtu;
    Button btns, btnm, home,bts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messagepage);
        txtm = (EditText) findViewById(R.id.msg);
        btnm=(Button)findViewById(R.id.btnmail);
        home = (Button) findViewById(R.id.btnhome);
        btns = (Button) findViewById(R.id.btnsend);
        txtu = (EditText) findViewById(R.id.txtuser);
bts=(Button)findViewById(R.id.btnshare);
        bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String msgs = "https://drive.google.com/open?id=0Bzs2bXpDbYfhcUNnb2JjRGw4bTA"+" "+"SECOND_LINK:"+" "+"https://drive.google.com/open?id=0Bzs2bXpDbYfhLTN3ekFwdzMzYTQ";
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, String.valueOf(msgs));
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);

            }
        });

        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String num = "8405913144";
                final String msgs = (txtm.getText().toString()).trim();
                final String user = (txtu.getText().toString()).trim();
                if (user.equals("")) {
                    Toast.makeText(Messagepage.this, "YOUR NAME PLEASE", Toast.LENGTH_SHORT).show();
                } else {
                    if (msgs.equals("")) {
                        Toast.makeText(Messagepage.this, "TYPE YOUR MESSAGE", Toast.LENGTH_SHORT).show();
                    } else {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(num, null, String.valueOf(msgs) + " :@" + String.valueOf(user), null, null);
                        Toast.makeText(Messagepage.this, "Message Sent", Toast.LENGTH_SHORT).show();
                        Intent im = new Intent(Messagepage.this, Class_List.class);
                        startActivity(im);
                    }
                }
            }

        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Messagepage.this, loginpage.class);
                startActivity(i);
            }
        });
        btnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }
    protected void sendEmail() {
        String s = (txtm.getText().toString()).trim();
            Log.i(s, "");
            String[] TO = {"rraj56801@gmail.com"};
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
            try {
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                finish();
                Log.i("Finished sending email", "");
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(Messagepage.this, "ERROR.", Toast.LENGTH_SHORT).show();
            }

    }

    }
