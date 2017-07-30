package com.example.errahulraj.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.errahulraj.browser;
import com.example.errahulraj.magicplayer;
import com.example.errahulraj.questionlist;

public class indexpage2 extends AppCompatActivity {
Button c,q,bk,bw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indexpage2);
        c=(Button)findViewById(R.id.mmp);
        q=(Button)findViewById(R.id.quiz);
        bk=(Button)findViewById(R.id.back);
        bw=(Button)findViewById(R.id.browse);

c.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(indexpage2.this,magicplayer.class);
        startActivity(i);
    }
});
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(indexpage2.this,questionlist.class);
                startActivity(i);
            }
        });
        bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(indexpage2.this,indexpage1.class);
                startActivity(i);
            }
        });
        bw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(indexpage2.this,browser.class);
                startActivity(i);
            }
        });
    }
}
