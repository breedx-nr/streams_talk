package com.newrelic.ex;

import com.newrelic.model.Burger;

import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

import static com.newrelic.model.BurgerBackoffice.dailyOrders;

/**
 * Demonstration of lazy evaluation.
 * What do you think this program prints?
 * Run it and find out!
 */
public class Example01_Lazy {

    public static void main(String[] args) {
        System.out.println("Starting");
        IntStream.range(10, 20)
            .map(operand -> {
                System.out.println("Processing " + operand);
                return 0;
            });
    }
}
