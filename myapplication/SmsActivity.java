package com.example.myapplication;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
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
    private EditText editTextPhone,editTextMessage;
    private  String txtnumber,txtmsg;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        editTextPhone=(EditText)findViewById(R.id.editTextPhone);
        editTextMessage=(EditText)findViewById(R.id.editTextMessage);

    }
    public void Sms_send(View v){
        if(ContextCompat.checkSelfPermission(SmsActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
            sendOTP();
        }else {
            ActivityCompat.requestPermissions(SmsActivity.this, new String[]{Manifest.permission.SEND_SMS},100);
        }
    }
    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 100){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                sendOTP();

            }else {
                Toast.makeText(this, "Lütfen izini onaylayın!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void sendOTP() {

        txtnumber = editTextPhone.getText().toString();
        txtmsg = editTextMessage.getText().toString();

        if(!txtnumber.isEmpty() && !txtmsg.isEmpty()){

            try {
                SmsManager smsManager = SmsManager.getDefault();
                ArrayList<String> parts = smsManager.divideMessage(txtmsg);
                String phoneNumber = txtnumber;
                smsManager.sendMultipartTextMessage(phoneNumber,null,parts,null,null);
                Toast.makeText(getApplicationContext(),
                        "Başarılı", Toast.LENGTH_LONG).show();
            }
            catch (Exception e)
            {
                Toast.makeText(getApplicationContext(),
                        "SMS Gönderimi Hatalı Lütfen tekrar deneyiniz!", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(),
                    "Telefon Numarası ve Mesaj Boş bırakılamaz", Toast.LENGTH_LONG).show();
        }
    }
    public void soz_getir(View v){
        editTextMessage.setText("");
        url="https://api.adviceslip.com/advice";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject data = (JSONObject)response.get("slip");
                    editTextMessage.setText(data.get("advice").toString());

                }catch(Exception e){
                    System.out.println("Hata");
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(request);
    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(SmsActivity.this, MainActivity.class);
        finish();
        startActivity(intent);
        System.out.println("as");
    }




}