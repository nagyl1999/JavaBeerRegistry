package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/** Főosztály */
public class Main {
    /** Parancsokat tároló HashMap */
    public static HashMap<String, Command> parancsok;

    /** Parancsok HashMap-be rendezése */
    public static void setParancsok() {
        Main.parancsok = new HashMap<>();

        /* Parancsok beszúrása */
        Main.parancsok.put("add", new Add());
        Main.parancsok.put("list", new List());
        Main.parancsok.put("save", new Save());
        Main.parancsok.put("load", new Load());
        Main.parancsok.put("find", new Find());
        Main.parancsok.put("search", new Search());
        Main.parancsok.put("delete", new Delete());
    }

    public static void setCompares() {
        Compare.rendezes = new HashMap<>();
        Compare.rendezes.put("name", new Compare.NameComparator());
        Compare.rendezes.put("style", new Compare.StyleComparator());
        Compare.rendezes.put("strength", new Compare.StrengthComparator());
    }

    /** Parancs beolvasás */
    public static String[] readCommand() {
        /* Szöveg beolvasása, majd spaceknél elvágva tömbbe rendezés */
        return (new Scanner(System.in)).nextLine().split(" ");
    }

    /** Fő metódus */
    public static void main(String[] args) {
        /* Parancsot tároló Szting lista */
        String[] cmd;
        /* Söröket tároló ArrayList */
        ArrayList<Beer> beers = new ArrayList<>();
        /* Parancsok létrehozása */
        Main.setParancsok();
        /* Comparator-ok rendezése */
        Main.setCompares();
        /* Fő ciklus */
        while(true) {
            /* Parancs beolvasása a stdin-ről */
            cmd = Main.readCommand();
            /* Kilépünk-e? Ha a lista első eleme "exit", akkor igen, egyébként nem */
            if(cmd[0].equals("exit")) break;
            try {
                /* Parancs végrehajtása, ha létezik */
                beers = Main.parancsok.get(cmd[0]).execute(beers, Arrays.copyOfRange(cmd, 1, cmd.length)); //Levágjuk a parancsot a tömb elejéről
            }catch(NullPointerException n) {
                /* Kiírjuk, hogy a parancs nem létezik */
                System.out.println("Ilyen parancs nem létezik!");
            }catch(Exception e) {
                /* Egyéb hibát kezelünk */
                e.printStackTrace();
            }
        }
    }
}
