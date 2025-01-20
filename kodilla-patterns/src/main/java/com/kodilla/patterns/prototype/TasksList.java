package com.kodilla.patterns.prototype;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class TasksList {
    private final String name;
    private final List<Task> tasks = new ArrayList<>();

    public TasksList(final String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TasksList{" +
                "name='" + name + '\'' +
                ", tasks=" + tasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TasksList tasksList = (TasksList) o;
        return Objects.equals(getName(), tasksList.getName()) && Objects.equals(getTasks(), tasksList.getTasks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getTasks());
    }
}





