package com.example.gymplanner.model;

public class Split {

    private int id;
    private int userId;
    private String name;
    private String descricption;

    public Split(){}

    public Split(int id, int userId, String name, String descricption) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.descricption = descricption;
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

    public void setUserId(int user_id) {
        this.userId = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricption() {
        return descricption;
    }

    public void setDescricption(String descricption) {
        this.descricption = descricption;
    }
}
