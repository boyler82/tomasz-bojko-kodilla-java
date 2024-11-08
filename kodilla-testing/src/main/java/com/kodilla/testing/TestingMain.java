package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {

        // tu umieść kolejny test ->
        System.out.println("Test - for *Calculator* class:");

        Calculator calculatorTest = new Calculator();

        int addResult = calculatorTest.add(3, 1);
        int subtractResult = calculatorTest.subtract(3, 1);

        if (addResult==4) {
            System.out.println("test OK");
        } else {
            System.out.println("Add method error");
        }
        if (subtractResult==2) {
            System.out.println("test OK");
        } else {
            System.out.println("Subtract method error");
        }
    }
}
