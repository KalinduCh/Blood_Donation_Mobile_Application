package com.example.questionnaire;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class BDonatingLocations {
    private String date;
    private String id;
    private String time;
    private String venue;
    private String description;
    private String notice;

    public BDonatingLocations() {}

    public BDonatingLocations(String date, String id, String time, String venue, String description, String notice)
    {
        this.date = date;
        this.id = id;
        this.time = time;
        this.venue = venue;
        this.description = description;
        this.notice = notice;
    }

    public BDonatingLocations(String date, String time, String venue, String description, String notices) {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}


