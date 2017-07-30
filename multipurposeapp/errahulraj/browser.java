package com.example.errahulraj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.example.econd;
import com.example.errahulraj.quiz.R;

public class browser extends AppCompatActivity {
Button no,sub,clear,FACEBOOK, GMAIL,GOOGLE,
        PAYTM,TWITTER;
    EditText url;
    WebView wb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        url=(EditText)findViewById(R.id.url);
        wb=(WebView)findViewById(R.id.webView);
        no=(Button)findViewById(R.id.no);
        clear=(Button)findViewById(R.id.clear);
        sub=(Button)findViewById(R.id.submit);
        FACEBOOK=(Button)findViewById(R.id.facebook);
      GMAIL=(Button)findViewById(R.id.gmail);
        GOOGLE=(Button)findViewById(R.id.google);
        PAYTM=(Button)findViewById(R.id.paytm);
        TWITTER=(Button)findViewById(R.id.twitter);

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url.setVisibility(View.INVISIBLE);
                sub.setVisibility(View.INVISIBLE);
                clear.setVisibility(View.INVISIBLE);
                FACEBOOK.setVisibility(View.INVISIBLE);
                GMAIL.setVisibility(View.INVISIBLE);
                GOOGLE.setVisibility(View.INVISIBLE);
                PAYTM.setVisibility(View.INVISIBLE);
                TWITTER.setVisibility(View.INVISIBLE);
                Intent i=new Intent(browser.this,econd.class);
                startActivity(i);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clear.setVisibility(View.INVISIBLE);
                FACEBOOK.setVisibility(View.INVISIBLE);
                GMAIL.setVisibility(View.INVISIBLE);
                GOOGLE.setVisibility(View.INVISIBLE);
                PAYTM.setVisibility(View.INVISIBLE);
                TWITTER.setVisibility(View.INVISIBLE);
                String s=url.getText().toString();
                if(s.equals("")){
                    url.setText("ENTER URL");
                }else{
                    wb.loadUrl(s);
                    url.setVisibility(View.INVISIBLE);
                    sub.setVisibility(View.INVISIBLE);
                   }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url.setText("");


            }
        });
        FACEBOOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wb.loadUrl("https://www.facebook.com/login/");
                sub.setVisibility(View.INVISIBLE);
                clear.setVisibility(View.INVISIBLE);
                no.setVisibility(View.INVISIBLE);
                url.setVisibility(View.INVISIBLE);

                FACEBOOK.setVisibility(View.INVISIBLE);
                GMAIL.setVisibility(View.INVISIBLE);
                GOOGLE.setVisibility(View.INVISIBLE);
                PAYTM.setVisibility(View.INVISIBLE);
                TWITTER.setVisibility(View.INVISIBLE);

            }
        });
        GMAIL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wb.loadUrl("https://mail.google.com/gmail");
                sub.setVisibility(View.INVISIBLE);
                clear.setVisibility(View.INVISIBLE);
                no.setVisibility(View.INVISIBLE);
                url.setVisibility(View.INVISIBLE);
                FACEBOOK.setVisibility(View.INVISIBLE);
                GMAIL.setVisibility(View.INVISIBLE);
                GOOGLE.setVisibility(View.INVISIBLE);
                PAYTM.setVisibility(View.INVISIBLE);
                TWITTER.setVisibility(View.INVISIBLE);

            }
        });
        GOOGLE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wb.loadUrl("https://www.google.co.in");
                sub.setVisibility(View.INVISIBLE);
                clear.setVisibility(View.INVISIBLE);
                no.setVisibility(View.INVISIBLE);
                url.setVisibility(View.INVISIBLE);

                FACEBOOK.setVisibility(View.INVISIBLE);

                GMAIL.setVisibility(View.INVISIBLE);
                GOOGLE.setVisibility(View.INVISIBLE);
                PAYTM.setVisibility(View.INVISIBLE);
                TWITTER.setVisibility(View.INVISIBLE);

            }
        });
        PAYTM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wb.loadUrl("https://paytm.com/");
                sub.setVisibility(View.INVISIBLE);
                url.setVisibility(View.INVISIBLE);
                clear.setVisibility(View.INVISIBLE);
                no.setVisibility(View.INVISIBLE);
                 FACEBOOK.setVisibility(View.INVISIBLE);
                GMAIL.setVisibility(View.INVISIBLE);
                GOOGLE.setVisibility(View.INVISIBLE);
                PAYTM.setVisibility(View.INVISIBLE);
                TWITTER.setVisibility(View.INVISIBLE);

            }
        });
        TWITTER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wb.loadUrl("https://twitter.com/login");
                sub.setVisibility(View.INVISIBLE);
                url.setVisibility(View.INVISIBLE);
                clear.setVisibility(View.INVISIBLE);
                no.setVisibility(View.INVISIBLE);
                FACEBOOK.setVisibility(View.INVISIBLE);
                GMAIL.setVisibility(View.INVISIBLE);
                GOOGLE.setVisibility(View.INVISIBLE);
                PAYTM.setVisibility(View.INVISIBLE);
                TWITTER.setVisibility(View.INVISIBLE);

            }
        });

    }
}
