package com.kodilla.testing.tictactoe;

import com.kodilla.game.Board;
import com.kodilla.game.Game;
import com.kodilla.game.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class GameTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Game");

    }
    @Nested
    class testInitializePlayers {
        @Test
        public void testInitializePlayersWithX() {
//        Given
            Game game = new Game();
            Player player1 = game.getPlayer1();
            Player player2 = game.getPlayer2();
//        When
            game.initializePlayers('X');
//        Then
            assertEquals("X", player1.getName());
            assertEquals('X', player1.getPlayerMark());
            assertEquals("O", player2.getName());
            assertEquals('O', player2.getPlayerMark());
        }


        @Test
        public void testInitializePlayersWithO() {
//        Given
            Game game = new Game();
            Player player1 = game.getPlayer1();
            Player player2 = game.getPlayer2();
//        When
            game.initializePlayers('O');
//        Then
            assertEquals("O", player1.getName());
            assertEquals('O', player1.getPlayerMark());
            assertEquals("X", player2.getName());
            assertEquals('X', player2.getPlayerMark());
        }

        @Test
        public void testInitializePlayersWithWrongSign() {
//        Given
            Game game = new Game();
            Player player1 = game.getPlayer1();
            Player player2 = game.getPlayer2();
//        When
            game.initializePlayers('2');
//        Then
            assertEquals("X", player1.getName());
            assertEquals('X', player1.getPlayerMark());
            assertEquals("O", player2.getName());
            assertEquals('O', player2.getPlayerMark());
        }
    }

    @Test
    public void testHandlePlayerMove() {
        Game game = new Game();
        Player player1 = game.getPlayer1();
        game.initializePlayers('X');
        game.setCurrentPlayer(player1);

        Board board = game.getBoard();
        int position = 4;

        game.handlePlayerMove(position);

        char[][] boardState = board.getBoard();
        assertEquals('X', boardState[1][1]);
    }

    @Test
    public void testSwitchPlayer() {
        Game game = new Game();
        game.initializePlayers('X');

        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();

        game.setCurrentPlayer(player1);
        game.switchPlayer();

        assertEquals(player2, game.getCurrentPlayer());

        game.switchPlayer();
        assertEquals(player1, game.getCurrentPlayer());
    }
    @Test
    public void testEndGameWithWin() {
        Game game = new Game();
        Board board = game.getBoard();
        game.initializePlayers('X');
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();

        game.setCurrentPlayer(player1);
        game.handlePlayerMove(0);
        game.switchPlayer();
        game.handlePlayerMove(1);
        game.switchPlayer();
        game.handlePlayerMove(2);
        game.switchPlayer();
        game.handlePlayerMove(3);
        game.switchPlayer();
        game.handlePlayerMove(4);
        game.switchPlayer();
        game.handlePlayerMove(5);
        game.switchPlayer();
        game.handlePlayerMove(6);


        game.endGame();

        assertTrue(board.checkWin(),"Confirmed winner");
        assertFalse(board.isFull(),"Board is not full");
        assertTrue(game.getCurrentPlayer()==player1,"X is a winner");
        assertFalse(game.getCurrentPlayer()==player2);

    }

    @Test
    public void testEndGameWithDraw() {
        Game game = new Game();
        Board board = game.getBoard();
        game.initializePlayers('X');
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();

        game.setCurrentPlayer(player1);
        game.handlePlayerMove(0);
        game.switchPlayer();
        game.handlePlayerMove(1);
        game.switchPlayer();
        game.handlePlayerMove(2);
        game.switchPlayer();
        game.handlePlayerMove(3);
        game.switchPlayer();
        game.handlePlayerMove(4);
        game.switchPlayer();
        game.handlePlayerMove(6);
        game.switchPlayer();
        game.handlePlayerMove(5);
        game.switchPlayer();
        game.handlePlayerMove(8);
        game.switchPlayer();
        game.handlePlayerMove(7);


        game.endGame();

        assertFalse(board.checkWin(),"NOT Confirmed winner");
        assertTrue(board.isFull(),"Board is full");
        assertTrue(game.getCurrentPlayer()==player1);
        assertFalse(game.getCurrentPlayer()==player2);
    }
}
