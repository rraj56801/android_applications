package com.example;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.errahulraj.questionlist;
import com.example.errahulraj.quiz.R;
import com.example.errahulraj.quiz.second;

import java.util.Locale;

public class third extends AppCompatActivity {
    Button done;
    RadioButton w,x,y,z;
    TextToSpeech mspeak;
    public static String answer3="h";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        done=(Button)findViewById(R.id.submit);
        w=(RadioButton)findViewById(R.id.a);
        x=(RadioButton)findViewById(R.id.b);
        y=(RadioButton)findViewById(R.id.c);
        z=(RadioButton)findViewById(R.id.d);
        mspeak=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override

            public void onInit(int i) {
                if(i != TextToSpeech.ERROR){
                    mspeak.setLanguage( Locale.ENGLISH );
                    mspeak.setPitch( 0.3f );
                }
            }
        } );


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(w.isChecked()){
                    String toSpeak="2.0";
                    Toast.makeText( getApplicationContext(),toSpeak,Toast.LENGTH_SHORT).show();
                    mspeak.speak( toSpeak, TextToSpeech.QUEUE_FLUSH,null );
                   answer3=w.getText().toString();
                    // Intent i=new Intent(third.this,questionlist.class);
                   // startActivity(i);
                }else {
                    if(x.isChecked()){
                        String toSpeak="2.2";
                        Toast.makeText( getApplicationContext(),toSpeak,Toast.LENGTH_SHORT ).show();
                        mspeak.speak( toSpeak,TextToSpeech.QUEUE_FLUSH,null );
                     //   Intent i=new Intent(third.this,questionlist.class);
                   //     startActivity(i);
                    }else {
                        if(y.isChecked()){
                            String toSpeak="12254";
                            Toast.makeText( getApplicationContext(),toSpeak,Toast.LENGTH_SHORT ).show();
                            mspeak.speak( toSpeak,TextToSpeech.QUEUE_FLUSH,null );
                       //     Intent i=new Intent(third.this,questionlist.class);
                         //   startActivity(i);
                        }else{
                            if (z.isChecked()){
                                String toSpeak="2.1";
                                Toast.makeText( getApplicationContext(),toSpeak,Toast.LENGTH_SHORT ).show();
                                mspeak.speak( toSpeak,TextToSpeech.QUEUE_FLUSH,null );
                           //     Intent i=new Intent(third.this,questionlist.class);
                             //   startActivity(i);
                            }else{
                                Toast.makeText(third.this,"YOU LOST YOUR CHANCE",Toast.LENGTH_SHORT).show();
                                answer3="a3";
                               // Intent i=new Intent(third.this,questionlist.class);
                               // startActivity(i);
                            }
                        }
                    }
                }
            }
        });
    }
}
