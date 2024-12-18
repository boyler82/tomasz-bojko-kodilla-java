package com.kodilla.spring.forum;

import com.kodilla.spring.shape.Circle;
import com.kodilla.spring.shape.Shape;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ForumUserTestSuite {

    @Test
    void GetUserName() {
//        Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        ForumUser forumUser = context.getBean(ForumUser.class);
//        When
        String userName = forumUser.userName;
//        Then
        assertEquals("John Smith",userName);
    }
}
