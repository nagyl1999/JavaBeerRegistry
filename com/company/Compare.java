package com.company;

import java.util.Comparator;
import java.util.HashMap;

/** Compare osztály, a comparatorok létrehozásáért felelős */
public class Compare {
    /** A rendezéseket tartalmazó tároló */
    public static HashMap<String, Comparator<Beer>> rendezes;

    /** Név alapján rendezés */
    public static class NameComparator implements Comparator<Beer> {
        public int compare(Beer a, Beer b) {
            return a.getName().compareTo(b.getName());
        }
    }

    /** Típus alapján rendezés */
    public static class StyleComparator implements Comparator<Beer> {
        public int compare(Beer a, Beer b) {
            return a.getStyle().compareTo(b.getStyle());
        }
    }

    /** Erősség alapján rendezés */
    public static class StrengthComparator implements Comparator<Beer> {
        public int compare(Beer a, Beer b) {
            return Double.compare(a.getStrength(), b.getStrength());
        }
    }
}
