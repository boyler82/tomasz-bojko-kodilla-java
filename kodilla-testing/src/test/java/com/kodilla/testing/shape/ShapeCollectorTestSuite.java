    package com.kodilla.testing.shape;

import com.kodilla.testing.forum.ForumPost;
import org.junit.jupiter.api.*;

@DisplayName("TDD Shape Controller Test Suite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;
    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Starting Test Suite");
    }
    @AfterAll
    public static void afterAllTests() {
        System.out.println("Finished Test Suite");
    }
    @BeforeEach
    public void beforeEach() {
        testCounter++;
        System.out.println("Test no. *" + testCounter + "* started");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Test no. *" + testCounter + "* finished");
    }
    
    @Nested
    @DisplayName("List method tests")
    class methodTest {
        @Test
        void testAddFigure() {
        // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circleGiven = new Circle("circle","A=pi*r**2");
            shapeCollector.addFigure(circleGiven);
        // When
            Shape circleExpected = new Circle("circle","A=pi*r**2");
        // Then
            Assertions.assertEquals(circleGiven, circleExpected);
        }

        @Test
        void testRemoveFigure() {
        // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circleGiven = new Circle("circle","A=pi*r**2");
            shapeCollector.addFigure(circleGiven);

        // When
            boolean result = shapeCollector.removeFigure(circleGiven);
        // Then
            Assertions.assertTrue(result);
        }

        @Test
        void testRemoveNotExistingFigure() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circleGiven = new Circle("circle","A=pi*r**2");
            shapeCollector.removeFigure(circleGiven);
            // When
            boolean result = shapeCollector.removeFigure(circleGiven);
            // Then
            Assertions.assertFalse(result);
        }

        @Test
        void testGetFigure() {
        // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circleGiven = new Circle("circle","A=pi*r**2");
            shapeCollector.addFigure(circleGiven);
        // When
            Shape result = shapeCollector.getFigure(0);
        // Then
            Assertions.assertEquals(circleGiven, result);
        }
    }
    @Nested
    @DisplayName("Display list test")
    class displayList {
        @Test
        void testShowFigures() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle("Circle", "A=pi*r**2");
            Shape square = new Square("Square", "A=a*a");
            Shape triangle = new Triangle("Triangle", "A=0.5*b*h");

            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);

            // When
            String result = shapeCollector.showFigures();

            // Then
            String expected = "Circle A=pi*r**2, Square A=a*a, Triangle A=0.5*b*h";
            Assertions.assertEquals(expected, result);
        }
    }
}