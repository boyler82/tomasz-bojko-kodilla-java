package com.kodilla.sudokuVer2;

import java.util.HashSet;

public class Field {
    public static final int EMPTY = -1;
    private int value;
    private int boxId;
    private HashSet<Integer> availableNumbers;

    public Field() {
        this.value = EMPTY;
        this.boxId = EMPTY;
        this.availableNumbers = new HashSet<>();

        // Inicjalizacja dostępnych liczb 1-9
        for (int i = 1; i <= 9; i++) {
            availableNumbers.add(i);
        }
    }

    public HashSet<Integer> getAvailableNumbers() {
        return new HashSet<>(availableNumbers); // Unikamy modyfikacji wewnętrznego Setu
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value != EMPTY) {
            availableNumbers.clear(); // Jeśli ustawiamy wartość, usuwamy możliwe liczby
        }
        this.value = value;
    }

    public void removeAvailableNumber(int number) {
        availableNumbers.remove(number);
    }

    public void resetAvailableNumbers() {
        value = EMPTY;
        availableNumbers.clear();
        for (int i = 1; i <= 9; i++) {
            availableNumbers.add(i);
        }
    }

    public int getBoxId() {
        return boxId;
    }

    public void setBoxId(int boxId) {
        this.boxId = boxId;
    }

    public void setAvailableNumbers(HashSet<Integer> availableNumbers) {
        this.availableNumbers = availableNumbers;
    }

    @Override
    public String toString() {
        return "Field{" +
                "availableNumbers=" + availableNumbers +
                ", value=" + value +
                ", boxId=" + boxId +
                '}';
    }
}
