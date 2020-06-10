package com.newrelic.ex;

import com.newrelic.model.Burger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.newrelic.model.SkumburgerMenu.availableBurgers;

/**
 * Time to print our menu!  Lets get the burgers in alphabetical order
 * so that we can print them out!
 */
public class Example05_Sorting {

    public static void main(String[] args) {
        System.out.println("Unsorted: " + names(availableBurgers()));

        Example05_Sorting ex = new Example05_Sorting();
//        System.out.println("Sorted: " + ex.withCollections());  //UOE here, beware
        System.out.println("Sorted: " + names(ex.withUsableCollections()));
        System.out.println("Sorted: " + names(ex.streamed()));
    }

    List<Burger> withCollections() {
        List<Burger> burgers = availableBurgers();
        Collections.sort(burgers, Comparator.comparing(Burger::getName));
        return burgers;
    }

    List<Burger> withUsableCollections() {
        List<Burger> burgers = new ArrayList<>(availableBurgers());
        burgers.sort(Comparator.comparing(Burger::getName));
        return burgers;
    }

    List<Burger> streamed() {
        return availableBurgers().stream()
                .sorted(Comparator.comparing(Burger::getName))
                .collect(Collectors.toList());
    }

    // a basic printing press
    private static String names(List<Burger> burgs) {
        return burgs.stream().map(Burger::getName).collect(Collectors.joining(", "));
    }
}
