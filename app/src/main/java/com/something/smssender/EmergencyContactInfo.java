package com.something.smssender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class EmergencyContactInfo extends AppCompatActivity {

    TextView ShowEmergencyContact;
    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_contact_info);


        myAppDatabase = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"userdb").allowMainThreadQueries().build();

        ShowEmergencyContact = findViewById(R.id.showEmergencyContact_id);
        VolleyActivity volleyActivity = new VolleyActivity();

        EmergencyContact emergencyContact1 = new EmergencyContact();

        try{
            String user = "";
            List<EmergencyContact> emergencyContacts = myAppDatabase.myDao().getEmergencyContact();
            for (EmergencyContact emergencyContact : emergencyContacts){
                String contact_info = emergencyContact.getContact_number();
                int id = emergencyContact.getId();
                Log.d("waaaaaaaaaaaaaaa",contact_info);
                user = user+ "id: "+id+"\n"+ "contact Number: " +contact_info+"\n";
                ShowEmergencyContact.setText(user);
            }
        }catch (Exception e){
            Log.d("waaaaaaaaaaaaa","errr"+e);
        };



//



    }
}
