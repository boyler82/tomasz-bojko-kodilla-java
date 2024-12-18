package com.kodilla.spring.intro.shape;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawerTestSuite {

    @Test
    void testDrawingWithCircle() {
//        Given
        Circle circle = new Circle();

//        When
        Drawer drawer = new Drawer(circle);
        String result = drawer.doDrawing();
//        Then
        assertEquals("This is a Circle",result);
    }
}
