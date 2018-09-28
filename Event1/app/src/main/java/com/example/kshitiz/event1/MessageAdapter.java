package com.example.kshitiz.event1;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MessageAdapter extends ArrayAdapter<Event> {
    public MessageAdapter(Context context, ArrayList<Event> objects) {
        super(context,0,objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Event message = getItem(position);
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_event, parent, false);
        }


        TextView nameTextView = (TextView) convertView.findViewById(R.id.event_name);
        TextView timeTextView = (TextView) convertView.findViewById(R.id.event_time);
        TextView venueTextView = (TextView) convertView.findViewById(R.id.event_venue);
        TextView dateTextView = (TextView) convertView.findViewById(R.id.event_date);
        TextView desTextView = (TextView) convertView.findViewById(R.id.event_description);






            nameTextView.setVisibility(View.VISIBLE);
        nameTextView.setText(message.getName());

        timeTextView.setVisibility(View.VISIBLE);
        dateTextView.setVisibility(View.VISIBLE);
        venueTextView.setVisibility(View.VISIBLE);
        desTextView.setVisibility(View.VISIBLE);
        timeTextView.setText(message.getTime());
        venueTextView.setText(message.getVenue());
        dateTextView.setText(message.getDate());
        desTextView.setText(message.getDescription());


        return convertView;
    }
}
