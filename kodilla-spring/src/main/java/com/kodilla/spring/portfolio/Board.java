package com.kodilla.spring.portfolio;

public class Board {
   private TaskList toDoList;
   private TaskList inProgressList;
   private TaskList doneList;

    public Board(TaskList doneList, TaskList inProgressList, TaskList toDoList) {
        this.doneList = doneList;
        this.inProgressList = inProgressList;
        this.toDoList = toDoList;
    }

    public TaskList getDoneList() {
        return doneList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getToDoList() {
        return toDoList;
    }
}
