package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {
    private final String name;
    private final String toPaint;
    private final String color;
    private boolean isDone;

    public PaintingTask(String color, String name, String toPaint) {
        this.color = color;
        this.name = name;
        this.toPaint = toPaint;
        this.isDone = false;
    }

    public String getColor() {
        return color;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getName() {
        return name;
    }

    public String getToPaint() {
        return toPaint;
    }

    @Override
    public void executeTask() {
        System.out.println("Task: " + getName() + "You paint " + getTaskName() + "on colour " + getColor()  + "\nDONE");
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
