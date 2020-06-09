package com.newrelic.ex;

import com.newrelic.model.Burger;

import java.util.List;

import static com.newrelic.model.SkumburgerMenu.availableBurgers;

/**
 * Let's say we want to print out the number of ingredients for each burger.
 */
public class Example03_Iterate {

    public static void main(String[] args) {
        Example03_Iterate ex = new Example03_Iterate();
        ex.looped();
        ex.loopImproved();
        ex.streamed();
    }

    void looped() {
        List<Burger> burgers = availableBurgers();
        for (int i = 0; i < burgers.size(); i++) {
            Burger burger = burgers.get(i);
            int num = burger.getIngredients().size();
            System.out.println("This burger has " + num + " ingredients");
        }
    }

    void loopImproved() {
        for (Burger burger : availableBurgers()) {
            int num = burger.getIngredients().size();
            System.out.println("This burger has " + num + " ingredients");
        }
    }

    void streamed() {
        availableBurgers().stream()
                .map(burger -> burger.getIngredients().size())
                .forEach(num -> {
                    System.out.println("This burger has " + num + " ingredients");
                });
    }
}
