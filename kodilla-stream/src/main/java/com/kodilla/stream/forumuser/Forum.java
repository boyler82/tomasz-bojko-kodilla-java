package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> forumUsers = new ArrayList<>();

    public Forum() {
        forumUsers.add(new ForumUser(1, "Jon", 'M', LocalDate.of(1989, 11, 10), 10));
        forumUsers.add(new ForumUser(2, "Alice", 'F', LocalDate.of(1995, 5, 15), 1));
        forumUsers.add(new ForumUser(3, "Mike", 'M', LocalDate.of(2000, 3, 21), 5));
        forumUsers.add(new ForumUser(4, "Sarah", 'F', LocalDate.of(1987, 7, 8), 0));
        forumUsers.add(new ForumUser(5, "Chris", 'M', LocalDate.of(1992, 12, 19), 1));
        forumUsers.add(new ForumUser(6, "Emily", 'F', LocalDate.of(1999, 2, 14), 12));
        forumUsers.add(new ForumUser(7, "Steve", 'M', LocalDate.of(1994, 6, 11), 0));
        forumUsers.add(new ForumUser(8, "Laura", 'F', LocalDate.of(1985, 9, 30), 50));
        forumUsers.add(new ForumUser(9, "Tom", 'M', LocalDate.of(1990, 4, 5), 7));
        forumUsers.add(new ForumUser(10, "Anna", 'F', LocalDate.of(1997, 1, 25), 0));
    }
    public List<ForumUser> getForumUsers() {
        return forumUsers;
    }
}
