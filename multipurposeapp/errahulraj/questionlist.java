package com.example.errahulraj;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.errahulraj.quiz.R;
import com.example.errahulraj.quiz.questionpage;
import com.example.errahulraj.quiz.scorepage;
import com.example.errahulraj.quiz.second;
import com.example.third;

import java.util.Locale;

public class questionlist extends AppCompatActivity {
Button sub,gett;
    RadioButton a,b,c,d,e;
    TextToSpeech mspeak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionlist);
        sub=(Button)findViewById(R.id.submit);
        gett=(Button)findViewById(R.id.scor);
        a=(RadioButton)findViewById(R.id.a);
        b=(RadioButton)findViewById(R.id.b);
        c=(RadioButton)findViewById(R.id.c);
        d=(RadioButton)findViewById(R.id.d);
        e=(RadioButton)findViewById(R.id.e);

        mspeak=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override

            public void onInit(int i) {
                if(i != TextToSpeech.ERROR){
                    mspeak.setLanguage( Locale.ENGLISH );
                    mspeak.setPitch( 0.3f );
                }
            }
        } );


        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a.isChecked()){
                    String toSpeak="ICON IS SET USING";
                    Toast.makeText( getApplicationContext(),toSpeak,Toast.LENGTH_SHORT).show();
                    mspeak.speak( toSpeak,TextToSpeech.QUEUE_FLUSH,null );
                    Intent i=new Intent(questionlist.this,questionpage.class);
                    startActivity(i);
                    a.setEnabled(false);
                    a.setChecked(true);
                }else {
                    if(b.isChecked()){
                        String toSpeak="Correct Package Name ?";
                        Toast.makeText( getApplicationContext(),toSpeak,Toast.LENGTH_SHORT ).show();
                        mspeak.speak( toSpeak,TextToSpeech.QUEUE_FLUSH,null );
                        Intent i=new Intent(questionlist.this,second.class);
                        startActivity(i);
                        b.setEnabled(false);
                        b.setChecked(true);
                    }else {
                        if(c.isChecked()){
                            String toSpeak="Largest Even Prime";
                            Toast.makeText( getApplicationContext(),toSpeak,Toast.LENGTH_SHORT ).show();
                            mspeak.speak( toSpeak,TextToSpeech.QUEUE_FLUSH,null );
                            Intent i=new Intent(questionlist.this,third.class);
                            startActivity(i);
                            c.setEnabled(false);
                            c.setChecked(true);
                        }else{
                            if (d.isChecked()){
                                String toSpeak="C was developed by";
                                Toast.makeText( getApplicationContext(),toSpeak,Toast.LENGTH_SHORT ).show();
                                mspeak.speak( toSpeak,TextToSpeech.QUEUE_FLUSH,null );
                                Intent i=new Intent(questionlist.this,fourth.class);
                                startActivity(i);
                                d.setEnabled(false);
                                d.setChecked(true);
                            }else{
                                if (e.isChecked()){
                                    String toSpeak="3^3/3*3+3-3=?";
                                    Toast.makeText( getApplicationContext(),toSpeak,Toast.LENGTH_SHORT ).show();
                                    mspeak.speak( toSpeak,TextToSpeech.QUEUE_FLUSH,null );
                                    Intent i=new Intent(questionlist.this,fifth.class);
                                    startActivity(i);
                                    e.setEnabled(false);
                                    e.setChecked(true);
                                }else{
                                    Toast.makeText(questionlist.this,"Please select any one",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }

            }
        });
        gett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(questionlist.this,scorepage.class);
                startActivity(i);
            }
        });
    }
}
