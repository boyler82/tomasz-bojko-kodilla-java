package com.kodilla.patterns.builder.bigMac;

import java.util.ArrayList;

import java.util.List;

public class BigMac {

    public enum Bun {
        SESAME, PLAIN;
    }

    public enum Sauce {
        STANDARD, THOUSAND_ISLAND, BARBECUE;
    }

    public enum Ingredient {
        LETTUCE, ONION, BACON, PICKLE, CHEESE, PEPPER, SHRIMP, MUSHROOMS;
    }

    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private final List<Ingredient> ingredients;

    private BigMac(Bun bun, int burgers, Sauce sauce, List<Ingredient> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    @Override
    public String toString() {
        return "BigMac{" +
                "bun=" + bun +
                ", burgers=" + burgers +
                ", sauce=" + sauce +
                ", ingredients=" + ingredients +
                '}';
    }

    public static class Builder {
        private Bun bun;
        private int burgers;
        private Sauce sauce;
        private List<Ingredient> ingredients = new ArrayList<>();

        public Builder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public Builder burgers(int burgers) {
            if (burgers < 1 || burgers > 3) {
                throw new IllegalArgumentException("Number of burgers must be between 1 and 3.");
            }
            this.burgers = burgers;
            return this;
        }

        public Builder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public Builder ingredient(Ingredient ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public BigMac build() {
            if (bun == null) {
                throw new IllegalStateException("Bun must not be null.");
            }
            if (ingredients.isEmpty()) {
                throw new IllegalStateException("At least one ingredient must be added.");
            }
            return new BigMac(bun, burgers, sauce, ingredients);
        }
    }
}