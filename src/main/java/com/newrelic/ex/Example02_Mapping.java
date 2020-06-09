package com.newrelic.ex;

import com.newrelic.model.Burger;
import com.newrelic.model.Patty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.newrelic.model.SkumburgerMenu.availableBurgers;

/**
 * Say we want to get a list of all the patties, so we know what
 * kinds to prepare for.
 */
public class Example02_Mapping {

    public static void main(String[] args) {
        Example02_Mapping ex = new Example02_Mapping();
        System.out.println(ex.looped());
        System.out.println(ex.loopImproved());
        System.out.println(ex.streamed());
    }

    List<List<Patty>> looped() {
        List<List<Patty>> result = new ArrayList<>();
        List<Burger> burgers = availableBurgers();
        for (int i = 0; i < burgers.size(); i++) {
            Burger burger = burgers.get(i);
            List<Patty> patties = burger.getPatties();
            result.add(patties);
        }
        return result;
    }

    List<List<Patty>> loopImproved() {
        List<List<Patty>> result = new ArrayList<>();
        List<Burger> burgers = availableBurgers();
        for (Burger burger : burgers) {
            result.add(burger.getPatties());
        }
        return result;
    }

    List<List<Patty>> streamed() {
        return availableBurgers().stream()
                .map(Burger::getPatties)
                .collect(Collectors.toList());
    }
}
