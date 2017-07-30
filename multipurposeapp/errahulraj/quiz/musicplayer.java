package com.example.errahulraj.quiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class musicplayer extends AppCompatActivity {
    MediaPlayer mp;
    Button play;
    Button pause;
    Button ex;

    Button next;
    MediaPlayer mp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicplayer);
        play=(Button)findViewById(R.id.play);
        pause=(Button)findViewById(R.id.pause);
        ex=(Button)findViewById(R.id.exit);
        mp=MediaPlayer.create(this,R.raw.a);
        next=(Button)findViewById(R.id.next);
        mp1=(MediaPlayer.create(this,R.raw.aa));
        ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(musicplayer.this,indexpage1.class);
                startActivity(i);

            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp.isPlaying())
                    mp.pause();
                else if(mp1.isPlaying())
                    mp1.pause();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp.isPlaying()) {
                    mp.stop();
                    mp1.start();
                }
                else if(mp1.isPlaying())
                    mp1.stop();
                mp.start();
            }
        });
}

    }

