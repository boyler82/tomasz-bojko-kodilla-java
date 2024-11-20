package com.kodilla.rpsGamev2;


public enum HandSign {
    ROCK, PAPER, SCISSORS;

    public static HandSign getRandomSign() {
        HandSign[] values = HandSign.values();
        int index = (int) (Math.random() * values.length);
        return values[index];
    }
}
