package com.kodilla.sudoku_ver2;

import java.util.Objects;

public class theGame {
    private SudokuBoard sudokuBoard;

    public theGame(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        theGame theGame = (theGame) o;
        return Objects.equals(getSudokuBoard(), theGame.getSudokuBoard());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getSudokuBoard());
    }
}
