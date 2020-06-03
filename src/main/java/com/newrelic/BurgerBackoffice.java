package com.newrelic;

import java.util.Collections;
import java.util.List;

public class BurgerBackoffice {

    // Normally this would come from a service or a database or similar
    public final static List<List<Burger>> dailyOrders = Collections.unmodifiableList(List.of(
            List.of(
                    SkumburgerMenu.CHILDS_PLAY, SkumburgerMenu.CHILDS_PLAY, SkumburgerMenu.THE_ELVIS,
                    SkumburgerMenu.THE_CLASSIC, SkumburgerMenu.THE_CLASSIC, SkumburgerMenu.THE_ELVIS,
                    SkumburgerMenu.THE_PORTLANDER, SkumburgerMenu.THE_PORTLANDER, SkumburgerMenu.DAINTY_DAISY
            ),
            List.of(
                    SkumburgerMenu.THE_CLASSIC, SkumburgerMenu.THE_HUNTSMAN, SkumburgerMenu.THE_CLASSIC,
                    SkumburgerMenu.THE_CLASSIC, SkumburgerMenu.DAINTY_DAISY, SkumburgerMenu.THE_CLASSIC,
                    SkumburgerMenu.THE_ELVIS, SkumburgerMenu.THE_PORTLANDER, SkumburgerMenu.SAY_YOLO,
                    SkumburgerMenu.THE_HUNTSMAN, SkumburgerMenu.CHILDS_PLAY, SkumburgerMenu.THE_CLASSIC,
                    SkumburgerMenu.SAY_YOLO, SkumburgerMenu.THE_PORTLANDER, SkumburgerMenu.THE_CLASSIC
                    ),
            List.of(
                    SkumburgerMenu.THE_CLASSIC, SkumburgerMenu.CHILDS_PLAY, SkumburgerMenu.SAY_YOLO,
                    SkumburgerMenu.THE_HUNTSMAN, SkumburgerMenu.THE_ELVIS, SkumburgerMenu.SAY_YOLO,
                    SkumburgerMenu.THE_PORTLANDER, SkumburgerMenu.THE_PORTLANDER, SkumburgerMenu.THE_PORTLANDER
            )));
}
