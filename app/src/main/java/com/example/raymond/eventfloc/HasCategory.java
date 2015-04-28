package com.example.raymond.eventfloc;

/**
 * Created by RAYMOND on 18/04/2015.
 */
public class HasCategory {
    private int eventID;
    private int eventTypeID;

    public HasCategory(int eventID, int eventTypeID) {
        this.eventID = eventID;
        this.eventTypeID = eventTypeID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getEventTypeID() {
        return eventTypeID;
    }

    public void setEventTypeID(int eventTypeID) {
        this.eventTypeID = eventTypeID;
    }
}
