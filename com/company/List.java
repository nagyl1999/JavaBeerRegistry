package com.company;

import java.util.*;

/** List osztály, a sörök tetszőleges sorrendjében való kilistázásáért felelős */
public class List implements Command {
    /** Itt valósítjuk meg a sörök kilistázását */
    public ArrayList<Beer> execute(ArrayList<Beer> beers, String[] cmd) {
        /* Megfordítjuk a listát, ez a rendezés sorrendjéhez szükséges
         * A megfordítás azért szükséges, mert ha a leggyengébb rendezési
         * szempontal kezdünk, és haladunk a legerősebb felé, akkor a már
         * gyengébb szempont szerint rendezett listát tudjuk újra rendezni,
         * ahol pedig nem történt változás, megtartja az előzőleg rendezett alakját
         */
        Collections.reverse(Arrays.asList(cmd));
        /* Rendezzük a listát a megadott paraméterek alapján, ha nincs paraméter, nem lépünk be a ciklusba */
        for(String s : cmd) beers.sort(Compare.rendezes.get(s));
        /* Egy ciklussal végig futunk a sörök listáján, akár rendezve lettek, akár nem, majd kiírjuk őket */
        for(Beer beer : beers) System.out.println(beer.toString());
        /* Visszatérünk */
        return beers;
    }
}
