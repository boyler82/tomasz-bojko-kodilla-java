package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Objects;

public final class ForumUser {
    private final int id;
    private final String userName;
    private final char gender;
    private final LocalDate birthday;
    private final int numberOfPosts;

    public ForumUser(int id, String userName, char gender, LocalDate birthday, int numberOfPosts) {
        this.id = id;
        this.userName = userName;
        this.gender = gender;
        this.birthday = birthday;
        this.numberOfPosts = numberOfPosts;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ForumUser forumUser = (ForumUser) o;
        return getId() == forumUser.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }
}
