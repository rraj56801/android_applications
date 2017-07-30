package com.example.errahulraj.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.errahulraj.calculator;
import com.example.errahulraj.camera;

public class indexpage1 extends AppCompatActivity {
Button m,ca,cam,s,bk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indexpage1);
        bk=(Button) findViewById(R.id.back);
        m=(Button)findViewById(R.id.mp);
        ca=(Button)findViewById(R.id.cal);
        cam=(Button)findViewById(R.id.came);
        s=(Button)findViewById(R.id.sf);

        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(indexpage1.this,musicplayer.class);
                startActivity(i);
            }
        });
        bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(indexpage1.this,loginpage.class);
                startActivity(i);
            }
        });
        ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(indexpage1.this,calculator.class);
                startActivity(i);
            }
        });
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(indexpage1.this,camera.class);
                startActivity(i);
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(indexpage1.this,indexpage2.class);
                startActivity(i);
            }
        });
    }
}
