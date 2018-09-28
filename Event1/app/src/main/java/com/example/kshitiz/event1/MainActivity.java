package com.example.kshitiz.event1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView sports, cultural, tech, upload , log , contact;
    GoogleApiClient mGoogleApiClient;
    GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sports = (CardView) findViewById(R.id.sports_card); // creating a CardView and assigning a value.
        cultural = (CardView) findViewById(R.id.cultural_card); // creating a CardView and assigning a value.
        tech = (CardView) findViewById(R.id.technology_card); // creating a CardView and assigning a value.
        upload = (CardView) findViewById(R.id.polling_card); // creating a CardView and assigning a value.
        log = (CardView) findViewById(R.id.logout_card); // creating a CardView and assigning a value.
        contact = (CardView) findViewById(R.id.contact_card);

        sports.setOnClickListener(this) ;
        cultural.setOnClickListener(this) ;
        tech.setOnClickListener(this) ;
        upload.setOnClickListener(this) ;
        log.setOnClickListener(this) ;
contact.setOnClickListener(this);

        //Button button = (Button)findViewById(R.id.add);
        //button.setOnClickListener(this);

        /*FloatingActionButton addEventButton = findViewById(R.id.fab_upload);
        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button Tapped", Toast.LENGTH_SHORT).show();
                Intent openAddEventScreen = new Intent(MainActivity.this,UploadEventActivity.class);
                startActivity(openAddEventScreen);
            }
        });*/

    }



    @Override
    protected void onStart() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        mGoogleApiClient.connect();
        super.onStart();
    }







    @Override
    public void onClick(View v){
      //  Intent it = new Intent(MainActivity.this, UploadEventActivity.class);
        //startActivity(it);


        Intent i;
        switch (v.getId())
        {
            case R.id.sports_card : Toast.makeText(MainActivity.this, "Sports Events", Toast.LENGTH_SHORT).show();
                i = new Intent(this, Sports_events.class) ;
                startActivity(i);
                break ;
            case R.id.cultural_card : Toast.makeText(MainActivity.this, "Cultural Events", Toast.LENGTH_SHORT).show();
                i = new Intent(this, Cultural_events.class) ;
                startActivity(i);
                break ;
            case R.id.technology_card : Toast.makeText(MainActivity.this, "Technology Events", Toast.LENGTH_SHORT).show();
                i = new Intent(this, Technology_events.class) ;
                startActivity(i);
                break ;
            case R.id.polling_card : Toast.makeText(MainActivity.this, "Add an event", Toast.LENGTH_SHORT).show();
              i=new Intent(this,UploadEventActivity.class);
              startActivity(i);
                break ;
            case R.id.contact_card : Toast.makeText(MainActivity.this, "Contact us", Toast.LENGTH_SHORT).show();
                i=new Intent(this,ContactUs.class);
                startActivity(i);

                break ;
            case R.id.logout_card : Toast.makeText(MainActivity.this, "Log out", Toast.LENGTH_SHORT).show();
                Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                        new ResultCallback<Status>() {
                            @Override
                            public void onResult(Status status) {
                                // ...
                                Toast.makeText(getApplicationContext(),"Logged Out",Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(i);
                            }
                        });
        }


        }





}
