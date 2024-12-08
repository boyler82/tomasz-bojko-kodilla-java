package com.kodilla.game;

public class Board {
    private int boardSize;
    private char[][] board;
    private Player player1;
    private Player player2;


    public int getBoardSize() {
        return boardSize;
    }

    public Board(int boardSize) {
        board = new char[boardSize][boardSize];
        this.boardSize = boardSize;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = '_';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public void printBoard() {
        for (int i = 0; i < boardSize; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    public void setPlayer(Player player) {
        if (player1 == null) {
            player1 = player;
        } else {
            player2 = player;
        }
    }

    public boolean isFull() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    public void setMarkOnBoard(Player player, int position) {
        if (position < 0 || position >= boardSize * boardSize) {
            throw new IndexOutOfBoundsException("Position out off board size.");
        }

        int row = position / boardSize;
        int col = position % boardSize;


            if (board[row][col] == '_') {
                board[row][col] = player.getPlayerMark();

            } else {
                System.out.println("Chose another field.");
            }

    }

    public boolean checkWin() {
        for (int i = 0; i < boardSize; i++) {
            if (board[i][0] != '_' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }

        for (int i = 0; i < boardSize; i++) {
            if (board[0][i] != '_' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }

        if (board[0][0] != '_' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '_' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    public boolean isPositionValid(int position) {
        if (position < 0 || position >= boardSize * boardSize) {
            return false;
        }
        int row = position / boardSize;
        int col = position % boardSize;
        return board[row][col] == '_';
    }




}
