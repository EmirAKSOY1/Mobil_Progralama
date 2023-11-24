package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView no ,name;
    private Button cvt,rnd,sms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        no =(TextView)findViewById(R.id.textView_no);
        name =(TextView)findViewById(R.id.textView_name);

        cvt =(Button) findViewById(R.id.cvt);
        rnd =(Button)findViewById(R.id.rnd);
        sms =(Button)findViewById(R.id.sms);



        ObjectAnimator animator_no = ObjectAnimator.ofFloat(no, "translationY", -100f);
        ObjectAnimator animator_name = ObjectAnimator.ofFloat(name, "translationY", -100f);

        ObjectAnimator animator_cvt = ObjectAnimator.ofFloat(cvt, "translationY", -100f);
        ObjectAnimator animator_rnd = ObjectAnimator.ofFloat(rnd, "translationY", -100f);
        ObjectAnimator animator_sms = ObjectAnimator.ofFloat(sms, "translationY", -100f);

        animator_no.setDuration(2000);
        animator_name.setDuration(2000);
        animator_rnd.setDuration(2000);
        animator_sms.setDuration(2000);
        animator_cvt.setDuration(2000);


        animator_no.start();
        animator_name.start();
        animator_rnd.start();
        animator_cvt.start();
        animator_sms.start();


    }
    public void Sms_at(View v){
        Intent intent = new Intent(MainActivity.this, SmsActivity.class);
        finish();
        startActivity(intent);
    }
    public void Convert(View v){
        Intent intent = new Intent(MainActivity.this, ConvertActivity.class);
        finish();
        startActivity(intent);
    }
    public void Random(View v){
        Intent intent = new Intent(MainActivity.this, RandomActivity.class);
        finish();
        startActivity(intent);
    }
}