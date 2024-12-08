package com.kodilla.game;

import java.util.Scanner;

public class UserController {
    private char userInput;

    public UserController(char userInput) {
        this.userInput = userInput;
    }

    public UserController() {
    }

    public char getUserInput() {
        return userInput;
    }

    public void setUserInput(char userInput) {
        this.userInput = userInput;
    }

    public char firstInputForPlayer() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a character (e.g., X, O): ");
            String input = scanner.nextLine();

            if (input.length() == 1) {
                userInput = input.charAt(0);
                break;
            } else {
                System.out.println("Invalid input. Please enter a single character.");
            }
        }
        return userInput;
    }



    public int userInputPosition() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter a position (1-9): ");
                int position = Integer.parseInt(scanner.nextLine());

                if (position >= 1 && position <= 9) {
                    return position - 1;
                } else {
                    System.out.println("Invalid position. Please enter a number between 1 and 9.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }


}
