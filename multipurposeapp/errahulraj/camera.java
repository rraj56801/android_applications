package com.example.errahulraj;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.errahulraj.quiz.R;
import com.example.errahulraj.quiz.indexpage1;
import com.example.errahulraj.quiz.loginpage;
import com.example.errahulraj.quiz.second;

public class camera extends AppCompatActivity {

    ImageView i;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        b1 = (Button) findViewById(R.id.capture);
        i = (ImageView) findViewById(R.id.imageView);
        b2=(Button)findViewById(R.id.back);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,0);


            }
        });b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(camera.this,indexpage1.class);
                startActivity(i);
            }
        });
    }
    @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            Toast.makeText(this,data.getExtras().toString(),Toast.LENGTH_SHORT).show();
            Bitmap b=(Bitmap)data.getExtras().get("data");
            i.setImageBitmap(b);

    }
}
