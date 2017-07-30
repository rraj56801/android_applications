package com.example.errahulraj;

import android.annotation.TargetApi;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.errahulraj.quiz.R;
import com.example.errahulraj.quiz.indexpage2;
import com.example.errahulraj.quiz.loginpage;

@TargetApi(Build.VERSION_CODES.CUPCAKE)
public class magicplayer extends AppCompatActivity implements SensorEventListener {
    SensorManager sm;
    Sensor s;
    MediaPlayer mp;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magicplayer);
        mp=MediaPlayer.create(this,R.raw.a);
        //t=(TextView)findViewById(R.id.textView);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ALL);
        sm.registerListener((SensorEventListener) this,s,SensorManager.SENSOR_DELAY_NORMAL);
button=(Button)findViewById(R.id.but);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
                Intent i=new Intent(magicplayer.this,indexpage2.class);
                startActivity(i);
            }
        });
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.values[1]>2){
            mp.start();
        }else{
            mp.pause();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}


