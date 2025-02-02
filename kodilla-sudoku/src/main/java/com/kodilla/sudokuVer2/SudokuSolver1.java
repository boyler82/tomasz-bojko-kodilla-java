package com.kodilla.sudokuVer2;

import java.util.*;

public class SudokuSolver1 implements SudokuSolverStrategy {

    private SudokuBoard board;

    public SudokuSolver1() {
        this.board = board;
    }

    @Override
    public boolean solve(SudokuBoard board) {
        int size = board.getSIZE();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board.getField(row, col).getValue() == Field.EMPTY) { // Szukamy pustej komórki

                    board.updateAvailableNumbersForField(board, board.getField(row, col));

                    HashSet<Integer> availableNumbers = board.getField(row, col).getAvailableNumbers();

                    if (availableNumbers.isEmpty()) {
                        return false;
                    }

                    for (int num : availableNumbers) {
                        board.setFieldValue(row, col, num);

                        if (board.validateBoardForDuplicate(board, board.getField(row, col))) {
                            if (solve(board)) {
                                return true; // Jeśli udało się rozwiązać, kończymy
                            }
                        }

                        // Cofamy ruch
                        board.setFieldValue(row, col, Field.EMPTY);
                        board.getField(row, col).resetAvailableNumbers();
                    }
                    return false; // Jeśli żadna liczba nie pasuje, wracamy do poprzedniego kroku
                }
            }
        }
        return true; // Jeśli nie znaleziono pustych pól, Sudoku jest rozwiązane!
    }
}