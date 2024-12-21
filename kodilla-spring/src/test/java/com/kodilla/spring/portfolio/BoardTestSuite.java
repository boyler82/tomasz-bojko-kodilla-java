package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testAddTask() {
//        When
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring.portfolio");
        Board board = context.getBean(Board.class);
//        Given
            board.getToDoList().addTask("Learn Spring Boot.");
            board.getInProgressList().addTask("Finish Kodilla course - 'Java Developer'.");
            board.getDoneList().addTask("Learn lambda expression and stream.");
            board.getDoneList().addTask("Learn Java collections.");
//        Then
        assertEquals(board.getToDoList().getTasks().size(), 1);
        assertEquals(board.getInProgressList().getTasks().size(), 1);
        assertEquals(board.getDoneList().getTasks().size(), 2);
        assertEquals(board.getToDoList().getTasks().get(0), "Learn Spring Boot.");
        assertEquals(board.getInProgressList().getTasks().get(0), "Finish Kodilla course - 'Java Developer'.");
        assertEquals(board.getDoneList().getTasks().get(1), "Learn Java collections.");

    }

}
