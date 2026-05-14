package com.example.gymplanner.model;

public class TrainingExercise {

    private int id;
    private int trainingId;
    private String name;
    private int series;
    private int repetitions;
    private double Weight;

    public TrainingExercise(){}

    public TrainingExercise(int id, int trainingId, String name, int series, int repetitions, double weight) {
        this.id = id;
        this.trainingId = trainingId;
        this.name = name;
        this.series = series;
        this.repetitions = repetitions;
        Weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
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

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }
}
