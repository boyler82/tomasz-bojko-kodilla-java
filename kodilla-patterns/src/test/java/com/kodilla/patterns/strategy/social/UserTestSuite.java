package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

        User millenialUser = new Millenials("Liam");
        User yUser = new YGeneration("Noah");
        User zUser = new ZGeneration("Emma");


    @Test
    void testDefaultSharingStrategies() {
//        Given
//        When
        String millennialStrategy = millenialUser.getSocialPublisher();
        String yStrategy = yUser.getSocialPublisher();
        String zStrategy = zUser.getSocialPublisher();
//        Then
        assertEquals(millennialStrategy, "I'm using Facebook");
        assertEquals(yStrategy, "I'm using Snapchat");
        assertEquals(zStrategy, "I'm using Twitter");

    }

    @Test
    void testIndividualSharingStrategy() {
//        Given
//        When
        yUser.setSocialPublisher(new SnapchatPublisher());
//        Then
        assertEquals(yUser.getSocialPublisher(),"I'm using Snapchat");

    }


}
