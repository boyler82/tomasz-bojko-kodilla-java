package com.kodilla.stream.mirror;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MirrorTestSuite {

    @Test
    void testMirrorString() {
//        Given
        List<String> testWordList = new ArrayList<>();
        testWordList.add("Koala");
        testWordList.add("Ziemiak");
        testWordList.add("Jajo");
//        When
        testWordList.stream()
                .forEach(word -> {
                    String reversed = new StringBuilder(word).reverse().toString();
                System.out.println(word + " -> " + reversed);
                });


//        Then



    }
}
