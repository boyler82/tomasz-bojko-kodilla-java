package com.kodilla.spring.intro.shape;

public class Circle implements Shape{
    @Override
    public String draw() {
        System.out.println("Drawing circle.");
        return "This is a Circle";
    }
}
