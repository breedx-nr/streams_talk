package com.newrelic.model;

import java.util.List;
import java.util.Optional;

import static com.newrelic.model.Bun.glutenFree;
import static com.newrelic.model.Bun.plain;
import static com.newrelic.model.Bun.potato;
import static com.newrelic.model.Cheese.american;
import static com.newrelic.model.Cheese.bleu;
import static com.newrelic.model.Cheese.pepperjack;
import static com.newrelic.model.Cheese.swiss;
import static com.newrelic.model.Condiment.aioli;
import static com.newrelic.model.Condiment.bbq;
import static com.newrelic.model.Condiment.ketchup;
import static com.newrelic.model.Condiment.mayo;
import static com.newrelic.model.Condiment.peanutButter;
import static com.newrelic.model.Condiment.stoneGroundMustard;
import static com.newrelic.model.Condiment.yellowMustard;
import static com.newrelic.model.Ingredient.bacon;
import static com.newrelic.model.Ingredient.friedBanana;
import static com.newrelic.model.Ingredient.friedEgg;
import static com.newrelic.model.Ingredient.jalapeno;
import static com.newrelic.model.Ingredient.kale;
import static com.newrelic.model.Ingredient.lettuce;
import static com.newrelic.model.Ingredient.mushrooms;
import static com.newrelic.model.Ingredient.onion;
import static com.newrelic.model.Ingredient.onionRing;
import static com.newrelic.model.Ingredient.pastrami;
import static com.newrelic.model.Ingredient.pickle;
import static com.newrelic.model.Ingredient.tomato;
import static com.newrelic.model.Patty.beef;
import static com.newrelic.model.Patty.blackBean;
import static com.newrelic.model.Patty.elk;
import static com.newrelic.model.Patty.veggie;
import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;

public class SkumburgerMenu {

    public static Burger THE_CLASSIC = Burger.builder("The Classic")
            .bun(plain)
            .patties(List.of(beef))
            .cheese(Optional.of(american))
            .ingredients(List.of(lettuce, tomato, pickle, onion))
            .condiments(List.of(ketchup, yellowMustard))
            .build();

    public static Burger THE_ELVIS = Burger.builder("The Elvis")
            .bun(plain)
            .patties(List.of(beef))
            .cheese(Optional.of(american))
            .ingredients(List.of(bacon, friedBanana))
            .condiments(List.of(peanutButter))
            .build();

    public static Burger THE_PORTLANDER = Burger.builder("The Portlander")
            .bun(glutenFree)
            .patties(List.of(veggie))
            .cheese(Optional.empty())
            .ingredients(List.of(kale, tomato, lettuce, mushrooms))
            .condiments(List.of(aioli))
            .build();

    public static Burger CHILDS_PLAY = Burger.builder("Child's Play")
            .bun(plain)
            .patties(List.of(beef))
            .cheese(Optional.of(american))
            .ingredients(emptyList())
            .condiments(List.of(ketchup))
            .build();

    public static Burger THE_HUNTSMAN = Burger.builder("The Huntsman")
            .bun(potato)
            .patties(List.of(elk))
            .cheese(Optional.of(bleu))
            .ingredients(List.of(bacon, onion, friedEgg))
            .condiments(List.of(stoneGroundMustard, mayo))
            .build();

    public static Burger DAINTY_DAISY = Burger.builder("Dainty Daisy")
            .bun(glutenFree)
            .patties(List.of(blackBean))
            .cheese(Optional.of(swiss))
            .ingredients(List.of(lettuce, mushrooms))
            .condiments(List.of(ketchup, aioli))
            .build();

    public static Burger SAY_YOLO = Burger.builder("Say YOLO")
            .bun(potato)
            .patties(List.of(beef, beef))
            .cheese(Optional.of(pepperjack))
            .ingredients(List.of(bacon, onion, jalapeno, onionRing, friedEgg, pastrami))
            .condiments(List.of(bbq, aioli))
            .build();

    public static List<Burger> availableBurgers(){
        return unmodifiableList(List.of(THE_CLASSIC, THE_ELVIS, THE_PORTLANDER,
                CHILDS_PLAY, THE_HUNTSMAN, DAINTY_DAISY, SAY_YOLO));
    }
}
