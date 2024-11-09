package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape {
    private String name;
    private String area;

    public Triangle(String name, String area) {
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
        Triangle triangle = (Triangle) o;
        return Objects.equals(name, triangle.name) && Objects.equals(area, triangle.area);
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
