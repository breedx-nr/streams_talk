package com.newrelic.ex;

import com.newrelic.model.Burger;
import com.newrelic.model.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.newrelic.model.SkumburgerMenu.availableBurgers;

/**
 * Your friend is a fiend for tomatoes!  Let's help her by filtering
 * the menu to just burgers with tomato!
 */
public class Example06_Filtering {

    public static void main(String[] args) {
        Example06_Filtering ex = new Example06_Filtering();
        System.out.println("Tomato burgers: " + names(ex.collectTomatoes()));
        System.out.println("Tomato burgers: " + names(ex.streamTomatoes()));
    }

    List<Burger> collectTomatoes() {
        List<Burger> result = new ArrayList<>();
        List<Burger> burgers = availableBurgers();
        for (Burger burger : burgers) {
            if(burger.getIngredients().contains(Ingredient.tomato)){
                result.add(burger);
            }
        }
        return result;
    }

    List<Burger> streamTomatoes() {
        return availableBurgers().stream()
                .filter(burger -> burger.getIngredients().contains(Ingredient.tomato))
                .collect(Collectors.toList());
    }

    private static String names(List<Burger> burgs) {
        return burgs.stream().map(Burger::getName).collect(Collectors.joining(", "));
    }
}
