package com.newrelic.ex;

import com.newrelic.model.Burger;

import java.util.List;

import static com.newrelic.model.BurgerBackoffice.dailyOrders;

/**
 * How many total burgers did we sell?
 * The answer is obtained by summing up the number of burgers
 * sold each day.
 */
public class Example02_Count {

    public static void main(String[] args) {
        Example02_Count ex = new Example02_Count();
        System.out.println("We sold " + ex.looped() + " burgers");
        System.out.println("We sold " + ex.loopImproved() + " burgers");
        System.out.println("We sold " + ex.streamed() + " burgers");
    }

    int looped() {
        int total = 0;
        for (int i = 0; i < dailyOrders.size(); i++) {
            List<Burger> daily = dailyOrders.get(i);
            total = total + daily.size();
        }
        return total;
    }

    int loopImproved() {
        int total = 0;
        for (List<Burger> daily : dailyOrders) {
            total += daily.size();
        }
        return total;
    }

    int streamed() {
        return dailyOrders.stream()
                .map(List::size)
                .reduce(0, Integer::sum);
    }
}
