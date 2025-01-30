package com.kodilla.sudoku_ver2;

import java.util.Set;

public class SudokuBoard {
    private final int[][] sudokuBoard;
    private final int  size;


    public SudokuBoard(int size) {
        this.size = size;
        this.sudokuBoard = new int[size][size];
        for (int row = 0; row < size ;row++) {
            for (int col = 0; col < size ; col++) {
                sudokuBoard[row][col] = -1;
            }
        }
    }

    public int[][] getSudokuBoard() {
        return sudokuBoard;
    }

    public int getSize() {
        return size;
    }
    public int getValue(int row, int col) {
        return sudokuBoard[row][col];
    }
    public void setValue(int row, int col, int value) {
        sudokuBoard[row][col] = value;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                sb.append(sudokuBoard[row][col] == -1 ? ". " : sudokuBoard[row][col] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
