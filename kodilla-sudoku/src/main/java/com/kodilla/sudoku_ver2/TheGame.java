package com.kodilla.sudoku_ver2;

import java.util.Objects;
import java.util.Scanner;

public class TheGame {
    private SudokuBoard sudokuBoard;
    private Welcome welcomeMessage = new Welcome();

    public TheGame(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }



    public void run() {
        Scanner scanner = new Scanner(System.in);
        welcomeMessage.printWelcomeMessage();

        // Wybór trybu gry
        System.out.println("🔹 Wybierz tryb gry:");
        System.out.println("1 - Pusta plansza");
        System.out.println("2 - Losowa plansza (12 losowych liczb)");

        int choice;
        do {
            System.out.print("Wybierz (1 lub 2): ");
            while (!scanner.hasNextInt()) {
                System.out.print("⚠️ Niepoprawny wybór! Wpisz 1 lub 2: ");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice != 1 && choice != 2);

        // Inicjalizacja planszy
        if (choice == 1) {
            sudokuBoard.getEmptySudokuBoard();
        } else {
            sudokuBoard.getRandomSudokuBoard();
        }

        sudokuBoard.printBoard();

        // Rozpoczęcie pomiaru czasu
        long startTime = System.currentTimeMillis();

        while (true) {
            System.out.print("\n📌 Podaj ruch (x y num), 'solve' aby rozwiązać, 'exit' aby wyjść: ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("🚪 Zakończono grę.");
                break;
            } else if (input.equalsIgnoreCase("solve")) {
                System.out.println("🤖 Rozwiązuję Sudoku...");
                SudokuSolver solver = new SudokuSolver(new SudokuValidator());
                if (solver.solve(sudokuBoard)) {
                    System.out.println("✅ Sudoku rozwiązane!");
                } else {
                    System.out.println("❌ Sudoku nie da się rozwiązać.");
                }
                sudokuBoard.printBoard();
                break;
            }

            try {
                int x = Integer.parseInt(input);
                int y = scanner.nextInt();
                int num = scanner.nextInt();

                if (x >= 0 && x < 9 && y >= 0 && y < 9 && num >= 1 && num <= 9) {
                    if (sudokuBoard.getField(x, y).getValue() == Field.EMPTY) {
                        sudokuBoard.setFieldValue(x, y, num);
                        sudokuBoard.printBoard();
                    } else {
                        System.out.println("⚠️ To pole jest już wypełnione! Spróbuj inne.");
                    }
                } else {
                    System.out.println("⚠️ Niepoprawne współrzędne lub liczba (x: 0-8, y: 0-8, num: 1-9).");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Niepoprawny format! Użyj: x y num (np. 2 3 5).");
                scanner.nextLine();
            }

            // Sprawdzenie, czy Sudoku zostało rozwiązane
            if (isSudokuSolved()) {
                System.out.println("\n✅ Brawo! Rozwiązałeś Sudoku!");
                break;
            }
        }

        // Pomiar czasu gry
        long endTime = System.currentTimeMillis();
        long timeTaken = (endTime - startTime) / 1000; // Czas w sekundach
        System.out.println("\n⏳ Czas gry: " + timeTaken + " sekund.");

        // Jeśli Sudoku nie jest w pełni rozwiązane, automatycznie je rozwiązujemy
        if (!isSudokuSolved()) {
            System.out.println("🔄 Nie udało się ukończyć Sudoku, rozwiązuję...");
            SudokuSolver solver = new SudokuSolver(new SudokuValidator());
            solver.solve(sudokuBoard);
            sudokuBoard.printBoard();
            System.out.println("✅ Sudoku zostało dokończone przez solver.");
        }

        scanner.close();
    }

    private boolean isSudokuSolved() {
        for (int row = 0; row < sudokuBoard.getSIZE(); row++) {
            for (int col = 0; col < sudokuBoard.getSIZE(); col++) {
                if (sudokuBoard.getField(row, col).getValue() == Field.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TheGame theGame = (TheGame) o;
        return Objects.equals(getSudokuBoard(), theGame.getSudokuBoard());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getSudokuBoard());
    }

}
