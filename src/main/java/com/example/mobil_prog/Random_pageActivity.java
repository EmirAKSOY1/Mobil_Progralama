package com.example.mobil_prog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class Random_pageActivity extends AppCompatActivity {
    private EditText adet,min,max;
    private int ad,mi,ma;
    private double yuzde,toplamfark,degerfark;

    private TextView mintext,maxtext,valuetext;
    private LinearLayout linear,lly;
    private SeekBar sb;
    private Random random;

    private LinearLayout.LayoutParams params;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_page);

        adet = (EditText)findViewById(R.id.editTextNumber);
        min = (EditText)findViewById(R.id.editTextNumber3);
        max = (EditText)findViewById(R.id.editTextNumber4);

        linear = (LinearLayout)findViewById(R.id.asd);
        random = new Random();

    }
    public void Uret(View v){
        try {
            linear.removeAllViews();
            ad = Integer.parseInt(adet.getText().toString());
            mi = Integer.parseInt(min.getText().toString());
            ma = Integer.parseInt(max.getText().toString());

            for (int i = 0; i < ad; i++) {
                int random1 = random.nextInt(ma - mi + 1) + mi;
                int random2 = random.nextInt(ma - mi + 1) + mi;

                int min = Math.min(random1, random2);
                int max = Math.max(random1, random2);

                int value = random.nextInt(max - min + 1) + min;

                lly = new LinearLayout(this);
                sb = new SeekBar(this);

                mintext = new TextView(this);
                maxtext = new TextView(this);
                valuetext = new TextView(this);

                params = new LinearLayout.LayoutParams(1000,150);

                toplamfark = max - min ;
                degerfark = value-min ;
                yuzde = (degerfark/toplamfark)*100;

                System.out.println(yuzde);

                sb.setLayoutParams(params);
                sb.setProgress(value);

                mintext.setText(Integer.toString(min));
                maxtext.setText(Integer.toString(max));
                valuetext.setText(Integer.toString(value)+ "=%"+ yuzde);

                lly.addView(mintext);
                lly.addView(sb);
                lly.addView(maxtext);
                linear.addView(valuetext);
                linear.addView(lly);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}