package com.example.raymond.eventfloc;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by RAYMOND on 18/04/2015.
 */
public class Event {
    private int eventID;
    private ArrayList<EventType> eventTypeList;
    private String eventLocation;
    private Date eventDate;
    private String eventDescription;
    private String eventLink;
    private Time eventStartTime;
    private Time eventEndTime;
    private int societyID;

    public Event(ArrayList<EventType> eventTypeList, String eventLocation, Date eventDate, String eventDescription,
                 String eventLink, Time eventStartTime, Time eventEndTime) {
        this.eventTypeList = eventTypeList;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.eventLink = eventLink;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventLink() {
        return eventLink;
    }

    public void setEventLink(String eventLink) {
        this.eventLink = eventLink;
    }

    public Time getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(Time eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public Time getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(Time eventEndTime) {
        this.eventEndTime = eventEndTime;
    }
}
