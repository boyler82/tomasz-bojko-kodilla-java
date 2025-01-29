package com.kodilla.sudoku;
import java.util.List;

import java.util.ArrayList;

public class SudokuRow {
    private final List<SudokuElement> elements;
    private final int maxValue;

    public SudokuRow(SudokuSize size) {
        elements = new ArrayList<>();
        this.maxValue = size.getSize();
        for (int i = 0; i < maxValue; i++) {
            elements.add(new SudokuElement(size));
        }
    }

    public List<SudokuElement> getElements() {
        return elements;
    }

    public int getMaxValue() {
        return maxValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int blockSize = (int) Math.sqrt(elements.size());

        for (int i = 0; i < elements.size(); i++) {
            sb.append(elements.get(i).toString()).append(" ");

            if ((i + 1) % blockSize == 0 && (i + 1) < elements.size()) {
                sb.append("| ");
            }
        }
        return sb.toString();
    }
}
