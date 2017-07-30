package com.example;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.errahulraj.quiz.R;
import com.example.errahulraj.quiz.loginpage;

public class econd extends AppCompatActivity {
    Button mail,home;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_econd);
        mail = (Button) findViewById(R.id.mail);
        tv = (TextView) findViewById(R.id.textView);
        home=(Button)findViewById(R.id.home);
        String s="  HELLO! I WILL BE" +" "+
                " THANKFUL FOR YOUR " +" "+
                "REVIEWS" +"   "+
                "BeTheBest" +"   "+
                "YES I AM THE MYSTERY" +"  "+
                "I AM 'RAJ'";
        tv.setText(s);
        home=(Button)findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(econd.this,loginpage.class);
                startActivity(i);
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }
    protected void sendEmail() {
        String s = tv.getText().toString();
        Log.i(s,"");    //Log.i("Send email", "");
        String[] TO = {"rraj56801@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(econd.this, "ERROR.", Toast.LENGTH_SHORT).show();
        }
    }
}
