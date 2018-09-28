package com.example.kshitiz.event1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UploadEventActivity extends AppCompatActivity {

    String e_name, e_date, e_time, e_desc, e_venue;
    String type,e_type;
    private static final String TAG = "EVENTS";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    ChildEventListener ch;
    DatabaseReference myref = database.getReference();
Event event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_event);





        Button submitButton = (Button) findViewById(R.id.button2);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //storing values from the form into strings and other variables
                e_name = ((EditText) findViewById(R.id.eventname)).getText().toString();
                e_date = ((EditText) findViewById(R.id.eventdate)).getText().toString();
                e_time = ((EditText) findViewById(R.id.eventtime)).getText().toString();
                e_desc = ((EditText) findViewById(R.id.eventdescription)).getText().toString();
                e_venue = ((EditText) findViewById(R.id.eventvenue)).getText().toString();
                e_type= ((EditText) findViewById(R.id.eventtype)).getText().toString();


                    /*
                RadioGroup rg = (RadioGroup)findViewById(R.id.select_event);
                String radiovalue = ((RadioButton)this.findViewById(rg.getCheckedRadioButtonId())).getText().toString();

                if(radiovalue.equals("Sports"))
                    type = 1;
                else if(radiovalue.equals("Cultural"))
                    type = 2;
                else if(radiovalue.equals("Technology"))
                    type = 3;
                else
                    type = -1;*/


       if(e_type.equalsIgnoreCase("technology"))
            type="tech";
                else if(e_type.equalsIgnoreCase("sports"))
                    type="sports";
                else
                    type="cultural";

                //now, we will initialise the Event object and then send the values to firebase.
                event = new Event(e_name, e_date, e_venue, e_time, e_desc);

                //mDatabase.child("events").child().setValue(user);

                myref.child("events/" + type).push().setValue(event);  //java object now sent as json to db with a unique key

// Read from the database

                Toast.makeText(UploadEventActivity.this, "Event Uploaded Successfully", Toast.LENGTH_SHORT).show();
                Intent redire = new Intent(UploadEventActivity.this, MainActivity.class);
                startActivity(redire);
            }
        });





    }
}
