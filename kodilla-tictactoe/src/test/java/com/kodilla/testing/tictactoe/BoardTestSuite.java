package com.kodilla.testing.tictactoe;

import com.kodilla.game.Board;
import com.kodilla.game.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTestSuite {

    @DisplayName("Board Test Suite")
    @Test
    void testCreateBoard() {
//        Given
        int boardSize = 3;
//        When
        Board board = new Board(boardSize);
//        Then
        assertEquals(boardSize,board.getBoardSize());
    }

    @Nested
    @DisplayName("Test Suite for isFull method.")
    class TestIsFull {
        @DisplayName("Empty Board")
        @Test
        void testIsFullForEmptyBoard(){
//        Given
            Board board = new Board(3);
//        When
            boolean result = board.isFull();
//        Then
            assertFalse(result);
        }

        @DisplayName("Full Board")
        @Test
        void testIsFullForFullBoard(){
//        Given
            Board board = new Board(3);
            char[][] fullBoard = {
                    {'X', 'O', 'X'},
                    {'O', 'X', 'O'},
                    {'X', 'O', 'X'}
            };
            board.setBoard(fullBoard);
//        When
        boolean result = board.isFull();
//        Then
            assertTrue(result);
        }

        @DisplayName("Partially full Board")
        @Test
        void testIsFullForPartFull() {
//        Given
            Board board = new Board(3);
            char[][] notFullBoard = {
                    {'X', '_', 'X'},
                    {'O', 'X', 'O'},
                    {'X', '_', 'X'}
            };
            board.setBoard(notFullBoard);
//        When
            boolean result = board.isFull();
//        Then
            assertFalse(result);
        }

    }
    @Nested
    @DisplayName("Test Suite for setting marks on board")
    class TestSetMarkOnBoard {

        @DisplayName("Setting mark on empty field in board")
        @Test
        void testSetMarkOnEmptyField() {
//        Given
            Board board = new Board(3);
            Player p1 = new Player("X", 'X');
//        When
            board.setMarkOnBoard(p1, 0);
//        Then
            char[][] testBoard = board.getBoard();
            assertEquals('X',testBoard[0][0]);
        }

        @DisplayName("Setting mark on taken field in board")
        @Test
        void testSetMarkOnTakenField() {
//        Given
            Board board = new Board(3);
            Player p1 = new Player("X", 'X');
            Player p2 = new Player("O",'O');
            board.setMarkOnBoard(p1,0);
//        When
            board.setMarkOnBoard(p2, 0);
            board.setMarkOnBoard(p2,8);
//        Then
            char[][] testBoard = board.getBoard();
            assertEquals('X',testBoard[0][0]);
            assertEquals('O',testBoard[2][2]);
        }

        @DisplayName("Setting mark on non existing field")
        @Test
        void testSetMarkOutOfTheBoard() {
//        Given
            Board board = new Board(3);
            Player p1 = new Player("X", 'X');

//        Then
            assertThrows(IndexOutOfBoundsException.class, () -> board.setMarkOnBoard(p1, 9));

        }
    }

    @Nested
    @DisplayName("Testing Win conditions")
    class TestCheckWin {
        private Board board;

        @BeforeEach
        void setup() {
            board = new Board(3);
        }


        @DisplayName("Player 'X win in row")
        @Test
        void testCheckWinForXInRow() {
//        Given
            char[][] boardArray = {
                    {'X', 'X', 'X'},
                    {'_', '_', '_'},
                    {'_', '_', '_'}
            };
            board.setBoard(boardArray);

//        When
            boolean result = board.checkWin();

//        Then
            assertTrue(result);
            }

        @DisplayName("Player 'X win in colum")
        @Test
        void testCheckWinForXInColumn() {
//        Given
            char[][] boardArray = {
                    {'X', '_', '_'},
                    {'X', '_', '_'},
                    {'X', '_', '_'}
            };
            board.setBoard(boardArray);

//        When
            boolean result = board.checkWin();

//        Then
            assertTrue(result);
        }

        @DisplayName("Player 'X' win diagonally")
        @Test
        void testCheckWinForXDiagonally() {
//        Given
            char[][] boardArray = {
                    {'X', '_', '_'},
                    {'_', 'X', '_'},
                    {'_', '_', 'X'}
            };
            board.setBoard(boardArray);

//        When
            boolean result = board.checkWin();

//        Then
            assertTrue(result);
        }

        @DisplayName("Player 'Y' win in row")
        @Test
        void testCheckWinForYInRow() {
//        Given
            char[][] boardArray = {
                    {'_', '_', '_'},
                    {'_', '_', '_'},
                    {'Y', 'Y', 'Y'}
            };
            board.setBoard(boardArray);

//        When
            boolean result = board.checkWin();

//        Then
            assertTrue(result);
        }

        @DisplayName("Player 'Y win in colum")
        @Test
        void testCheckWinForYInColumn() {
//        Given
            char[][] boardArray = {
                    {'Y', '_', '_'},
                    {'Y', '_', '_'},
                    {'Y', '_', '_'}
            };
            board.setBoard(boardArray);

//        When
            boolean result = board.checkWin();

//        Then
            assertTrue(result);
        }

        @DisplayName("Player 'Y win diagonally")
        @Test
        void testCheckWinForYDiagonally() {
//        Given
            char[][] boardArray = {
                    {'X', '_', 'Y'},
                    {'X', 'Y', '_'},
                    {'Y', '_', '_'}
            };
            board.setBoard(boardArray);

//        When
            boolean result = board.checkWin();

//        Then
            assertTrue(result);
        }

        @Test
        void testNoWinWithMixedBoard() {
            // Given
            char[][] boardArray = {
                    {'X', 'O', 'X'},
                    {'O', 'X', 'O'},
                    {'O', 'X', 'O'}
            };
            board.setBoard(boardArray);

            // When
            boolean result = board.checkWin();

            // Then
            assertFalse(result);
        }

    }
    @Nested
    @DisplayName("Test Suite for setting marks on board")
    class TestIsPositionValid {
        private Board board;

        @BeforeEach
        void setup() {
            board = new Board(3);
        }

        @DisplayName("Testing correct position.")
        @Test
        void testCheckValidPosition() {
//            Given
            int position = 4;
//            When
            boolean result = board.isPositionValid(position);
//            Then
            assertTrue(result);
        }
        @DisplayName("Testing negative (-1) position.")
        @Test
        void testCheckNegativePosition() {
//            Given
            int position = -1;
//            When
            boolean result = board.isPositionValid(position);
//            Then
            assertFalse(result);
        }

        @DisplayName("Testing out off boundaries position.")
        @Test
        void testCheckOutOffBoundariesPosition() {
//            Given
            int position = 9;
//            When
            boolean result = board.isPositionValid(position);
//            Then
            assertFalse(result);
        }

        @DisplayName("Testing out already taken position.")
        @Test
        void testOccupiedPosition() {
//            Given

            int position = 2;
            board.getBoard()[0][2] = 'X';
//            When
            boolean result = board.isPositionValid(position);
//            Then
            assertFalse(result);
        }
    }
}
