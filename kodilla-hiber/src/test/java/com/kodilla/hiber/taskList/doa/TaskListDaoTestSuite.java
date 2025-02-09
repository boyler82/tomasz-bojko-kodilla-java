package com.kodilla.hiber.taskList.doa;

import com.kodilla.hiber.taskList.TaskList;
import com.kodilla.hiber.taskList.dao.TaskListDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private final String listName = "ToDo";
    private final String description = "Finish module 16.1";
    private final String description2 = "Finish module 16.2";

    private final String listNameDone = "Done";
    private final String descriptionDone = "Finish module 1 on kodilla-course";

    @BeforeEach
    void setup() {
        taskListDao.deleteAll();
    }

    @AfterEach
    void cleanup() {
        taskListDao.deleteAll();
    }

    @Test
    void testFIndByListName() {
//        given
        TaskList taskList = new TaskList(listName, description);
        TaskList taskList2 = new TaskList(listName, description2);
        TaskList taskListDone = new TaskList(listNameDone,descriptionDone);
//        when
        taskListDao.save(taskList);
        taskListDao.save(taskList2);
        taskListDao.save(taskListDone);
        List<TaskList> findListNameToDo = taskListDao.findByListName(listName);
        List<TaskList> findListNameDone = taskListDao.findByListName(listNameDone);

//        then
        assertEquals(2, findListNameToDo.size());
        assertEquals(1, findListNameDone.size());
    }
}
