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
        when(statisticsMock.commentsCount()).thenReturn(0);
        List<String> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userList.add("user" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(userList);

        StatisticsCalculator calculator = new StatisticsCalculator();
        calculator.calculateAdvStatistics(statisticsMock);

        // When
        int postCount = calculator.getPostCount();
        double averagePostsPerUser = calculator.getAveragePostsPerUser();
        double averageCommentsPerUser = calculator.getAverageCommentsPerUser();
        double averageCommentsPerPost = calculator.getAverageCommentsPerPost();

        // Then
        assertEquals(0, postCount);
        assertEquals(0, averagePostsPerUser);
        assertEquals(0, averageCommentsPerUser);
        assertEquals(0, averageCommentsPerPost);
    }

    @Test
    void testStatistics1000Posts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(1000);
        List<String> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userList.add("user" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(userList);

        StatisticsCalculator calculator = new StatisticsCalculator();
        calculator.calculateAdvStatistics(statisticsMock);

        // When
        int postCount = calculator.getPostCount();
        double averagePostsPerUser = calculator.getAveragePostsPerUser();
        double averageCommentsPerUser = calculator.getAverageCommentsPerUser();
        double averageCommentsPerPost = calculator.getAverageCommentsPerPost();

        // Then
        assertEquals(1000, postCount);
        assertEquals(100, averagePostsPerUser, 0.01);
        assertEquals(100, averageCommentsPerUser, 0.01);
        assertEquals(1, averageCommentsPerPost, 0.01);

    }
    @Test
    void testStatistics0Comments() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);
        List<String> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userList.add("user" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(userList);

        StatisticsCalculator calculator = new StatisticsCalculator();
        calculator.calculateAdvStatistics(statisticsMock);

        // When
        int commentCount = calculator.getCommentCount();

        double averagePostsPerUser = calculator.getAveragePostsPerUser();
        double averageCommentsPerUser = calculator.getAverageCommentsPerUser();
        double averageCommentsPerPost = calculator.getAverageCommentsPerPost();

        // Then
        assertEquals(0, commentCount);
        assertEquals(100, averagePostsPerUser, 0.01);
        assertEquals(0, averageCommentsPerUser, 0.01);
        assertEquals(0, averageCommentsPerPost, 0.01);

    }
    @Test
    void testStatisticsLessCommentsThenPosts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(10);
        List<String> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userList.add("user" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(userList);

        StatisticsCalculator calculator = new StatisticsCalculator();
        calculator.calculateAdvStatistics(statisticsMock);
        // When
        int postCount = calculator.getPostCount();
        int commentsCount = calculator.getCommentCount();
        double averagePostsPerUser = calculator.getAveragePostsPerUser();
        double averageCommentsPerUser = calculator.getAverageCommentsPerUser();
        double averageCommentsPerPost = calculator.getAverageCommentsPerPost();



        // Then
        assertEquals(1000, postCount);
        assertEquals(10, commentsCount);
        assertTrue(commentsCount<postCount);
        assertEquals(100, averagePostsPerUser, 0.01);
        assertEquals(1, averageCommentsPerUser, 0.01);
        assertEquals(0, averageCommentsPerPost, 0.01);
    }
    @Test
    void testStatisticsMoreCommentsThenPosts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(1000);
        List<String> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userList.add("user" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(userList);

        StatisticsCalculator calculator = new StatisticsCalculator();
        calculator.calculateAdvStatistics(statisticsMock);
        // When
        int postCount = calculator.getPostCount();
        int commentsCount = calculator.getCommentCount();
        double averagePostsPerUser = calculator.getAveragePostsPerUser();
        double averageCommentsPerUser = calculator.getAverageCommentsPerUser();
        double averageCommentsPerPost = calculator.getAverageCommentsPerPost();


        // Then
        assertEquals(10, postCount);
        assertEquals(1000, commentsCount);
        assertTrue(commentsCount > postCount);
        assertEquals(1, averagePostsPerUser, 0.01);
        assertEquals(100, averageCommentsPerUser, 0.01);
        assertEquals(100, averageCommentsPerPost, 0.01);
    }


    @Test
    void testStatistics0Users() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        List<String> userList = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(userList);

        StatisticsCalculator calculator = new StatisticsCalculator();
        calculator.calculateAdvStatistics(statisticsMock);

        // When
        int userCount = calculator.getUserCount();
        double averagePostsPerUser = calculator.getAveragePostsPerUser();
        double averageCommentsPerUser = calculator.getAverageCommentsPerUser();
        double averageCommentsPerPost = calculator.getAverageCommentsPerPost();
        // Then
        assertEquals(0, userCount);
        assertEquals(0, averagePostsPerUser, 0.01);
        assertEquals(0, averageCommentsPerUser, 0.01);
        assertEquals(0, averageCommentsPerPost, 0.01);

    }
    @Test
    void testStatistics100Users() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(100);
        List<String> userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            userList.add("user" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(userList);

        StatisticsCalculator calculator = new StatisticsCalculator();
        calculator.calculateAdvStatistics(statisticsMock);

        // When
        int userCount = calculator.getUserCount();
        double averagePostsPerUser = calculator.getAveragePostsPerUser();
        double averageCommentsPerUser = calculator.getAverageCommentsPerUser();
        double averageCommentsPerPost = calculator.getAverageCommentsPerPost();
        // Then
        assertEquals(100, userCount);
        assertEquals(1, averagePostsPerUser, 0.01);
        assertEquals(1, averageCommentsPerUser, 0.01);
        assertEquals(1, averageCommentsPerPost, 0.01);

    }
}
