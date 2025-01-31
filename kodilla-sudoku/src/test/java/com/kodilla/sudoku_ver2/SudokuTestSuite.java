package com.kodilla.sudoku_ver2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuTestSuite {

    private SudokuBoard testBoard;
    private SudokuValidator validator;
    private SudokuSolver solver;

    @BeforeEach
    void setUp() {
        testBoard = new SudokuBoard();
        validator = new SudokuValidator();
        solver = new SudokuSolver(validator);
    }

    @Nested
    @DisplayName("Zestaw testów do metody SudokuBoard")
    class SudokuBoardTestSuite {

        @Test
        @DisplayName("Dodawanie liczb do pustego sudoku")
        void addValueToEmptyBoardTest() {
    //        when
    //        given
            testBoard.setFieldValue(1,1,1);
            testBoard.setFieldValue(2,2,2);
            testBoard.setFieldValue(2,3,2);
    //        then
            assertEquals(1,testBoard.getField(1,1).getValue());
            assertEquals(2,testBoard.getField(2,2).getValue());
            assertEquals(2,testBoard.getField(2,3).getValue());

        }

        @Test
        @DisplayName("Dodawanie liczby poza zakresem sudoku")
        void addValueOutOfRangeTest() {
    //        when
    //        given
    //        then
            assertThrows(IndexOutOfBoundsException.class, () -> testBoard.setFieldValue(-1,0,1));
            assertThrows(IndexOutOfBoundsException.class, () -> testBoard.setFieldValue(2,9,2));
        }

        @Test
        @DisplayName("Dodawanie tej samej liczby w tym samym rzędzie, kolumnie lub polu 3x3")
        void addSameValueTest() {
    //        when
    //        given
            testBoard.setFieldValue(0,0,1);
            testBoard.setFieldValue(0,1,1);
            testBoard.setFieldValue(1,0,1);
            testBoard.setFieldValue(1,1,1);
            Field firstRowValue1 = testBoard.getField(0,0);
            Field firstRowValue2 = testBoard.getField(0,1);
            Field firstRowValue3 = testBoard.getField(1,0);
            Field firstRowValue4 = testBoard.getField(1,1);
    //        then
            assertEquals(1,testBoard.getField(0,0).getValue());
            assertEquals(1,testBoard.getField(0,1).getValue());
            assertEquals(1,testBoard.getField(1,0).getValue());
            assertEquals(1,testBoard.getField(1,1).getValue());
            assertFalse(validator.validateBoardForDuplicate(testBoard,firstRowValue1));
            assertFalse(validator.validateBoardForDuplicate(testBoard,firstRowValue2));
            assertFalse(validator.validateBoardForDuplicate(testBoard,firstRowValue3));
            assertFalse(validator.validateBoardForDuplicate(testBoard,firstRowValue4));
        }

        @Test
        @DisplayName("Dodawanie liczby do zajętego juz pola")
        void addValueIfFieldNotEmpty() {
    //        when
    //        given
            testBoard.setFieldValue(5,5,1);
    //        then
        }

    }



    @Nested
    @DisplayName("Zestaw testów do metody validator.solveBoard")
    class SolverTestSuite {

        @Test
        @DisplayName("Rozwiazanie pustego sudoku")
        void solveEmptyBoard() {
            // when
            testBoard.printBoard();
            boolean isSolved = solver.solve(testBoard);
            testBoard.printBoard();
            // then
            assertTrue(isSolved, "Solver powinien znaleźć rozwiązanie"); //mam tu folse czemu solver nie rozwiazuje sudoku?
        }

        @Test
        @DisplayName("Rozwiazanie sudoku ze zmiennymi")
        void solveFieldBoard() {
//              when
            testBoard.setFieldValue(0,0,4);
            testBoard.setFieldValue(2,4,7);
            testBoard.setFieldValue(3,1,9);
            testBoard.setFieldValue(5,5,3);
            testBoard.setFieldValue(6,7,2);
            testBoard.setFieldValue(7,0,5);
            testBoard.setFieldValue(8,4,8);
//              given

            boolean isSolved = solver.solve(testBoard);

            // then
            assertTrue(isSolved, "Solver powinien znaleźć rozwiązanie"); //mam tu folse czemu solver nie rozwiazuje sudoku?
        }

    }
    @Nested
    @DisplayName("Testy ogólne")
    class GeneralTestSuite {

        @Test
        @DisplayName("Tworzenie pustego sudoku")
        void createEmptySudokuTest() {
//              when
            SudokuBoard emptyBoard = new SudokuBoard();
//            given
            Random random = new Random();
            int size = emptyBoard.getSIZE();
            int row = random.nextInt(9);
            int col = random.nextInt(9);
            int value = emptyBoard.getField(row,col).getValue();
//              then
            assertEquals(9, size, "Pusty sudoku powinien mieć rozmiar 9x9");
            assertEquals(-1, value, "Puste pole powinno mieć wartość -1");
        }
    }
    @Nested
    @DisplayName("Testy dla wprowadzenia danych przez użytkownika")
    class UserInputTestSuite {
        @DisplayName("Dodawanie liczby o zlej wartości")
        @Test
        void testTest() {
        }
    }

//    @Nested
//    @DisplayName("Testy dla gry sudoku")
//    class gameTestSuite {
//        SudokuBoard board = new SudokuBoard();
//        TheGame game = new TheGame(board);
//        @DisplayName("")
//        @Test
//        void testTest() {
//
//
//        }
//    }

//    Sprawdzanie imputy użytkownika dla zajetego pola
//    Sprawdzanie imputu dla wolnego pola
//    Sprawdzanie imputu poza zakresem sudoku (-1,11,1)
//    Sprawdzanie imputu o zlej wartoci (10,-1,0,99)
//    Sprawdzanie imputu o wartoci niezgodnie z zasadami sudoku
}