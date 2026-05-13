package com.example.gymplanner.model;

public class Training {

    private int id;
    private int userId;
    private int splitId;
    private String date;
    private int duration;

    public Training(int id, int userId, int splitId, String date, int duration) {
        this.id = id;
        this.userId = userId;
        this.splitId = splitId;
        this.date = date;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSplitId() {
        return splitId;
    }

    public void setSplitId(int splitId) {
        this.splitId = splitId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
