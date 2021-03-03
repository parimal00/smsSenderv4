package com.something.smssender;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText Phone_no,Sms;
    Button Send_Sms, GetLocation, ViewContact,AddContact, DeleteContact;

    FusedLocationProviderClient fusedLocationProviderClient;

    String latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);


        Phone_no= findViewById(R.id.phone_no_id);
        Sms = findViewById(R.id.sms_id);
        Send_Sms = findViewById(R.id.sendSms_id);

        Send_Sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String phone_no = Phone_no.getText().toString();
//                String sms = Sms.getText().toString();
//
//                    if(checkSelfPermission(Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){
//                        sendSms(phone_no,sms);
//                    }
//                    else {
//                        requestPermissions(new String[]{Manifest.permission.SEND_SMS},1);
//                    }
//

                Intent intent = new Intent(getApplicationContext(),SendSms.class);
                intent.putExtra("latitude",latitude);
                intent.putExtra("longitude",longitude);

                startActivity(intent);

            }
        });


        GetLocation = findViewById(R.id.getLocation_id);

        GetLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
                    getLocation();
                }else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},44);
                }
            }
        });

        ViewContact =findViewById(R.id.viewContact_id);
        ViewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),EmergencyContactInfo.class);
                startActivity(intent);
            }
        });

        AddContact = findViewById(R.id.addContactttt_id);
        AddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),VolleyActivity.class);
                startActivity(intent);
            }
        });


        DeleteContact = findViewById(R.id.deleteContact_id);
        DeleteContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DeleteContact.class);
                startActivity(intent);
            }
        });

    }

    private void getLocation() {
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if(location!=null){
                    Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                    try {

                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                        Log.d("location ",""+addresses.get(0).getLatitude());
                        latitude = ""+addresses.get(0).getLatitude();
                        longitude =""+ addresses.get(0).getLongitude();
                        Sms.setText("latitude: "+latitude+"  longitude: "+longitude);

                    }catch (Exception abcd){

                    }

                }
            }
        });
    }

    private void sendSms(String phone_no, String sms) {

//        Log.d("smssss",""+phone_no+sms);
//
//       try {
//           SmsManager smsManager = SmsManager.getDefault();
//           smsManager.sendTextMessage(phone_no,null,sms,null,null);
//
//       }catch (Exception e){
//            Log.d("bitch","err0r");
//       }
//
//
        Intent intent = new Intent(this,VolleyActivity.class);
        startActivity(intent);
    }
}
