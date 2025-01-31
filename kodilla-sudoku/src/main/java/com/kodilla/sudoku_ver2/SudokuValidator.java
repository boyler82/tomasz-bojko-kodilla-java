package com.kodilla.sudoku_ver2;

import java.util.*;

public class SudokuValidator {

    private static final int SIZE = 9; // Sudoku 9x9
    private static final int BLOCK_SIZE = 3; // Bloki 3x3

    public boolean validateBoardForDuplicate(SudokuBoard board, Field field) {
        int row = -1, col = -1;

        // Szukamy współrzędnych pola w tablicy Sudoku
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (board.getField(r, c) == field) {
                    row = r;
                    col = c;
                    break;
                }
            }
        }

        // Jeśli nie znaleziono, zwracamy fałsz (nie powinno się zdarzyć)
        if (row == -1 || col == -1) {
            return false;
        }

        return noDuplicatesInRow(board, row) &&
                noDuplicatesInColumn(board, col) &&
                validateBoxes(board);
    }

    private boolean validateBoxes(SudokuBoard board) {
        Map<Integer, List<Field>> boxMap = new HashMap<>();

        // Grupujemy pola według `boxId`
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                Field field = board.getField(row, col);
                int boxId = field.getBoxId();
                boxMap.putIfAbsent(boxId, new ArrayList<>());
                boxMap.get(boxId).add(field);
            }
        }

        // Sprawdzamy każdy box 3x3
        for (int boxId = 1; boxId <= 9; boxId++) {
            Set<Integer> seen = new HashSet<>();
            for (Field field : boxMap.getOrDefault(boxId, Collections.emptyList())) {
                int value = field.getValue();
                if (value != Field.EMPTY) {
                    if (!seen.add(value)) return false; // Powtórzenie w boxie 3x3
                }
            }
        }

        return true;
    }

//    ----------------------
private boolean noDuplicatesInCollection(SudokuBoard board, boolean isRowCheck, int index) {
    Set<Integer> numbers = new HashSet<>();

    for (int i = 0; i < SIZE; i++) {
        int value = isRowCheck ? board.getField(index, i).getValue() : board.getField(i, index).getValue();

        if (value != Field.EMPTY) {
            if (!numbers.add(value)) {
                return false; // Powtórzenie w kolekcji (wierszu lub kolumnie)
            }
        }
    }
    return true;
}

    private boolean noDuplicatesInRow(SudokuBoard board, int row) {
        return noDuplicatesInCollection(board, true, row);
    }

    private boolean noDuplicatesInColumn(SudokuBoard board, int col) {
        return noDuplicatesInCollection(board, false, col);
    }



    public void updateAvailableNumbersForField(SudokuBoard board, Field field) {
        int updatedBoxId = field.getBoxId();
        int updatedBoxRow = (updatedBoxId - 1) / BLOCK_SIZE;
        int updatedBoxCol = (updatedBoxId - 1) % BLOCK_SIZE;
        int updateFieldValue = field.getValue();
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board.getField(row, col).getValue() == Field.EMPTY
                && updatedBoxId == board.getField(row, col).getBoxId()) {
                    board.getField(row, col).removeAvailableNumber(updateFieldValue);
                } else if (board.getField(row, col).getValue() == Field.EMPTY
                        && row == updatedBoxRow) {
                    board.getField(row, col).removeAvailableNumber(updateFieldValue);
                } else if (board.getField(row, col).getValue() == Field.EMPTY
                        && col == updatedBoxCol) {
                    board.getField(row, col).removeAvailableNumber(updateFieldValue);
                }
            }
        }
    }
}