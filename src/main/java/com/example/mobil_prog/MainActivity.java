package com.example.mobil_prog;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView no,isim;
    private Button cvt,rnd,sms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        no=(TextView)findViewById(R.id.no);
        isim=(TextView)findViewById(R.id.isim);
        cvt=(Button)findViewById(R.id.cvt);
        rnd=(Button)findViewById(R.id.rnd);
        sms=(Button)findViewById(R.id.sms);

        ObjectAnimator animator_no=ObjectAnimator.ofFloat(no,"TranslationY",100f);
        ObjectAnimator animator_isim=ObjectAnimator.ofFloat(isim,"TranslationY",100f);
        ObjectAnimator animator_cvt=ObjectAnimator.ofFloat(cvt,"TranslationY",100f);
        ObjectAnimator animator_rnd=ObjectAnimator.ofFloat(rnd,"TranslationY",100f);
        ObjectAnimator animator_sms=ObjectAnimator.ofFloat(sms,"TranslationY",100f);

        animator_no.setDuration(2000);
        animator_isim.setDuration(2000);
        animator_cvt.setDuration(2000);
        animator_rnd.setDuration(2000);
        animator_sms.setDuration(2000);

        animator_no.start();
        animator_isim.start();
        animator_cvt.start();
        animator_rnd.start();
        animator_sms.start();
    }
    public void Conventer(View v){
        Intent intent = new Intent(MainActivity.this,ConventerActivity.class);
        finish();
        startActivity(intent);
    }
    public void Random_btn(View v){
        System.out.println("sss");
        Intent intent = new Intent(MainActivity.this,Random_pageActivity.class);
        finish();
        startActivity(intent);
    }
    public void Sms(View v){
        Intent intent = new Intent(MainActivity.this,SmsActivity.class);
        finish();
        startActivity(intent);
    }
}