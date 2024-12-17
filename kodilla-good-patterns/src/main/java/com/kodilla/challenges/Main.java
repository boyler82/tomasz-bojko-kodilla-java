package com.kodilla.challenges;
import com.kodilla.challenges.MovieStore;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        String movieString = movieStore.getMovies().values().stream()
                .flatMap(List:: stream)
                .collect(Collectors.joining("! "));
        System.out.println(movieString);
    }
}
