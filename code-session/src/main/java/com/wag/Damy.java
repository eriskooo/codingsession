package com.wag;

public class Damy {

    static int[][] pole = {
            {0, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
    };

    public static void main(String[] args) {
        kresli(pole);
        boolean ok = validuj(pole);
        System.out.println(ok);
    }

    private static boolean validuj(int[][] pole) {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                if (pole[i][j] != 0) {
                    System.out.println("pozeram riadok =" + i + ", stlpec=" + j);
                    boolean b = pozriSmery(pole, i, j);
                    if (b == false) {
                        System.out.println("fail at i=" + i + ", j=" + j);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean pozriSmery(int[][] pole, int i, int j) {
        for (int c = 0; c < pole.length; c++) {
            if (c == i) continue;
            if (pole[c][j] != 0) return false;
        }
        for (int c = 0; c < pole.length; c++) {
            if (c == j) continue;
            if (pole[i][c] != 0) return false;
        }
        return true;
    }

    private static void kresli(int[][] pole) {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                System.out.print(pole[i][j]);
            }
            System.out.println();
        }
    }
}


