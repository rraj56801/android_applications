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
import com.example.third;

import java.util.Locale;

public class fourth extends AppCompatActivity {
    Button done;
    RadioButton w,x,y,z;
    TextToSpeech mspeak;
    public static String answer4 ="u";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
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
                    String toSpeak="Dennis Ritchie&Brian Kernighan";
                    Toast.makeText( getApplicationContext(),toSpeak,Toast.LENGTH_SHORT).show();
                    mspeak.speak( toSpeak, TextToSpeech.QUEUE_FLUSH,null );
                    answer4=w.getText().toString();
                                   //  Intent i=new Intent(fourth.this,questionlist.class);
                //    startActivity(i);
                }else {
                    if(x.isChecked()){
                        String toSpeak="James Gosling& team";
                        Toast.makeText( getApplicationContext(),toSpeak,Toast.LENGTH_SHORT ).show();
                        mspeak.speak( toSpeak,TextToSpeech.QUEUE_FLUSH,null );
                    //    Intent i=new Intent(fourth.this,questionlist.class);
                      //  startActivity(i);
                    }else {
                        if(y.isChecked()){
                            String toSpeak="Chris Warth&Ed Frank";
                            Toast.makeText( getApplicationContext(),toSpeak,Toast.LENGTH_SHORT ).show();
                            mspeak.speak( toSpeak,TextToSpeech.QUEUE_FLUSH,null );
                        //    Intent i=new Intent(fourth.this,questionlist.class);
                          //  startActivity(i);
                        }else{
                            if (z.isChecked()){
                                String toSpeak="Mike Sheridan& Team";
                                Toast.makeText( getApplicationContext(),toSpeak,Toast.LENGTH_SHORT ).show();
                                mspeak.speak( toSpeak,TextToSpeech.QUEUE_FLUSH,null );
                            //    Intent i=new Intent(fourth.this,questionlist.class);
                              //  startActivity(i);
                            }else{
                                Toast.makeText(fourth.this,"YOU LOST YOUR CHANCE",Toast.LENGTH_SHORT).show();
                                answer4="a4";
                                //Intent i=new Intent(fourth.this,questionlist.class);
                                //startActivity(i);
                            }
                        }
                    }
                }
            }
        });
    }
}
