package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.AdapterView;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;

import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
public class ConvertActivity extends AppCompatActivity {

    private EditText input_decimal;
    private TextView decimal_result;
    private int decimal;

    private EditText input_mb;
    private TextView mb_result;
    private int mb_size;

    private EditText cel_input;
    private TextView cel_result;
    private int cel;
    private RadioButton f,k;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        /*-------*/
        Spinner spinnerExample = findViewById(R.id.spinner);
        Spinner spinnerExample_mb = findViewById(R.id.spinner_mb);


        /*-------*/
        input_decimal = (EditText) findViewById(R.id.input_decimal);
        decimal_result = (TextView)findViewById(R.id.decimal_result);

        input_mb = (EditText)findViewById(R.id.input_mb);
        mb_result = (TextView)findViewById(R.id.mb_result);

        cel_input = (EditText)findViewById(R.id.cel_input);
        cel_result = (TextView)findViewById(R.id.cel_result);

        f=(RadioButton)findViewById(R.id.f);
        k=(RadioButton)findViewById(R.id.k);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);


        /*-------*/
        List<String> islemler = new ArrayList<>();
        islemler.add("Binary");
        islemler.add("Octal");
        islemler.add("HexaDecimal");

        List<String> mb = new ArrayList<>();
        mb.add("Kilobyte");
        mb.add("Byte");
        mb.add("Kibibyte");
        mb.add("Bit");

        /*-------*/
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, islemler);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerExample.setAdapter(adapter);

        spinnerExample.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                try {
                    decimal = Integer.parseInt(input_decimal.getText().toString());
                    switch (position) {
                        case 0:
                            decimal_result.setText(Integer.toBinaryString(decimal));
                            break;
                        case 1:

                            decimal_result.setText(Integer.toOctalString(decimal));
                            break;
                        case 2:
                            decimal_result.setText(Integer.toHexString(decimal));
                            break;
                        default:

                            break;

                    }

                }catch (Exception e){

                    System.out.println(e);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Bir şey seçilmediğinde yapılacak işlemleri tanımla (isteğe bağlı)
            }

        });

        ArrayAdapter<String> adapter_mb = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mb);
        adapter_mb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerExample_mb.setAdapter(adapter_mb);

        spinnerExample_mb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position_mb, long id_mb) {
                try {



                    mb_size = Integer.parseInt(input_mb.getText().toString());
                    switch (position_mb) {
                        case 0:


                            mb_result.setText(mb_size*1000+" Kilobyte");
                            break;
                        case 1:

                            mb_result.setText(mb_size*1000000+" Byte");
                            break;
                        case 2:

                            mb_result.setText(mb_size*9765625 + " Kibibyte");
                            break;
                        case 3:
                            mb_result.setText(mb_size*8000000 +"Bit");
                            break;
                        default:
                            System.out.println("Hata");
                            break;

                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Bir şey seçilmediğinde yapılacak işlemleri tanımla (isteğe bağlı)
            }

        });
        try {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    RadioButton radioButton = findViewById(checkedId);

                    cel = Integer.parseInt(cel_input.getText().toString());
                    double donusum;
                    switch (checkedId){
                        case 2131231245:
                            donusum = (cel * 9.0/5.0) + 32.0;
                            cel_result.setText(Double.toString(donusum));
                            break;
                        case 2131231246:
                            donusum = cel+273.15;
                            cel_result.setText(Double.toString(donusum));
                            break;
                    }
                }
            });
        }catch (Exception e){
            System.out.println("Hata celcius");
        }


    }



}