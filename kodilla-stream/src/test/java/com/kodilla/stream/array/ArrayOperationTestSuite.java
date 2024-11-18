package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationTestSuite {

    @Test
    void testGetAverage() {
//        Given
        int[] num = {2,2,2,2,22,2,2,2,2};
//        When
        double average = ArrayOperations.getAverage(num);
//        Then
        assertEquals(4.22,average, 0.01);
    }
}
