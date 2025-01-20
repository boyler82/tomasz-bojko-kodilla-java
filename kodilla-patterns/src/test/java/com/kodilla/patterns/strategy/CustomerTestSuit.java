package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.BalancedPredictor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTestSuit {

    @Test
    void defaultStrategyTest() {
//        Given
        Customer tom = new CorporateCustomer("Tomek");
        Customer marek = new IndividualCustomer("Marek Zieliński ");
        Customer basia = new IndivadualYoungCustomer("Barbara K.");
//        When
        String tomStrategy = "[AGGRESSIVE PREDICTOR]";
        String marekStrategy = "[BALANCED PREDICTOR]";
        String basiaStrategy = "[CONSERVATIVE PREDICTOR]";
//        Then
        assertEquals(tomStrategy, tom.predict());
        assertEquals(marekStrategy, marek.predict());
        assertEquals(basiaStrategy, basia.predict());
    }
    @Test
    void individualStrategy() {
//        Given
        Customer tom = new CorporateCustomer("Tomek");
//        When
        System.out.println(tom.predict());
        tom.setBuyPredictor(new BalancedPredictor());
        System.out.println(tom.predict());
//        Then
        assertEquals(tom.predict(),"[BALANCED PREDICTOR]");
    }

}
