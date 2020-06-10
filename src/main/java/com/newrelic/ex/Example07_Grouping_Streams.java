package com.newrelic.ex;

import com.newrelic.model.Burger;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static com.newrelic.model.Ingredient.bacon;
import static com.newrelic.model.Ingredient.ham;
import static com.newrelic.model.Ingredient.pastrami;
import static com.newrelic.model.Patty.beef;
import static com.newrelic.model.Patty.elk;
import static com.newrelic.model.SkumburgerMenu.availableBurgers;
import static java.util.stream.Collectors.groupingBy;

/**
 * This is probably where it all comes together.  Lots of streaming and
 * iteration options abound!  We are swizzling our menu so that it is
 * grouped into vegetarian and meat options.
 */
public class Example07_Grouping_Streams {

    public static void main(String[] args) {
        Example07_Grouping_Streams ex = new Example07_Grouping_Streams();
        System.out.println("Menu: ");
        System.out.println("-------");
        printMenu(ex.collectGroups());
    }

    Map<String, List<Burger>> collectGroups() {
        return availableBurgers().stream()
                .collect(groupingBy(burger ->
                        containsFlesh(burger) ? "Meat" : "Veggie")
                );
    }

    boolean containsFlesh(Burger burger) {
        return Stream.concat(
                burger.getPatties().stream()
                        .map(patty -> List.of(beef, elk).contains(patty)
                        ),
                burger.getIngredients().stream()
                        .map(ingredient -> List.of(bacon, ham, pastrami).contains(ingredient))
        )
                .anyMatch(Boolean::booleanValue);
    }

    static void printMenu(Map<String, List<Burger>> collectGroups) {
        collectGroups.forEach((key, value) -> {
            System.out.println("Type: " + key);
            value.forEach(burger -> System.out.println(" * " + burger.getName()));
        });
    }
}
