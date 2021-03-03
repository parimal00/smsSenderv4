package com.something.smssender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteContact extends AppCompatActivity {

    EditText ID;
    Button Delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_contact);

        ID = findViewById(R.id.contact_ID_id);


        Delete =findViewById(R.id.deleteContacttttt_id);
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(ID.getText().toString());
      Log.d("waaaaaaaaaaaaaaaaaaa",""+id);

      EmergencyContact emergencyContact = new EmergencyContact();
      emergencyContact.setId(id);

      VolleyActivity.myAppDatabase.myDao().deleteUser(emergencyContact);
                Toast.makeText(getApplicationContext(),"delete successful",Toast.LENGTH_SHORT).show();
            }
        });




    }
}
