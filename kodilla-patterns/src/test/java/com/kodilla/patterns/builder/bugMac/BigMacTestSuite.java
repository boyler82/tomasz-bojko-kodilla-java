package com.kodilla.patterns.builder.bugMac;

import com.kodilla.patterns.builder.bigMac.BigMac;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BigMacTestSuite {

    @Test
    void BigMacBuilderTest() {
//        given
        BigMac myBigMac = new BigMac.Builder()
                .bun(BigMac.Bun.SESAME)
                .burgers(2)
                .sauce(BigMac.Sauce.THOUSAND_ISLAND)
                .ingredient(BigMac.Ingredient.BACON)
                .ingredient(BigMac.Ingredient.CHEESE)
                .build();
        System.out.println(myBigMac);
//        when
        String bun = "SESAME";
        String sauce = "THOUSAND_ISLAND";
        List<String> ingredients = new ArrayList<>();
        ingredients.add("BACON");
        ingredients.add("CHEESE");
//        then
        assertEquals(sauce, myBigMac.getSauce().name());
        assertEquals(bun, myBigMac.getBun().name());
        assertEquals(2, myBigMac.getBurgers());
        assertEquals(2, myBigMac.getIngredients().size());
    }

    @Test
    void testBurgerLessThanOneOrMoreThanThree() {
        // given
        BigMac.Builder builder = new BigMac.Builder();

        // when & then
        assertThrows(IllegalArgumentException.class, () -> builder.burgers(0));
        assertThrows(IllegalArgumentException.class, () -> builder.burgers(4));
    }

    @Test
    void testBunIsNull() {
        // given
        BigMac.Builder builder = new BigMac.Builder()
                .burgers(1)
                .sauce(BigMac.Sauce.STANDARD)
                .ingredient(BigMac.Ingredient.ONION);

        // when & then
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> builder.build());
        assertEquals("Bun must not be null.", exception.getMessage());
    }

    @Test
    void testBurgerWithZeroIngredients() {
        // given
        BigMac.Builder builder = new BigMac.Builder()
                .bun(BigMac.Bun.PLAIN)
                .burgers(1)
                .sauce(BigMac.Sauce.BARBECUE);

        // when & then
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> builder.build());
        assertEquals("At least one ingredient must be added.", exception.getMessage());
    }
}
