package com.kodilla.spring.intro.shape;

public class Triangle implements Shape{
    @Override
    public String draw() {
        System.out.println("Drawing triangle.");
        return "This is Triangle";
    }
}
