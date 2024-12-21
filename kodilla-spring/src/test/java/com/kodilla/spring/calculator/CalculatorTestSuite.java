package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculator() {
//        Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
//        When
        double valueAdd = calculator.add(2,2);
        double valueSub = calculator.sub(2,2);
        double valueMul = calculator.mul(2,2);
        double valueDiv = calculator.div(2,2);

//        mozemy pogadac na spotkniu jak to zrobic...
//        double valueDivWithZero = calculator.div(2,0);

//        Then
        assertEquals(4.0, valueAdd);
        assertEquals(0, valueSub);
        assertEquals(4.0, valueMul);
        assertEquals(1, valueDiv);
//        assertEquals(IllegalArgumentException.class, valueDivWithZero)


    }
}