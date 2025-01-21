package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task addTask(final String taskClass) {
        return switch (taskClass) {
            case SHOPPING -> new ShoppingTask("Food shopping list", "Milk, eggs");
            case PAINTING -> new PaintingTask("White","renovation", "paint walls, paint doors" );
            case DRIVING -> new DrivingTask("Go swimming", "Main St.", "Bike");
            default -> null;
        };
    }

}
