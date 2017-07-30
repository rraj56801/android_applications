package com.example.rajbaba.smsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class messageindi extends AppCompatActivity {
    EditText txtmx;
    Button btnx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messageindi);
        txtmx=(EditText)findViewById(R.id.msgx);
        btnx=(Button)findViewById(R.id.btnsendx);
        btnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iin= getIntent();
                final String b = iin.getStringExtra("keys");
                final String num=b.substring(b.length()-10);
                final String msgs=(txtmx.getText().toString()).trim();
                final String nm=b.substring(3,(b.length()-10));
                if (msgs.equals("")){
                    Toast.makeText(messageindi.this,"TYPE YOUR MESSAGE",Toast.LENGTH_SHORT).show();
                }else {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(num, null, String.valueOf(msgs), null, null);
                    Toast.makeText(messageindi.this, "Sent to: "+nm, Toast.LENGTH_SHORT).show();
                    Intent im = new Intent(messageindi.this, Class_List.class);
                    startActivity(im);
                    finish();
                }
                }
        });
    }
}
