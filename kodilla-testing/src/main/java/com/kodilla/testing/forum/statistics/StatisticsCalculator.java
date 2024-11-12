package com.kodilla.testing.forum.statistics;

import java.util.List;
import java.util.Objects;

public class StatisticsCalculator {

    private Statistics statistics;
    public StatisticsCalculator(Statistics statistics) {
        this.statistics = statistics;
    }

    private int userCount;
    private int postCount;
    private int commentCount;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public StatisticsCalculator() {
    }
    public StatisticsCalculator(Statistics statistics, int userCount, int postCount, int commentCount, double averagePostsPerUser, double averageCommentsPerUser, double averageCommentsPerPost) {
        this.statistics = statistics;
        this.userCount = userCount;
        this.postCount = postCount;
        this.commentCount = commentCount;
        this.averagePostsPerUser = averagePostsPerUser;
        this.averageCommentsPerUser = averageCommentsPerUser;
        this.averageCommentsPerPost = averageCommentsPerPost;
    }

    public Statistics getStatistics() {
        return statistics;
    }
    public int getUserCount() {
        return userCount;
    }
    public int getPostCount() {
        return postCount;
    }
    public int getCommentCount() {
        return commentCount;
    }
    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }
    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }
    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticsCalculator that = (StatisticsCalculator) o;
        return getUserCount() == that.getUserCount() && getPostCount() == that.getPostCount() && getCommentCount() == that.getCommentCount() && Double.compare(getAveragePostsPerUser(), that.getAveragePostsPerUser()) == 0 && Double.compare(getAverageCommentsPerUser(), that.getAverageCommentsPerUser()) == 0 && Double.compare(getAverageCommentsPerPost(), that.getAverageCommentsPerPost()) == 0 && Objects.equals(getStatistics(), that.getStatistics());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatistics(), getUserCount(), getPostCount(), getCommentCount(), getAveragePostsPerUser(), getAverageCommentsPerUser(), getAverageCommentsPerPost());
    }

    public void calculateAdvStatistics(Statistics statistics) {
        userCount = statistics.usersNames().size();
        postCount = statistics.postsCount();
        commentCount = statistics.commentsCount();

        averagePostsPerUser = (userCount > 0) ? (double) postCount / userCount : 0;
        averageCommentsPerUser = (userCount > 0) ? (double) commentCount / userCount : 0;
        averageCommentsPerPost = (postCount > 0) ? (double) commentCount / postCount : 0;
    }
    public void showStatistics() {
        System.out.println("Number of user in forum: " + statistics.usersNames().size());
        System.out.println("Number of post in forum: " + statistics.postsCount());
        System.out.println("Number of comments in forum: " + statistics.commentsCount());
        System.out.println("Average post per user: " + averagePostsPerUser);
        System.out.println("Average comment per user: " + averageCommentsPerUser);
        System.out.println("Average comment per post: " + averageCommentsPerPost);
    }
}
