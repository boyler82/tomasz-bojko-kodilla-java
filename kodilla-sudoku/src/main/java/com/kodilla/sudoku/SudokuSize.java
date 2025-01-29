package com.kodilla.sudoku;

public enum SudokuSize {
    SMALL(6, 2),   // Plansza 6x6, 2 bloki w wierszu/kolumnie (2x3)
    MEDIUM(9, 3),  // Plansza 9x9, 3 bloki w wierszu/kolumnie (3x3)
    LARGE(12, 4);  // Plansza 12x12, 4 bloki w wierszu/kolumnie (3x4 lub 4x3)

    private final int size;
    private final int blockQuantity;

    SudokuSize(int size, int blockQuantity) {
        this.size = size;
        this.blockQuantity = blockQuantity;
    }

    public int getSize() {
        return size;
    }

    public int getBlockQuantity() {
        return blockQuantity;
    }

    public static SudokuSize fromInt(int size) {
        for (SudokuSize s : values()) {
            if (s.getSize() == size) {
                return s;
            }
        }
        throw new IllegalArgumentException("Nieprawidłowy rozmiar planszy: " + size);
    }
}
