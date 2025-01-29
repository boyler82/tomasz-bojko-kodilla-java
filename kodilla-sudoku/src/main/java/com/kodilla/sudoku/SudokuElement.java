package com.kodilla.sudoku;


import java.util.HashSet;
import java.util.Set;

public class SudokuElement {
    public static final int EMPTY = -1;
    private int value;
    private Set<Integer> possibleValues;

    public SudokuElement(SudokuSize size) {
        this.value = EMPTY;
        this.possibleValues = new HashSet<>();
        for (int i = 1; i <= size.getSize(); i++) {
            possibleValues.add(i);
        }
    }

    public Set<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void removePossibleValues(int value) {
        possibleValues.remove(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        possibleValues.clear();
    }

    @Override
    public String toString() {
        return value == EMPTY ? "." : String.valueOf(value);
    }
}
