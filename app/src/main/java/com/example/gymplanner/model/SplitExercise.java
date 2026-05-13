package com.example.gymplanner.model;

public class SplitExercise {

    private int id;
    private int splitId;
    private String name;
    private int series;
    private int repetitions;

    public SplitExercise(int id, int splitId, String name, int series, int repetitions) {
        this.id = id;
        this.splitId = splitId;
        this.name = name;
        this.series = series;
        this.repetitions = repetitions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSplitId() {
        return splitId;
    }

    public void setSplitId(int splitId) {
        this.splitId = splitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }
}
