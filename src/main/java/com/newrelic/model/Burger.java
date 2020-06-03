package com.newrelic.model;

import java.util.List;
import java.util.Optional;

import static java.util.List.copyOf;

public class Burger {

    private final String name;
    private final Bun bun;
    private final List<Patty> patties;
    private final Optional<Cheese> cheese;
    private final List<Ingredient> ingredients;
    private final List<Condiment> condiments;

    private Burger(Builder builder) {
        this.name = builder.name;
        this.bun = builder.bun;
        this.patties = copyOf(builder.patties);
        this.cheese = builder.cheese;
        this.ingredients = copyOf(builder.ingredients);
        this.condiments = copyOf(builder.condiments);
    }

    public static Builder builder(String name) {
        return new Builder(name);
    }

    public Bun getBun() {
        return bun;
    }

    public List<Patty> getPatties() {
        return patties;
    }

    public Optional<Cheese> getCheese() {
        return cheese;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Condiment> getCondiments() {
        return condiments;
    }

    public static class Builder {
        private final String name;
        private Bun bun;
        private List<Patty> patties;
        private Optional<Cheese> cheese;
        private List<Ingredient> ingredients;
        private List<Condiment> condiments;

        public Builder(String name) {
            this.name = name;
        }

        public Builder patties(List<Patty> patties) {
            this.patties = patties;
            return this;
        }

        public Builder cheese(Optional<Cheese> cheese) {
            this.cheese = cheese;
            return this;
        }

        public Builder bun(Bun bun){
            this.bun = bun;
            return this;
        }

        public Builder ingredients(List<Ingredient> ingredients){
            this.ingredients = ingredients;
            return this;
        }

        public Builder condiments(List<Condiment> condiments){
            this.condiments = condiments;
            return this;
        }

        public Burger build(){
            return new Burger(this);
        }
    }
}
