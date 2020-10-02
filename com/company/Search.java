package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/** Search osztály, ez az osztály felelős a sörök attribútumai szerinti keresésért */
public class Search implements Command {
    /** Kapott keresendő paraméter(ek) */
    private String[] cmd;
    /** Sörök tárolója */
    private ArrayList<Beer> beers;
    /** Parancsok tárolására használt HashMap */
    private HashMap<String, Runnable> tipusok;

    /** Konstruktor, HashMap megtöltése */
    public Search() {
        tipusok = new HashMap<>();
        tipusok.put("name", this::searchByName);
        tipusok.put("style", this::searchByStyle);
        tipusok.put("strength", this::searchByStrength);
    }

    /** Név alapján keresés */
    private void searchByName() {
        for(Beer beer : beers) {
            /* cmd[cmd.length-1] => az utolsó elem, mivel ha kaptunk extra paramétert, akkor az első a keresendő attribútum */
            if(beer.getName().equals(cmd[cmd.length-1])) System.out.println(beer);
        }
    }

    /** Típus alapján keresés */
    private void searchByStyle() {
        for(Beer beer : beers) {
            /* cmd[cmd.length-1] => az utolsó elem, mivel ha kaptunk extra paramétert, akkor az első a keresendő attribútum */
            if(beer.getStyle().equals(cmd[cmd.length-1])) System.out.println(beer);
        }
    }

    /** Erősség alapján keresés */
    private void searchByStrength() {
        for(Beer beer : beers) {
            /* cmd[cmd.length-1] => az utolsó elem, mivel ha kaptunk extra paramétert, akkor az első a keresendő attribútum */
            if(beer.getStrength() == Double.parseDouble(cmd[cmd.length-1])) System.out.println(beer);
        }
    }

    /** Itt valósítjuk meg a sörökön belüli név szerinti keresést */
    public ArrayList<Beer> execute(ArrayList<Beer> beers, String[] cmd) throws NullPointerException {
        /* Megvizsgáljuk, hogy megfelelő mennyiségü paramétert kaptunk-e */
        if(cmd.length < 1) return beers;
        /* Beállítjuk a söröket saját változónak */
        this.beers = beers; this.cmd = cmd;
        /* Ha nincs extra paraméter akkor név alapján keresünk */
        if(cmd.length == 1) searchByName();
        /* Egyéb esetben megnézzük, hogy tudunk-e keresni a kapott paraméter alapján */
        if(cmd.length == 2) tipusok.get(cmd[0]).run();
        /* Visszatértünk */
        return beers;
    }
}
