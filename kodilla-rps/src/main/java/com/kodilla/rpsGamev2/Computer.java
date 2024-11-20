package com.kodilla.rpsGamev2;

public class Computer {
    private int score;
    private HandSign move;


    public Computer() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public HandSign getMove() {
        return move;
    }

    public void setMove(HandSign move) {
        this.move = move;
    }

    public HandSign getRandomSign() {
        HandSign[] values = HandSign.values();
        int index = (int) (Math.random() * values.length);
        return values[index];
    }

    @Override
    public String toString() {
        return "Computer";
    }
}
