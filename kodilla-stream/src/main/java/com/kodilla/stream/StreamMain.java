package com.kodilla.stream;

import com.kodilla.stream.beaurifier.Poembeautifier;

public class StreamMain {
    public static void main(String[] args) {
        Poembeautifier poembeautifier = new Poembeautifier();
        poembeautifier.beautify("Roses are red.", poem -> poem.toUpperCase() );
        poembeautifier.beautify("Roses are red.", poem -> "ABC" + poem + "ABC");
        poembeautifier.beautify("Roses are red.", poem -> poem.replace("Roses","\u2764\uFE0F"));
        poembeautifier.beautify("Roses are red.", poem -> poem.concat("\u2764\uFE0F").repeat(3));

    }
}