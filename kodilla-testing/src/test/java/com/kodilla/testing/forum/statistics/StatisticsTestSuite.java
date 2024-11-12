package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;

    @Test
    void testStatistics0Posts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(0);

        StatisticsCalculator calculator = new StatisticsCalculator();
        calculator.calculateAdvStatistics(statisticsMock);

        // When
        int postCount = calculator.getPostCount();

        // Then
        assertEquals(0, postCount);
    }
    @Test
    void testStatistics1000Posts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(1000);

        StatisticsCalculator calculator = new StatisticsCalculator();
        calculator.calculateAdvStatistics(statisticsMock);

        // When
        int postCount = calculator.getPostCount();

        // Then
        assertEquals(1000, postCount);
    }
    @Test
    void testStatistics0Comments() {
        // Given
        when(statisticsMock.commentsCount()).thenReturn(0);

        StatisticsCalculator calculator = new StatisticsCalculator();
        calculator.calculateAdvStatistics(statisticsMock);

        // When
        int commentsCount = calculator.getCommentCount();

        // Then
        assertEquals(0, commentsCount);
    }
    @Test
    void testStatisticsLessCommentsThenPosts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(1);
        when(statisticsMock.commentsCount()).thenReturn(10);

        StatisticsCalculator calculator = new StatisticsCalculator();
        calculator.calculateAdvStatistics(statisticsMock);

        // When
        int postCount = calculator.getPostCount();
        int commentsCount = calculator.getCommentCount();

        // Then
        assertEquals(1, postCount);
        assertEquals(10, commentsCount);
        assertTrue(commentsCount>postCount);
    }
    @Test
    void testStatisticsMoreCommentsThenPosts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(1);

        StatisticsCalculator calculator = new StatisticsCalculator();
        calculator.calculateAdvStatistics(statisticsMock);

        // When
        int postCount = calculator.getPostCount();
        int commentsCount = calculator.getCommentCount();

        // Then
        assertEquals(10, postCount);
        assertEquals(1, commentsCount);
        assertFalse(commentsCount>postCount);
    }
    @Test
    void testStatistics0Users() {
        // Given
        List<String> userList = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(userList);

        StatisticsCalculator calculator = new StatisticsCalculator();
        calculator.calculateAdvStatistics(statisticsMock);

        // When
        int userCount = calculator.getUserCount();

        // Then
        assertEquals(0, userCount);


    }
    @Test
    void testStatistics100Users() {
        // Given
        List<String> userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            userList.add("user" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(userList);

        StatisticsCalculator calculator = new StatisticsCalculator();
        calculator.calculateAdvStatistics(statisticsMock);

        // When
        int userCount = calculator.getUserCount();

        // Then
        assertEquals(100, userCount);

    }
}
