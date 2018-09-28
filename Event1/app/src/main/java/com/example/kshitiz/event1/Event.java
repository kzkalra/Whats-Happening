package com.example.kshitiz.event1;

public class Event {	//make two more like this for sports evn

    public String header;
    public String date;
    public String venue;
    public String time;
    public int starCount;
    public String description;
   // public int type; //1 for sports, 2 for cultural, 3 for technology

    public Event() {
        // Default constructor required for calls to DataSnapshot.getValue(Event.class)
    }

    public Event(String header, String date, String venue, String time, String description)
    {
        this.header = header;
        this.date = date;
        this.venue = venue;
        this.time = time;
        this.description=description;
        //this.type=type;
        starCount = 0;	//initially;
    }

    @Override
    public String toString() {
        return this.header + "\n" + this.date +"\n"+this.time + this.venue + this.description;
    }

    public String getName()
    {
        return header;
    }
    public void setName(String header)
    {
        this.header=header;
    }
    public String getVenue()
    {
        return venue;
    }
    public void setVenue(String venue)
    {
        this.venue=venue;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}