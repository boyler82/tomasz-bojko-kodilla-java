package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskFactoryTestSuite {

    @Test
    void testDrivingTask() {
//        Given
        TaskFactory task = new TaskFactory();
//        When
        Task driveTask = task.addTask(TaskFactory.DRIVING);
        driveTask.executeTask();
//        Then
        assertEquals(driveTask.getTaskName(), "Main St.");
        assertTrue(driveTask.isTaskDone());
    }

    @Test
    void testPaintingTask() {
//        Given
        TaskFactory task = new TaskFactory();
//        When
        Task paintingTask = task.addTask(TaskFactory.PAINTING);
        paintingTask.executeTask();
//        Then
        assertEquals(paintingTask.getTaskName(), "renovation");
        assertTrue(paintingTask.isTaskDone());
    }

    @Test
    void testShoppingTask() {
//        Given
        TaskFactory task = new TaskFactory();
//        When
        Task shoppingTask = task.addTask(TaskFactory.SHOPPING);
        shoppingTask.executeTask();
//        Then
        assertEquals("Food shopping list",shoppingTask.getTaskName());
        assertTrue(shoppingTask.isTaskDone());
    }



}
