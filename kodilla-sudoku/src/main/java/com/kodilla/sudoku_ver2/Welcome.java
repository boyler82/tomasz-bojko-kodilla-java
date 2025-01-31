package com.kodilla.sudoku_ver2;

public class Welcome {
    public void printWelcomeMessage() {
        System.out.println("\n" +
                "███████╗██╗   ██╗██████╗  ██████╗ ██╗  ██╗██╗   ██╗\n" +
                "██╔════╝██║   ██║██╔══██╗██╔═══██╗██║  ██║██║   ██║\n" +
                "███████╗██║   ██║██████╔╝██║   ██║███████║██║   ██║\n" +
                "╚════██║██║   ██║██╔═══╝ ██║   ██║██╔══██║██║   ██║\n" +
                "███████║╚██████╔╝██║     ╚██████╔╝██║  ██║╚██████╔╝\n" +
                "╚══════╝ ╚═════╝ ╚═╝      ╚═════╝ ╚═╝  ╚═╝ ╚═════╝ \n");


        System.out.println("\n✨ Witaj w grze Sudoku! ✨\n");
        System.out.println("\n✨ Podaj pozycje pola i wprowadź wartość (x,y,liczba), ✨ \n✨ gdzie x i y to współrzędne pola, ✨ \n✨ a liczba ma wartość od 1 do 9 ✨\n");
    }
}