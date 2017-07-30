package com.example.errahulraj.quiz;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class forgotpassword extends AppCompatActivity {
Button submi;
    EditText usernam,mobil,newp,cnfp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpassword);
        submi=(Button)findViewById(R.id.submit);
        usernam=(EditText)findViewById(R.id.username);
        mobil=(EditText)findViewById(R.id.mobile);
        newp=(EditText)findViewById(R.id.password);
        cnfp=(EditText)findViewById(R.id.confirmpassword);

        submi.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.DONUT)
            @Override
            public void onClick(View view) {
                    String u=usernam.getText().toString();
                 String  m=mobil.getText().toString();
                String nw=newp.getText().toString();
                String cnf=cnfp.getText().toString();
                if(u.equals("")||m.equals("")||nw.equals("")||cnf.equals("")){
                    Toast.makeText(forgotpassword.this,"FILL ALL",Toast.LENGTH_SHORT).show();
                }else {
                    if (!nw.equals(cnf)) {
                        Toast.makeText(forgotpassword.this, "PASSWORD NOT MATCHED", Toast.LENGTH_SHORT).show();
                    } else {
                        SQLiteDatabase data = openOrCreateDatabase("raj", MODE_PRIVATE, null);
                        String s = "select * from quiz WHERE username='" + u + "' and mobilenumber='" + m + "'";
                        Cursor cursor = data.rawQuery(s, null);
                        if (cursor.getCount() > 0) {
                            String strSQL = "UPDATE quiz SET passwords = '"+nw+"' WHERE username ='"+u+"' and mobilenumber='"+m +"'";
                            data.execSQL(strSQL);
                            int r = Integer.parseInt(nw);
                            int n = (r * r + r) / 7;
                            Random rnd = new Random();
                            rnd.setSeed(n);
                            String otp = Integer.toString(n);
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(m, null, " " + otp + " " + u + "", null, null);
                            Toast.makeText(forgotpassword.this, "OTP SENT TO " + m + "", Toast.LENGTH_LONG).show();
                            Toast.makeText(forgotpassword.this, "PASSWORD UPDATED", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(forgotpassword.this, loginpage.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(forgotpassword.this, "USER NOT EXIST", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

}
}