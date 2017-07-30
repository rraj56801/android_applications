package com.example.errahulraj.quiz;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.errahulraj.fifth;
import com.example.errahulraj.fourth;
import com.example.errahulraj.questionlist;
import com.example.third;

import java.util.Locale;

public class questionpage extends AppCompatActivity {
Button done;
    RadioGroup r;
    RadioButton x,y,z,w;
    TextToSpeech mspeak;
    static String answer1="r";
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionpage);
        done=(Button)findViewById(R.id.submit);
      r=(RadioGroup)findViewById(R.id.rg);
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
                    String toSpeak="MIPMAP";
                    Toast.makeText( getApplicationContext(),toSpeak,Toast.LENGTH_SHORT).show();
                    mspeak.speak( toSpeak, TextToSpeech.QUEUE_FLUSH,null );
                    answer1=w.getText().toString();
                   // Intent i=new Intent(questionpage.this,questionlist.class);
                  //  startActivity(i);
                }else {
                    if(x.isChecked()){
                        String toSpeak="DRAWABLE";
                        Toast.makeText( getApplicationContext(),toSpeak,Toast.LENGTH_SHORT ).show();
                        mspeak.speak( toSpeak,TextToSpeech.QUEUE_FLUSH,null );

                      //  Intent i=new Intent(questionpage.this,questionlist.class);
                        //startActivity(i);
                    }else {
                        if(y.isChecked()){
                            String toSpeak="WIDGETS";
                            Toast.makeText( getApplicationContext(),toSpeak,Toast.LENGTH_SHORT ).show();
                            mspeak.speak( toSpeak,TextToSpeech.QUEUE_FLUSH,null );
                          //  Intent i=new Intent(questionpage.this,questionlist.class);
                            //startActivity(i);
                        }else{
                            if (z.isChecked()){
                                String toSpeak="GRADLE";
                                Toast.makeText( getApplicationContext(),toSpeak,Toast.LENGTH_SHORT ).show();
                                mspeak.speak( toSpeak,TextToSpeech.QUEUE_FLUSH,null );
                              //  Intent i=new Intent(questionpage.this,questionlist.class);
                                //startActivity(i);
                                }else{
                                    Toast.makeText(questionpage.this,"YOU LOST YOUR CHANCE",Toast.LENGTH_SHORT).show();
                                answer1="a1";
                                }
                            }
                        }
                    }
            }

        });

    }
}
