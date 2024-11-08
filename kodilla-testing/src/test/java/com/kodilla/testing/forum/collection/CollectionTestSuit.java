package com.kodilla.testing.forum.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuit {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName("when using exterminate method empty list, " +
            "then exterminate method should give empty list"
    )
    //testOddNumbersExterminatorEmptyList
    @Test
    void testOddNumbersExterminatorEmptyList() {
    //        Given
        List<Integer> testList = new ArrayList<>();
        OddNumbersExterminator testExterminator = new OddNumbersExterminator(testList);
    //        When
        List<Integer> result = testExterminator.exterminate(testList);

    //        Then

        Assertions.assertTrue( result.isEmpty(), "If true lis is empty as expected.");
    }


    @DisplayName("when using exterminate method on list, " +
            "then exterminate method should give same even numbers list"
    )
    //testOddNumbersExterminatorNormalList
    @Test
    void testOddNumbersExterminatorNormalList() {
    //        Given
        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        OddNumbersExterminator testExterminator = new OddNumbersExterminator(testList);
    //        When
        List<Integer> result = testExterminator.exterminate(testList);

    //        Then
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(4);
        Assertions.assertEquals(expected, result);
    }
}
