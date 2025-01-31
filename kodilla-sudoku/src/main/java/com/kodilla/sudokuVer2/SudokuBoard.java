package com.kodilla.sudokuVer2;

import java.util.Random;

public class SudokuBoard {
    private final Field[][] sudokuBoard;
    private static final int SIZE = 9;

    SudokuValidator validator = new SudokuValidator(); // Walidator planszy

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
        SudokuSolver solver = new SudokuSolver(validator);
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
}
