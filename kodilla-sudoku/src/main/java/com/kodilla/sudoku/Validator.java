package com.kodilla.sudoku;

public class Validator {

    public static boolean isValueInRange(int value, int maxValue) {
        return value >= 1 && value <= maxValue;
    }


    public static boolean containsValue(SudokuRow row, int value) {
        return row.getElements().stream().anyMatch(e -> e.getValue() == value);
    }


    public static boolean setValue(SudokuRow row, int index, int value) {
        if (!isValueInRange(value, row.getMaxValue())) {
            System.out.println("BŁĄD: Wartość " + value + " jest poza zakresem (1-" + row.getMaxValue() + ").");
            return false;
        }
        if (containsValue(row, value)) {
            System.out.println("BŁĄD: Wartość " + value + " już istnieje w wierszu.");
            return false;
        }
        row.getElements().get(index).setValue(value);
        return true;
    }
}