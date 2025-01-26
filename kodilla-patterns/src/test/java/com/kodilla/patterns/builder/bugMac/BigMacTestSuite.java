package com.kodilla.patterns.builder.bugMac;

import com.kodilla.patterns.builder.bigMac.BigMac;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        String sauce = "THOUSAND_ISLAND";
//        then
        assertEquals(sauce,myBigMac.getSauce().name());
    }

}
