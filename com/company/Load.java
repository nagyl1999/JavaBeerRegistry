package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/** Load osztály, a sörök tárolójának fájlból való beolvasásáért felelős */
public class Load implements Command {
    /** Itt valósítjuk meg a sörök tárolójának beolvasását */
    public ArrayList<Beer> execute(ArrayList<Beer> beers, String[] cmd) throws IOException, ClassNotFoundException {
        /* Megvizsgáljuk, hogy megfelelő mennyiségü paramétert kaptunk-e */
        if(cmd.length != 1) return beers;
        /* FileInputStream létrehozása */
        FileInputStream file = new FileInputStream(cmd[0]);
        /* ObjectInputStream létrehozása, ennek segítségével olvassuk be a tárolót */
        ObjectInputStream object = new ObjectInputStream(file);
        /* Tároló beolvasása */
        beers = (ArrayList<Beer>) object.readObject();
        /* Stream bezárása */
        file.close();
        /* Stream bezárása */
        object.close();
        /* Közöljük, hogy a művelet sikeres volt */
        System.out.println("A beolvasás megtörtént!");
        /* Visszatérünk */
        return beers;
    }
}
