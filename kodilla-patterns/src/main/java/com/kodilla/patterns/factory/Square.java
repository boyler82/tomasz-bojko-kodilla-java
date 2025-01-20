package com.kodilla.patterns.factory;

public class Square implements Shape{
    private final String name;
    private final double side;


    public Square(String name, double side) {
        this.name = name;
        this.side = side;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getCircumference() {
        return 4 * side;
    }
}
