package com.kodilla.hiber.taskList;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "TASK_LIST")
public class TaskList {
    private int id;
    private String listName;
    private String description;

    public TaskList(String listName, String description) {
        this.description = description;
        this.listName = listName;
    }

    public TaskList() {
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }
    @Column(name = "LIST_NAME")
    public String getListName() {
        return listName;
    }
}
