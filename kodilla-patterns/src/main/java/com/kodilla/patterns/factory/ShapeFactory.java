package com.kodilla.patterns.factory;

public final class ShapeFactory {

    public static final String CIRCLE = "CIRCLE";
    public static final String SQUARE = "SQUARE";
    public static final String RECTANGLE = "RECTANGLE";


    public final Shape makeShape(final String type) {
        return switch (type) {
            case CIRCLE -> new Circle("Circle", 10);
            case SQUARE -> new Square("Square", 10);
            case RECTANGLE -> new Rectangle("Rectangle", 10, 20);
            default -> null;
        };
    }

}
