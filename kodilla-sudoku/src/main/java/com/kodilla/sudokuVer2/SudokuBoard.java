package com.kodilla.sudokuVer2;

import java.util.*;

public class SudokuBoard {
    private final Field[][] sudokuBoard;
    private static final int SIZE = 9;
    private static final int BLOCK_SIZE = 3;

//    SudokuValidator validator = new SudokuValidator(); // Walidator planszy

    public SudokuBoard() {
        this.sudokuBoard = new Field[SIZE][SIZE];

        // Inicjalizacja pustych pól Sudoku
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                sudokuBoard[row][col] = new Field();
                int boxId = calculateBoxId(row, col);
                sudokuBoard[row][col].setBoxId(boxId);
            }
        }
    }

    // Pobranie pustej planszy Sudoku
    public Field[][] getEmptySudokuBoard() {
        return sudokuBoard;
    }

    // Generowanie poprawnej losowej planszy Sudoku
    public Field[][] getRandomSudokuBoard() {
        SudokuSolver1 solver = new SudokuSolver1();
        Random random = new Random();

        clearBoard(); // Resetujemy planszę przed nową próbą generacji

        int numbersToPlace = 12; // Tylko 10 losowych wartości
        int placedNumbers = 0;

        while (placedNumbers < numbersToPlace) {
            int row, col, value;

            do {
                row = random.nextInt(SIZE); // Losowy wiersz
                col = random.nextInt(SIZE); // Losowa kolumna
                value = random.nextInt(9) + 1; // Losowa liczba 1-9
            } while (sudokuBoard[row][col].getValue() != Field.EMPTY || !isValidPlacement(row, col, value));

            setFieldValue(row, col, value);
            placedNumbers++;
        }

        return sudokuBoard; // Zwracamy planszę z 10 losowymi wartościami
    }


    // Resetowanie planszy
    private void clearBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                sudokuBoard[row][col].resetAvailableNumbers();
            }
        }
    }

    // Sprawdzenie poprawności wstawienia wartości (brak kolizji)
    private boolean isValidPlacement(int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (sudokuBoard[row][i].getValue() == num ||
                    sudokuBoard[i][col].getValue() == num) {
                return false;
            }
        }

        int boxStartRow = (row / 3) * 3;
        int boxStartCol = (col / 3) * 3;
        for (int r = boxStartRow; r < boxStartRow + 3; r++) {
            for (int c = boxStartCol; c < boxStartCol + 3; c++) {
                if (sudokuBoard[r][c].getValue() == num) {
                    return false;
                }
            }
        }
        return true;
    }

    // Pobieranie rozmiaru planszy
    public int getSIZE() {
        return SIZE;
    }

    // Obliczanie ID boxa na podstawie wiersza i kolumny
    private int calculateBoxId(int row, int col) {
        int boxRow = row / 3;
        int boxCol = col / 3;
        return boxRow * 3 + boxCol + 1;
    }

    // Pobranie całej planszy
    public Field[][] getBoard() {
        return sudokuBoard;
    }

    // Pobranie konkretnego pola
    public Field getField(int row, int col) {
        return sudokuBoard[row][col];
    }

    // Ustawienie wartości w polu Sudoku
    public void setFieldValue(int row, int col, int value) {
        sudokuBoard[row][col].setValue(value);
    }




    // Wyświetlenie planszy Sudoku
    public void printBoard() {
        System.out.println("╔═══════╦═══════╦═══════╗");
        for (int row = 0; row < SIZE; row++) {
            System.out.print("║ ");
            for (int col = 0; col < SIZE; col++) {
                int value = sudokuBoard[row][col].getValue();
                System.out.print((value == Field.EMPTY ? "." : value) + " ");
                if ((col + 1) % 3 == 0) {
                    System.out.print("║ ");
                }
            }
            System.out.println();
            if ((row + 1) % 3 == 0 && row != SIZE - 1) {
                System.out.println("╠═══════╬═══════╬═══════╣");
            }
        }
        System.out.println("╚═══════╩═══════╩═══════╝");
    }

    // Wyświetlenie dostępnych liczb dla każdego pola (debugowanie)
    public void printAvailableNumbers() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(sudokuBoard[row][col].getAvailableNumbers() + "-");
            }
            System.out.println();
        }
    }

//    --------------------------------------------------

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
