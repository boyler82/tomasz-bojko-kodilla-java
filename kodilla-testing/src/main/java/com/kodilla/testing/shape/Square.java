package com.kodilla.testing.shape;

import java.security.PrivateKey;
import java.util.Objects;

public class Square implements Shape {
    private String name;
    private String area;

    public Square(String name, String area) {
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
        Square square = (Square) o;
        return Objects.equals(name, square.name) && Objects.equals(area, square.area);
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

