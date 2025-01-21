package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {
    private final String name;
    private final String getToPlace;
    private final String vehicle;
    private boolean isDone;

    public DrivingTask(String getToPlace, String name, String vehicle) {
        this.getToPlace = getToPlace;
        this.name = name;
        this.vehicle = vehicle;
        this.isDone = false;
    }

    public String getGetToPlace() {
        return getToPlace;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getName() {
        return name;
    }

    public String getVehicle() {
        return vehicle;
    }

    @Override
    public void executeTask() {
        System.out.println("Ok");
        setDone(true);
    }


    @Override
    public String getTaskName() {
        return getName();
    }

    @Override
    public boolean isTaskDone() {
        return isDone();
    }
}
