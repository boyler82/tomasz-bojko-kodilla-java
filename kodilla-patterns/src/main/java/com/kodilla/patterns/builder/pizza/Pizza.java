package com.kodilla.patterns.builder.pizza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pizza {

    private final String bottom;
    private final String sauce;
    private final List<String> ingredients = new ArrayList<>();


    public Pizza(final String bottom,final String sauce, final String... ingredients) {
        this.bottom = bottom;
        this.sauce = sauce;
        this.ingredients.addAll(Arrays.asList(ingredients));
    }

    public String getBottom() {
        return bottom;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getSauce() {
        return sauce;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "bottom='" + bottom + '\'' +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    public static class PizzaBuilder {
        private  String bottom;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();


        public PizzaBuilder bottom(final String bottom) {
            this.bottom = bottom;
            return this;
        }

        public PizzaBuilder sauce(final String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder ingredients(final String... ingredients) {
            this.ingredients.addAll(Arrays.asList(ingredients));
            return this;
        }

        public Pizza build() {
            return new Pizza(bottom, sauce, ingredients.toArray(new String[0]));
        }
    }
}
