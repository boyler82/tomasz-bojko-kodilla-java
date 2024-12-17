package com.kodilla.challenges.silnia;

public class Factoral {

    public static long factoral(int n) {
        if ( n<=0 ) {
            throw new IllegalArgumentException("Factoral mast be positiv number.");
        }
        long factoral = 1;
        for (int i = 1; i <= n; i++) {
            factoral *= i;
        }
        return factoral;
    }
}
