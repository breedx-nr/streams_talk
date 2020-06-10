package com.newrelic.ex;

import com.newrelic.model.Burger;
import com.newrelic.model.Ingredient;
import com.newrelic.model.Patty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.newrelic.model.Ingredient.bacon;
import static com.newrelic.model.Ingredient.ham;
import static com.newrelic.model.Ingredient.pastrami;
import static com.newrelic.model.Patty.beef;
import static com.newrelic.model.Patty.elk;
import static com.newrelic.model.SkumburgerMenu.availableBurgers;

/**
 * This is probably where it all comes together.  Lots of streaming and
 * iteration options abound!  We are swizzling our menu so that it is
 * grouped into vegetarian and meat options.
 */
public class Example07_Grouping_Collection {

    public static void main(String[] args) {
        Example07_Grouping_Collection ex = new Example07_Grouping_Collection();
        System.out.println("Menu: ");
        System.out.println("-------");
        printMenu(ex.collectGroups());
    }

    Map<String,List<Burger>> collectGroups() {
        var result = new HashMap<String,List<Burger>>();
        var burgers = availableBurgers();
        for (Burger burger : burgers) {
            var type = containsFlesh(burger) ? "Meat" : "Veggie";
            if(!result.containsKey(type)){
                result.put(type, new ArrayList<>());
            }
            result.get(type).add(burger);
        }
        return result;
    }

    boolean containsFlesh(Burger burger) {
        for (Patty patty : burger.getPatties()) {
            if(List.of(beef, elk).contains(patty)){
                return true;
            }
        }
        for (Ingredient ingredient : burger.getIngredients()) {
            if(List.of(bacon, ham, pastrami).contains(ingredient)){
                return true;
            }
        }
        return false;
    }

    static void printMenu(Map<String, List<Burger>> groups) {
        for (var group : groups.entrySet()) {
            System.out.println("Type: " + group.getKey());
            for (var burger : group.getValue()) {
                System.out.println(" * " + burger.getName());
            }
        }
    }
}
