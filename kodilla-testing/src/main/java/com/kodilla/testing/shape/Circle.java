package com.kodilla.testing.shape;

import java.util.Objects;

public class Circle implements Shape {
    private String name;
    private String area;

    public Circle(String name, String area) {
        this.name = name;
        this.area = area;
    }
    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public String getField() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Objects.equals(name, circle.name) && Objects.equals(area, circle.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, area);
    }

    @Override
    public String toString() {
        return name + " " + area;
    }
}