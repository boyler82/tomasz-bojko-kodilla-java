package com.kodilla.rpsGamev2;

public class Player {

    private String name;
    private HandSign move;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HandSign getMove() {
        return move;
    }

    public void setMove(HandSign move) {
        this.move = move;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }



}
