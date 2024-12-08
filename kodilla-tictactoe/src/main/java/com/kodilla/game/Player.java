package com.kodilla.game;

public class Player {
    private String name;
    private char playerMark;

    public Player() {
    }

    public Player(String name, char playerMark) {
        this.name = name;
        this.playerMark = playerMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getPlayerMark() {
        return playerMark;
    }

    public void setPlayerMark(char playerMark) {
        this.playerMark = playerMark;
    }

}
