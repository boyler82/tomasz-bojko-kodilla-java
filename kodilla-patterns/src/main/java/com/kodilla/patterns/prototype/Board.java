package com.kodilla.patterns.prototype;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Board extends Prototype<Board> {
    private String name;
    private final Set<TasksList> lists = new HashSet<>();

    public Board(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public Set<TasksList> getLists() {
        return lists;
    }


    public Board shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Board{" +
                "lists=" + lists +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(getName(), board.getName()) && Objects.equals(getLists(), board.getLists());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLists());
    }
}
