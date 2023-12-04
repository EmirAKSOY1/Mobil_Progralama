package com.example.mobil_prog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.PixelCopy;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

public class SmsActivity extends AppCompatActivity {

    private EditText tel,mesaj;
    private  String txtnumber,txtmsg;
    private  String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        tel=(EditText)findViewById(R.id.tel);
        mesaj=(EditText)findViewById(R.id.mesaj);
    }
    public void Sms_send(View v){
        if(ContextCompat.checkSelfPermission(SmsActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
            sendOtp();
        }else {
            ActivityCompat.requestPermissions(SmsActivity.this, new String[]{Manifest.permission.SEND_SMS},100);
        }
    }
    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 100){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                sendOtp();

            }else {
                Toast.makeText(this, "Lütfen izini onaylayın!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void sendOtp(){
        txtmsg = mesaj.getText().toString();
        txtnumber = tel.getText().toString();

        if(!txtmsg.isEmpty() && !txtnumber.isEmpty()){
            try{
                SmsManager smsManager = SmsManager.getDefault();
                ArrayList<String> parts = smsManager.divideMessage(txtmsg);
                smsManager.sendMultipartTextMessage(txtnumber,null,parts,null,null);
                Toast.makeText(getApplicationContext(),"Başarılı",Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Toast.makeText(getApplicationContext(),"Bir problem var",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(),"Telefon Numarası ve Mesaj boş bırakılamaz" , Toast.LENGTH_SHORT).show();
        }
    }
    public void Soz_getir(View v){
        mesaj.setText("");
        url="https://api.adviceslip.com/advice";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject data =(JSONObject)response.get("slip");
                    mesaj.setText(data.get("advice").toString());

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Bekenmdik Bir hata oluştu", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Lütfen internet bağlantınızı kontrol ediniz", Toast.LENGTH_SHORT).show();
            }

    });
        Volley.newRequestQueue(this).add(request);
    }


}