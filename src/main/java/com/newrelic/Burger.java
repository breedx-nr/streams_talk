package com.newrelic;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;
import static java.util.List.copyOf;

public class Burger {

    private final Bun bun;
    private final Set<Patty> patties;
    private final Optional<Cheese> cheese;
    private final List<Ingredient> ingredients;
    private final List<Condiment> condiments;

    private Burger(Builder builder) {
        this.bun = builder.bun;
        this.patties = unmodifiableSet(builder.patties);
        this.cheese = builder.cheese;
        this.ingredients = copyOf(builder.ingredients);
        this.condiments = copyOf(builder.condiments);
    }

    public static Builder build() {
        return new Builder();
    }

    public Bun getBun() {
        return bun;
    }

    public Set<Patty> getPatties() {
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
        private Bun bun;
        private Set<Patty> patties;
        private Optional<Cheese> cheese;
        private List<Ingredient> ingredients;
        private List<Condiment> condiments;

        public Builder patties(Set<Patty> patties) {
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
    }
}
