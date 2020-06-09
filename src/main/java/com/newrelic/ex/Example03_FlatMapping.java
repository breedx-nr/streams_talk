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
public class Example03_FlatMapping {

    public static void main(String[] args) {
        Example03_FlatMapping ex = new Example03_FlatMapping();
        System.out.println(ex.looped());
        System.out.println(ex.loopImproved());
        System.out.println(ex.streamed());
    }

    List<Patty> looped() {
        List<Patty> result = new ArrayList<>();
        List<Burger> burgers = availableBurgers();
        for (int i = 0; i < burgers.size(); i++) {
            Burger burger = burgers.get(i);
            List<Patty> patties = burger.getPatties();
            for(int j = 0; j < patties.size(); j++){
                Patty patty = patties.get(j);
                result.add(patty);
            }
        }
        return result;
    }

    List<Patty> loopImproved() {
        List<Patty> result = new ArrayList<>();
        List<Burger> burgers = availableBurgers();
        for (Burger burger : burgers) {
            List<Patty> patties = burger.getPatties();
            result.addAll(patties);
        }
        return result;
    }

    List<Patty> streamed() {
        return availableBurgers().stream()
                .flatMap(burger -> burger.getPatties().stream())
                .collect(Collectors.toList());
    }
}
