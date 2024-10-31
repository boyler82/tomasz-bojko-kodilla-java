package com.kodilla.calculatorApp;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        AddNumbers addNumbers = new AddNumbers();
        int i = addNumbers.AddNumbers(2, 3);
        System.out.println(i);
    }
}
