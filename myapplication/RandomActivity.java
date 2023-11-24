package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;

import java.util.Random;

public class RandomActivity extends AppCompatActivity {
    private EditText adet,min,max;
    private  int ad,mi,ma;
    private Random random;
    private SeekBar sb;
    private LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        linear = (LinearLayout)findViewById(R.id.asd);
        random = new Random();

    }
    public void Uret(View v){
        try{
            adet = (EditText)findViewById(R.id.editTextNumber2);
            min = (EditText)findViewById(R.id.editTextNumber4);
            max = (EditText)findViewById(R.id.editTextNumber5);

            ad=Integer.parseInt(adet.getText().toString());
            mi=Integer.parseInt(min.getText().toString());
            ma=Integer.parseInt(max.getText().toString());

            for(int i = 0 ; i<ad ;i++){
                int randomSayi = random.nextInt(ma-mi+1)+mi;
                sb = new SeekBar(this);
                sb.setProgress(randomSayi);
                linear.addView(sb);
            }
        }catch (Exception e){
            System.out.println("Hata : "+e);
        }

    }

}