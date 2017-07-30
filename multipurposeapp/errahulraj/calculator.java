package com.example.errahulraj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.errahulraj.quiz.R;
import com.example.errahulraj.quiz.indexpage1;
import com.example.errahulraj.quiz.loginpage;

public class calculator extends AppCompatActivity {
    EditText e1,e2;
    TextView t1;
    Button b1,b2,b3,b4,re,res,ex;
    String s3="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        e1=(EditText)findViewById(R.id.fir);
        e2=(EditText)findViewById(R.id.sec);
        t1=(TextView)findViewById(R.id.textView19);
        b1=(Button)findViewById(R.id.add);
        b2=(Button)findViewById(R.id.sub);
        b3=(Button)findViewById(R.id.multiply);
        b4=(Button)findViewById(R.id.divide);
        re=(Button)findViewById(R.id.result);
        res=(Button)findViewById(R.id.reset);
        ex=(Button)findViewById(R.id.exit);
        ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(calculator.this,indexpage1.class);
                startActivity(i);
            }
        });
res.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        e1.setText("");
        e2.setText("");
    }
});

re.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        t1.setText(s3);

    }
});

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();

                float i=Float.parseFloat(s1);
                float j=Float.parseFloat(s2);

                Float add=i+j;
                 s3=Float.toString(add);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                float i=Float.parseFloat(s1);
                float j=Float.parseFloat(s2);

                Float sub=i-j;
                 s3=Float.toString(sub);


            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();

                float i=Float.parseFloat(s1);
                float j=Float.parseFloat(s2);

                Float mul=i*j;
                s3=Float.toString(mul);


            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();

                float i=Float.parseFloat(s1);
                float j=Float.parseFloat(s2);

                Float div=i/j;
                s3=Float.toString(div);



            }
        });

    }
}
