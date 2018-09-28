package com.example.kshitiz.event1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Technology_events extends AppCompatActivity {
    private DatabaseReference mDatabase;
    ArrayList<Event> event_list = new ArrayList<Event>() ;
    MessageAdapter m1;
    private DatabaseReference mTechRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technology_events);

        mDatabase= FirebaseDatabase.getInstance().getReference();
        mTechRef = FirebaseDatabase.getInstance().getReference().child("events").child("tech");
        ListView listView= (ListView)findViewById(R.id.tech_list);

        m1=new MessageAdapter(this,event_list);
        listView.setAdapter(m1);

        mTechRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if (dataSnapshot != null) {

                    event_list.add(dataSnapshot.getValue(Event.class));
                    m1.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}
