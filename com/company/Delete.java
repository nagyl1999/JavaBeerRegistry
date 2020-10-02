package com.company;

import java.util.ArrayList;
import java.util.Collections;

/** Delete osztály, a sörök közötti törlésért felelős */
public class Delete implements Command {
    /** Itt valósítjuk meg egy adott sör törlését */
    public ArrayList<Beer> execute(ArrayList<Beer> beers, String[] cmd) {
        /* Megvizsgáljuk, hogy megfelelő mennyiségü paramétert kaptunk-e */
        if(cmd.length != 1) return beers;
        /* Index tárolása */
        int index;
        /* ABC alapján rendezzük a söröket */
        Collections.sort(beers);
        /* Bináris kereséssel megkeressük a keresett sört a neve alapján */
        index = Collections.binarySearch(beers, new Beer(cmd[0], null, 0));
        /* Ha az index -1, akkor nem találtuk meg, ha nagyobb egyenlő mint 0, akkor töröljük az elemet */
        if(index >= 0) {
            /* Töröljül az index helyen álló elemet */
            beers.remove(index);
            /* Közöljük hogy a művelet sikeres volt */
            System.out.println("Sikeresen törölve!");
        /* Ha nem találtuk az elemet, kiírjuk, hogy nem található */
        }else System.out.println("Ilyen sör nem található!");
        /* Visszatérünk */
        return beers;
    }
}
