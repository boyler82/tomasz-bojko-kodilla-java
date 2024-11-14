package com.kodilla.stream.beaurifier;

public class Poembeautifier {
    public void beautify(String poem, PoemDecorator decorator) {
       String result = decorator.decorate(poem);
        System.out.println("Decorated poem: " + result);
    }
}
