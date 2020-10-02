package com.company;

import java.util.ArrayList;

/** Command interfész, tartalmaz minden parancs számára implementálandó metódust */
public interface Command {
    /** Végrehajtja a parancsot, majd visszatér a sörök tárolójával
     * @return*/
    ArrayList<Beer> execute(ArrayList<Beer> beers, String[] cmd) throws Exception;
}
