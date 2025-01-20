package com.kodilla.patterns.builder;

import com.kodilla.patterns.builder.pizza.Pizza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTestSuite {

    @Test
    void testPizza() {
//        Given
        Pizza pizza = new Pizza.PizzaBuilder().bottom("thin").sauce("spicy").ingredients("pepperoni", "mushrooms").build();
//        When
        System.out.println(pizza);
        int howManyIngredients = pizza.getIngredients().size();
//        Then
        assertEquals(2, howManyIngredients);

    }


}
