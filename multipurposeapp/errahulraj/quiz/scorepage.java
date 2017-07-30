package com.example.errahulraj.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.errahulraj.fifth;
import com.example.errahulraj.fourth;
import com.example.errahulraj.questionlist;
import com.example.third;

public class scorepage extends AppCompatActivity {
TextView scr,msg;
   static int score=0;
    Button b;
    RadioButton rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorepage);
        scr=(TextView)findViewById(R.id.score);
        msg=(TextView)findViewById(R.id.message);
        rb=(RadioButton)findViewById(R.id.radioButton);
b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                int p=0;
                if(rb.isChecked()){
                    score=p;
                    String s=Integer.toString(score);
                    scr.setText(s);
                    Intent i=new Intent(scorepage.this,loginpage.class);
                   startActivity(i);
                }else{
                    Intent i=new Intent(scorepage.this,loginpage.class);
                    startActivity(i);
                }

            }
        });
            if(questionpage.answer1.equals("a1")){
                score=score+0;
            }
       else {
                if(questionpage.answer1.equals("MIPMAP")){
                    score=score+1;
                }else{
                    score=score-1;
                }
            }if(second.answer2.equals("a2")){
            score=score+0;
        }
       else{
            if(second.answer2.equals("MAinActivity")){
                score=score+1;
            }else{
                score=score-1;
            }
        }if(third.answer3.equals("a3")){
            score=score+0;
        }
       else {
            if(third.answer3.equals("2.0")){
                score=score+1;
            }else{
                score=score-1;
            }
        }
        if(fourth.answer4.equals("a4")){
            score=score+0;
        }
       else {
            if(fourth.answer4.equals("Dennis Ritchie&Brian Kernighan")){
                score=score+1;
            }else{
                score=score-1;
            }
        }
        if(fifth.answer5.equals("a5")){
            score=score+0;
        }else{
            if(fifth.answer5.equals("27")){
            score=score+1;
        }else{
            score=score-1;
        }
        }
        String s=Integer.toString(score);
        scr.setText(s);
        if(score>=4) {
            msg.setText("EXCELLENT");
        }else {
            if(score<4&&score>=3){
                msg.setText("Very Good");
            }else{
                msg.setText("WORK HARD");
            }
                Toast.makeText(scorepage.this,"THANK YOU",Toast.LENGTH_LONG).show();

        }
    }
}
