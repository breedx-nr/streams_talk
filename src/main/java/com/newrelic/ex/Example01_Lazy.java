package com.newrelic.ex;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Demonstration of lazy evaluation.
 * What do you think this program prints?
 * Run it and find out!
 */
public class Example01_Lazy {

    public static void main(String[] args) {
        System.out.println("Starting");
        Example01_Lazy ex = new Example01_Lazy();
        ex.lazy();
        ex.infinite();
        System.out.println("Program complete");
    }

    void lazy() {
        IntStream.range(10, 20)
                .map(operand -> {
                    System.out.println("Processing " + operand);
                    return 0;
                });
    }

    void infinite() {
        AtomicLong value = new AtomicLong();
        Stream.generate(value::getAndIncrement);
    }
}
