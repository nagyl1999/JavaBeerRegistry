package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/** Save osztály, a sörök tárolojának fájlba mentéséért felelős */
public class Save implements Command {
    /** Itt valósítjuk meg a tároló fájlba mentését */
    public ArrayList<Beer> execute(ArrayList<Beer> beers, String[] cmd) throws IOException {
        /* Megvizsgáljuk, hogy megfelelő mennyiségü paramétert kaptunk-e */
        if(cmd.length != 1) return beers;
        /* FileOutputStream létrehozása */
        FileOutputStream file = new FileOutputStream(cmd[0]);
        /* ObjectOutputStream létrehozása, szükséges a szerializációhoz */
        ObjectOutputStream object = new ObjectOutputStream(file);
        /* Tároló mentése */
        object.writeObject(beers);
        /* Stream bezárása */
        file.close();
        /* Stream bezárása */
        object.close();
        /* Közöljük a felhasználóval, hogy a művelet sikeres volt */
        System.out.println("A mentés megtörtént!");
        /* Visszatérünk */
        return beers;
    }
}
