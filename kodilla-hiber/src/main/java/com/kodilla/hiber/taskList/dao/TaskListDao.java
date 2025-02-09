package com.kodilla.hiber.taskList.dao;


import com.kodilla.hiber.taskList.TaskList;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface TaskListDao extends CrudRepository<TaskList, Integer> {


    List<TaskList> findByListName(String listName);

}
