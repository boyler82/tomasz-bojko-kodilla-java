package com.kodilla.game;

public class App {
    public static void main(String[] args) {
        Game game = new Game();
        UserController userController = new UserController();
        char input = userController.firstInputForPlayer();
        game.initializePlayers(input);
        Board board = game.getBoard();
        Player curretnPlayer = game.getCurrentPlayer();
        game.initializePlayers(curretnPlayer.getPlayerMark());
        while (!board.isFull()) {
            board.printBoard();
            int position = userController.userInputPosition();

            if (board.isPositionValid(position)) {
                game.handlePlayerMove(position);

            }
            if (board.checkWin()){
                break;
            }else {
                game.switchPlayer();
            }
        }
        game.endGame();
    }

}