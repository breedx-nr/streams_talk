package com.newrelic.ex;

import com.newrelic.model.Burger;

import java.util.List;

import static com.newrelic.model.BurgerBackoffice.dailyOrders;

/**
 * How many total burgers did we sell?
 * The answer is obtained by summing up the number of burgers
 * sold each day.
 */
public class Example1 {

    public static void main(String[] args) {
        System.out.println("We sold " + looped() + " burgers");
        System.out.println("We sold " + loopImproved() + " burgers");
        System.out.println("We sold " + streamed() + " burgers");
    }

    static int looped() {
        int total = 0;
        for (int i = 0; i < dailyOrders.size(); i++) {
            List<Burger> daily = dailyOrders.get(i);
            total = total + daily.size();
        }
        return total;
    }

    static int loopImproved() {
        int total = 0;
        for (List<Burger> daily : dailyOrders) {
            total += daily.size();
        }
        return total;
    }

    static int streamed() {
        return dailyOrders.stream()
                .map(List::size)
                .reduce(0, Integer::sum);
    }
}
