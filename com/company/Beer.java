package com.company;

import java.io.Serializable;
import java.util.Comparator;

/** Sör osztály */
public class Beer implements Serializable, Comparable<Beer>, Comparator<Beer> {
    /** A sör neve */
    private String name;
    /** A sör típusa */
    private String style;
    /** A sör erőssége */
    private double strength;
    /** A szerializáláshoz szükséges ID */
    static final long serialVersionUID = 33L;

    /** Konstruktor, itt lehet állítani a sör paramétereit. */
    public Beer(String name, String style, double strength) {
        this.name = name;
        this.style = style;
        this.strength = strength;
    }

    public int compareTo(Beer b) {
        return this.getName().compareToIgnoreCase(b.getName());
    }

    public int compare(Beer b1, Beer b2) {
        return CharSequence.compare(b1.getName(), b2.getName());
    }

    /** Getter */
    public String getName() {
        return name;
    }

    /** Getter */
    public String getStyle() {
        return style;
    }

    /** Getter */
    public double getStrength() {
        return strength;
    }

    /** Visszaadja a sör paramétereit vesszővel elválasztva */
    public String toString() {
        return String.format("%s, %s, %f", name, style, strength);
    }

}
