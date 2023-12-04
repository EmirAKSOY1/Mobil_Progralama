package com.example.mobil_prog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ConventerActivity extends AppCompatActivity {

    private EditText input_decimal,mb_input;
    private TextView input_result,mb_result;
    private int decimal,mb;

    private EditText cel_input;
    private  TextView cel_result;

    private RadioGroup radioGroup;
    private RadioButton f,k;
    private int cel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conventer);

        Spinner spinnerExample = findViewById(R.id.spinner);
        Spinner spinnerExample2 = findViewById(R.id.spinner2);

        input_decimal = findViewById(R.id.input_decimal);
        input_result = findViewById(R.id.decimal_result);

        mb_input = findViewById(R.id.mb_input);
        mb_result = findViewById(R.id.mb_result);

        f=(RadioButton)findViewById(R.id.f);
        k=(RadioButton)findViewById(R.id.k);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);

        cel_input = findViewById(R.id.cel_input);
        cel_result = findViewById(R.id.cel_result);

        List<String> islemler = new ArrayList<>();
        islemler.add("Binary");
        islemler.add("Octal");
        islemler.add("Hexadecimal");

        List<String> islemler_mb = new ArrayList<>();
        islemler_mb.add("Kilobyte");
        islemler_mb.add("Byte");
        islemler_mb.add("Kibibyte");
        islemler_mb.add("Bit");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,islemler);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerExample.setAdapter(adapter);
        spinnerExample.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                try{
                    decimal = Integer.parseInt(input_decimal.getText().toString());

                    switch (i){
                        case 0:
                            input_result.setText(Integer.toBinaryString(decimal));
                            break;
                        case 1:
                            input_result.setText(Integer.toOctalString(decimal));
                            break;
                        case 2:
                            input_result.setText(Integer.toHexString(decimal));
                            break;

                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> adapter_mb = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,islemler_mb);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerExample2.setAdapter(adapter_mb);
        spinnerExample2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                try{
                    mb=Integer.parseInt(mb_input.getText().toString());

                    switch (i){
                        case 0://Kilobyte
                            mb_result.setText(mb*1000+" Kilobyte");
                            break;
                        case 1://byte
                            mb_result.setText(mb*1000000+" Byte");
                            break;
                        case 2://kibibyte
                            mb_result.setText(mb*9765625+" Kibibyte");
                            break;
                        case 3://bit
                            mb_result.setText(mb*8000000+" Bit");
                            break;


                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        try{
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId){
                    cel = Integer.parseInt(cel_input.getText().toString());
                    double donusum;
                    switch (checkedId){
                        case 2131231235:
                            donusum= (cel*9.0/5.0)+32.0;
                            cel_result.setText(Double.toString(donusum));
                            break;
                        case 2131231236:
                            donusum=cel+273.15;
                            cel_result.setText(Double.toString(donusum));
                            break;
                    }
                    System.out.println(checkedId);

                }
            });
        }catch (Exception e){
            System.out.println(e);
        }

    }
}