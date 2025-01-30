package com.kodilla.sudoku_ver2;

import java.util.*;

public class SudokuSolver {
    private SudokuValidator sudokuValidator = new SudokuValidator();

    public SudokuSolver(SudokuValidator sudokuValidator) {
        this.sudokuValidator = sudokuValidator;
    }

    public SudokuValidator getSudokuValidator() {
        return sudokuValidator;
    }

    public void setSudokuValidator(SudokuValidator sudokuValidator) {
        this.sudokuValidator = sudokuValidator;
    }

        public boolean solve(SudokuBoard board) {
            int size = board.getSize();

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    if (board.getValue(row, col) == -1) {
                        List<Integer> availableNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
                        Collections.shuffle(availableNumbers);

                        for (int num : availableNumbers) {
                            board.setValue(row, col, num);

                            if (sudokuValidator.isValueValid(board)) {
                                if (solve(board)) {
                                    return true;
                                }
                            }
                            board.setValue(row, col, -1);
                        }
                        return false;
                    }
                }
            }
            return true;
        }

}