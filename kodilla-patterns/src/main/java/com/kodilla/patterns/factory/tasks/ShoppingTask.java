package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {
    private final String name;
    private final String toBuy;
    private boolean isDone;


    public ShoppingTask(String name, String toBuy) {
        this.name = name;
        this.toBuy = toBuy;
        this.isDone = false;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getName() {
        return name;
    }

    public String getToBuy() {
        return toBuy;
    }

    @Override
    public void executeTask() {
        System.out.println("Shopping task:" + name + "\nYou bought: " + toBuy + "\nDONE!");
        isDone = true;
    }

    @Override
    public String getTaskName() {
        return name;
    }

    @Override
    public boolean isTaskDone() {
        return isDone;
    }
}
