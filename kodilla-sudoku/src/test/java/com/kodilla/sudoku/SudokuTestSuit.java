package com.kodilla.sudoku;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuTestSuit {
    private SudokuRow row;



    @Test
    void SudokuElementTestSuite() {
//        given
        SudokuElement sudokuElement = new SudokuElement(SudokuSize.MEDIUM);
//        when
        int isEmpty = sudokuElement.getValue();
        sudokuElement.setValue(2);
        int notEmpty = sudokuElement.getValue();
//        then
        assertTrue(sudokuElement.EMPTY==isEmpty);
        assertTrue(2==notEmpty);
        assertTrue(sudokuElement.getPossibleValues().isEmpty());
    }

    @BeforeEach
    void setUp() {
        row = new SudokuRow(SudokuSize.MEDIUM);
    }

    @Test
    void printTest() {
        System.out.println(row.toString());
    }
    @Test
    void createRowTest() {
        int size = row.getElements().size(); // sprawdzamy rozmiar,
        int e = SudokuElement.EMPTY; // sprawdzamy, czy pola są puste,

        assertTrue(size==9);
        for(SudokuElement elment : row.getElements()) {
            assertEquals(e, elment.getValue());
        }

    }

    @Test
    void testValueInRange() {
//        given
//        when
        boolean inRange = Validator.setValue(row,1,1);
//        then
        assertTrue(inRange);
    }

    @Test
    void testValueOutOfRange() {
        //        when
        boolean notInRange = Validator.setValue(row,1,0);
        boolean notInRange2 = Validator.setValue(row,1,10);
//        then
        assertFalse(notInRange);
        assertFalse(notInRange2);
    }
    @Test
    void testIndexOutOfInRange() {
//        given
//        when
        boolean indexIn = Validator.setValue(row,1,1);
        boolean indexOut = Validator.setValue(row,10,1);
//        then
        assertTrue(indexIn);
        assertFalse(indexOut);
    }
    @Test
    void testDuplicate() {
//        given
//        when
        Validator.setValue(row, 1, 7);
//        then
        assertFalse(Validator.setValue(row,5,7));
        assertEquals(SudokuElement.EMPTY, row.getElements().get(5).getValue());

    }
}
