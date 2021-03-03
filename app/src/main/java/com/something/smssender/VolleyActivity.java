package com.something.smssender;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class VolleyActivity extends AppCompatActivity {

    Button AddContact;
    EditText EmergencyContact;

   public static MyAppDatabase myAppDatabase;
//    String serverUrl = "http://192.168.0.110/beSafe/addContact.php";
//
//    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        myAppDatabase = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"userdb").allowMainThreadQueries().build();

        EmergencyContact = findViewById(R.id.emergencyContact_id);
        AddContact = findViewById(R.id.addContact_id);

        AddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emergencyContact = EmergencyContact.getText().toString();
//
                EmergencyContact emergencyContact1 = new EmergencyContact();
                emergencyContact1.setContact_number(emergencyContact);
                myAppDatabase.myDao().addContactNumber(emergencyContact1);

//
              Toast.makeText(getApplicationContext(),"contact number successfully adddeddd",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),EmergencyContactInfo.class);
                startActivity( intent);

            }
        });


//        builder = new AlertDialog.Builder(VolleyActivity.this);
//
//        AddContact = findViewById(R.id.addContact_id);
//        EmergencyContact = findViewById(R.id.emergencyContact_id);
//
//        AddContact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("buttton peresssed", "waaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//
//                final String emergencyContact = EmergencyContact.getText().toString();
//
//                StringRequest stringRequest = new StringRequest(Request.Method.POST, serverUrl, new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                            builder.setTitle("Server Response");
//                            builder.setMessage("Response"+response);
//                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//
//                                }
//                            });
//                            AlertDialog alertDialog = builder.create();
//                            alertDialog.show();
//
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                Log.d("errror",""+error);
//                    }
//                }){
//
//                    @Override
//                    protected Map<String, String> getParams() throws AuthFailureError {
//                        Map<String,String> params = new HashMap<>();
//                        params.put("emergency_contact_no",emergencyContact);
//
//                        return params;
//
//
//                    }
//                };
//
//                MySingleton.getInstance(VolleyActivity.this).addtoRequestQueue(stringRequest);

//        }
//
//
//
//    });
}
}

