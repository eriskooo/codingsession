package com.wag;

public class Bublinka {

    static int[] cisla = {1, 5, 4, 3, 2, -1, 8, 0};

    public static void main(String[] args) {
        int[] vysledok = bublina(cisla);
        for (int i = 0; i < cisla.length ; i++) {
            System.out.println(vysledok[i]);
        }
    }

    private static int[] bublina(int[] cisla) {
        boolean zmena = true;
        while (zmena) {
            zmena = false;
            for (int i = 0; i < cisla.length -1; i++) {
                if (cisla[i] > cisla[i+1]) {
                    int a = cisla[i];
                    int b = cisla[i+1];
                    cisla[i] = b;
                    cisla[i+1] = a;
                    zmena = true;
                }
            }
        }

        return cisla;
    }
}
