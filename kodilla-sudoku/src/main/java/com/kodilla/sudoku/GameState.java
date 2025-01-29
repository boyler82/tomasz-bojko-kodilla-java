package com.kodilla.sudoku;

public enum GameState {
    INSTANCE;

    private boolean isGameOver;

    public void endGame() {
        isGameOver = true;
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}