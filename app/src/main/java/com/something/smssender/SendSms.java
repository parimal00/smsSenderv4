package com.something.smssender;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;

import java.util.List;

public class SendSms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        Intent intent = getIntent();
        String latitude = intent.getStringExtra("latitude");
        String longitude = intent.getStringExtra("longitude");


        List<EmergencyContact> emergencyContacts = VolleyActivity.myAppDatabase.myDao().getEmergencyContact();
        String user = "";
//
        for (EmergencyContact emergencyContact : emergencyContacts){
            String contact_info = emergencyContact.getContact_number();
            int id = emergencyContact.getId();
            Log.d("waaaaaaaaaaaaaaa",contact_info);


                String sms = "latitude: "+latitude+"\n longitude: "+longitude;

                    if(checkSelfPermission(Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){
                        sendSms(contact_info,sms);
                    }
                    else {
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS},1);
                    }
        }

    }


    private void sendSms(String phone_no, String sms) {

        Log.d("smssss",""+phone_no+sms);

       try {
           SmsManager smsManager = SmsManager.getDefault();
           smsManager.sendTextMessage(phone_no,null,sms,null,null);

       }catch (Exception e){
            Log.d("bitch","err0r");
       }



    }

}
