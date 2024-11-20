package com.kodilla.rpsGamev2;

import java.util.Scanner;

public class Game {
//    gra ma metode play i graczy i wynik/winiki
    private Player user;
    private Computer computer;
    private int numberOfRounds;

    public Game() {
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public Game(Computer computer, Player user) {
        this.computer = computer;
        this.user = user;
    }

    public Player getUser() {
        return user;
    }

    public Computer getComputer() {
        return computer;
    }

    public void start() {
        System.out.println("Game started");
//
        System.out.println("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        this.user = new Player(name);

        System.out.println("Enter number of rounds: ");
        this.numberOfRounds = scanner.nextInt();

        this.computer = new Computer();
    }
    public void playGame() {
            computer.setMove(computer.getRandomSign());

            if (user.getMove() == computer.getMove()) {
            } else if ((user.getMove() == HandSign.ROCK && computer.getMove() == HandSign.SCISSORS) ||
                    (user.getMove() == HandSign.PAPER && computer.getMove() == HandSign.ROCK) ||
                    (user.getMove() == HandSign.SCISSORS && computer.getMove() == HandSign.PAPER)) {
                user.setScore(user.getScore() + 1);
            } else {
                computer.setScore(computer.getScore() + 1);
            }
    }



    public void showPlayers() {
        System.out.println("Starting new game. Number of rounds: " + numberOfRounds);
        System.out.println("Player 1: " + user.getName());
        System.out.println("Player 2: " + computer.toString());
    }

    public boolean exit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you sure you want to quit? Press y/n");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("y");
    }

    public String menu(int round) {
        if (round > getNumberOfRounds()) {
            System.out.println("Final Score: " + getUser().getName() + " " + getUser().getScore() + " - Computer " + getComputer().getScore());
            System.out.println("\n=== Game Over ===\n");
            setNumberOfRounds(1);
            return "n";
        } else {
            System.out.println("ROUND " + round);
        }
        System.out.println("Menu");
        System.out.println("1 - Play \"stone\"");
        System.out.println("2 - Play \"paper\"");
        System.out.println("3 - Play \"scissors\"");
        System.out.println("x - Exit");
        System.out.println("n - New game");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();


        switch (choice) {
            case "1":
                user.setMove(HandSign.ROCK);
                playGame();
                break;
            case "2":
                user.setMove(HandSign.PAPER);
                playGame();
                break;
            case "3":
                user.setMove(HandSign.SCISSORS);
                playGame();
                break;
            case "x":
                return "x";
            case "n":
                return "n";
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

        return null;
    }


}
