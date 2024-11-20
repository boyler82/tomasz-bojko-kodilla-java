package com.kodilla;


import com.kodilla.rpsGamev2.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
        game.showPlayers();
        boolean running = true;
        int round = 0;

        while (running) {
            ++round;

            String choice = game.menu(round);
            if (choice == null) {
                continue;
            }

            switch (choice) {
                case "x":
                    if (game.exit()) {
                        running = false;
                        System.out.println("Goodbye!");
                    }
                    break;
                case "n":
                    game.start();
                    game.showPlayers();
                    round = 0;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    round--;
            }
        }
    }
}
