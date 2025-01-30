package com.kodilla.sudoku_ver2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SudokuTestSuite {

    private SudokuBoard testBoard;
    private SudokuValidator sudokuValidator;
    private SudokuSolver solver;

    @BeforeEach
    void setUp() {
        testBoard = new SudokuBoard(9);
        sudokuValidator = new SudokuValidator();
        solver = new SudokuSolver(sudokuValidator);


        testBoard.setValue(0, 0, 1);
        testBoard.setValue(0, 1, 5);
        System.out.println(testBoard.toString());
    }

    @Test
    void solveEmptyBoard() {
        // when
        boolean isSolved = solver.solve(testBoard);
        System.out.println(testBoard.toString());
        // then
        assertTrue(isSolved, "Solver powinien znaleźć rozwiązanie");
    }
}