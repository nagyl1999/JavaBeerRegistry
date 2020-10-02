package com.company;

import java.util.ArrayList;

/** Add osztály, a söröket tartalmazó lista elemeinek bővítéséért felelős, egy új sör hozzáadásával */
public class Add implements Command {
    /** Itt valósítjuk meg az új sör létrehozását, és listához fűzését */
    public ArrayList<Beer> execute(ArrayList<Beer> beers, String[] cmd) {
        /* Megvizsgáljuk, hogy megfelelő mennyiségü paramétert kaptunk-e */
        if(cmd.length != 3) return beers;
        /* Sör hozzáadása a listához */
        beers.add(new Beer(cmd[0], cmd[1], Double.parseDouble(cmd[2])));
        /* Közöljük a felhasználóval, hogy a művelet sikeres volt */
        System.out.println("Sör hozzáadva!");
        /* Visszatérünk */
        return beers;
    }
}
