package chapter16.lesson01;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Hero> heros = new ArrayList<>();

        heros.add(new Hero("たなか"));
        heros.add(new Hero("すずき"));

        for (Hero h : heros) {
            System.out.println(h.getName());
        }

    }
}
