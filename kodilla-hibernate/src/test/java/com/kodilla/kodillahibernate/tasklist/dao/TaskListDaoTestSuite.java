package com.kodilla.kodillahibernate.tasklist.dao;

import com.kodilla.kodillahibernate.taskList.TaskList;
import com.kodilla.kodillahibernate.taskList.dao.TaskListDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private static final String LISTNAME = "To Do List";
    private static final String DESCRIPTION = "Clean the house";

    @Test
    void testFindListName() {
//        Given
        TaskList taskList = new TaskList(DESCRIPTION, LISTNAME);
        taskListDao.save(taskList);
        String listName = taskList.getListName();
//        When
        List<TaskList> readListName = taskListDao.findByListName(listName);
//        Then
        assertEquals(1,readListName.size());
        //CleanUp
        int id = readListName.get(0).getId();
        taskListDao.deleteById(id);
    }



}
