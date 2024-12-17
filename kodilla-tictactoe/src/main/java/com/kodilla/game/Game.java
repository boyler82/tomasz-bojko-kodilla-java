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

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public UserController getUserInput() {
        return userInput;
    }

    public void setUserInput(UserController userInput) {
        this.userInput = userInput;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void initializePlayers(char playerSign) {
        System.out.println("Initializing players...");
        if (playerSign != 'X' && playerSign != 'O') {
            player1.setName("X");
            player1.setPlayerMark('X');
        } else {
            player1.setName(Character.toString(playerSign));
            player1.setPlayerMark(playerSign);
        }

        if (player1.getPlayerMark() == 'X') {
            player2.setName("O");
            player2.setPlayerMark('O');
        } else {
            player2.setName("X");
            player2.setPlayerMark('X');
        }
    }

    public void handlePlayerMove(int position) {
        while (true) {
            if (board.isPositionValid(position)) {
                board.setMarkOnBoard(currentPlayer, position);
                break;
            } else {
                System.out.println("Chose field that is not taken.");
            }
        }
    }


    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public void endGame() {
        board.printBoard();
        if (board.checkWin()) {
            System.out.println("Player '" + currentPlayer.getName() + "' wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
