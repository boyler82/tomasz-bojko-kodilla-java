package com.kodilla.game;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private UserController userInput;

    public Game() {
        board = new Board(3);
        player1 = new Player();
        player2 = new Player();
        currentPlayer = player1;
        userInput = new UserController();
    }

    public void startGame() {
        initializePlayers();

        while (!board.checkWin() && !board.isFull()) {
            board.printBoard();
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getPlayerMark() + ")");
            handlePlayerMove();
            switchPlayer();
        }

        endGame();
    }

    private void initializePlayers() {
        System.out.println("Initializing players...");
        char symbol1 = Character.toUpperCase(userInput.firstInputForPlayer());
        player1.setName(Character.toString(symbol1));
        player1.setPlayerMark(symbol1);

        if (player1.getPlayerMark() == 'X') {
            player2.setName("O");
            player2.setPlayerMark('O');
        } else {
            player2.setName("X");
            player2.setPlayerMark('X');
        }
    }

    private void handlePlayerMove() {
        while (true) {
            int position = userInput.userInputPosition();
            if (board.isPositionValid(position)) {
                board.setMarkOnBoard(currentPlayer, position);
                break;
            } else {
                System.out.println("Chose field that is not taken.");
            }
        }
    }


    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private void endGame() {
        board.printBoard();
        if (board.checkWin()) {
            System.out.println(currentPlayer.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
