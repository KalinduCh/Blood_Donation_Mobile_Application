package com.example.questionnaire;

public class Hospital {
    private String id;
    private String name;
    private String address;

    public Hospital() {

    }

    public Hospital(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
