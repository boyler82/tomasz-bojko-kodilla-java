package com.kodilla.calculatorApp;

public class AddNumbers {
    private int a;
    private int b;
    public int AddNumbers(int a, int b) {
        this.a = a;
        this.b = b;
        int sum = a + b;
        return sum;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
