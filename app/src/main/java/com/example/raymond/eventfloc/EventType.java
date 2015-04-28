package com.example.raymond.eventfloc;

/**
 * Created by RAYMOND on 18/04/2015.
 */
public class EventType {
    private int eventTypeID;
    private String eventType;

    public EventType(int eventTypeID, String eventType) {
        this.eventTypeID = eventTypeID;
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getEventTypeID() {
        return eventTypeID;
    }

    public void setEventTypeID(int eventTypeID) {
        this.eventTypeID = eventTypeID;
    }


}
