package com.kodilla.sudoku_ver2;

import java.util.HashSet;
import java.util.Set;


public class SudokuValidator {

    private static final int SIZE = 9; // Sudoku 9x9
    private static final int BLOCK_SIZE = 3; // Bloki 3x3


    public boolean duplicateInRow(SudokuBoard board) {
        for (int row = 0; row < SIZE; row++) {
            if (hasDuplicateInArray(board, row, true)) {
                return true;
            }
        }
        return false;
    }


    public boolean duplicateInCol(SudokuBoard board) {
        for (int col = 0; col < SIZE; col++) {
            if (hasDuplicateInArray(board, col, false)) {
                return true;
            }
        }
        return false;
    }

    public boolean duplicateInBlock(SudokuBoard board) {
        for (int row = 0; row < SIZE; row += BLOCK_SIZE) {
            for (int col = 0; col < SIZE; col += BLOCK_SIZE) {
                Set<Integer> numbersInBlock = new HashSet<>();
                for (int i = 0; i < BLOCK_SIZE; i++) {
                    for (int j = 0; j < BLOCK_SIZE; j++) {
                        int value = board.getValue(row + i, col + j);
                        if (value != -1) {
                            if (numbersInBlock.contains(value)) {
                                return true;
                            }
                            numbersInBlock.add(value);
                        }
                    }
                }
            }
        }
        return false;
    }


    public boolean isValueValid(SudokuBoard board) {
        return !duplicateInRow(board) && !duplicateInCol(board) && !duplicateInBlock(board);
    }


    private boolean hasDuplicateInArray(SudokuBoard board, int index, boolean isRow) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < SIZE; i++) {
            int value = isRow ? board.getValue(index, i) : board.getValue(i, index);
            if (value != -1) {
                if (numbers.contains(value)) {
                    return true;
                }
                numbers.add(value);
            }
        }
        return false;
    }
}