package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class ForumMain {
    public static void main(String[] args) {
        Forum firstForum = new Forum();

        Map<Integer, ForumUser> theMapResult = firstForum.getForumUsers().stream()
                .filter(forumUser -> forumUser.getGender() == 'M')
                .filter(forumUser -> LocalDate.now().getYear() - forumUser.getBirthday().getYear() > 20)
                .filter(forumUser -> forumUser.getNumberOfPosts()>0)
                .collect(Collectors.toMap(ForumUser::getId, forumUser -> forumUser));

        System.out.println("# new Map: " + theMapResult.size());

        theMapResult.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
