package com.kodilla.sudokuVer2;

public class SudokuSolver {
    private SudokuSolverStrategy strategy;

    public SudokuSolver(SudokuSolverStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SudokuSolverStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean solve(SudokuBoard board) {
        return strategy.solve(board);
    }
}
