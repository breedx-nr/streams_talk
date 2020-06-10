package com.newrelic.ex;

import com.newrelic.model.Burger;
import com.newrelic.model.Patty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.newrelic.model.SkumburgerMenu.availableBurgers;

/**
 * Building on example 03, we want a list of all available patties,
 * but we don't want to see the frustrating duplicates any more!
 */
public class Example04_Deduped {

    public static void main(String[] args) {
        Example04_Deduped ex = new Example04_Deduped();
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
                if(!result.contains(patty)){
                    result.add(patty);
                }
            }
        }
        return result;
    }

    Set<Patty> loopImproved() {
        Set<Patty> result = new HashSet<>();
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
                .distinct()
                .collect(Collectors.toList());
    }
}
