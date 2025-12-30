package com.wag;

public class Damy {

    static int[][] pole = {
            {0, 1, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
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
        // horizontaly
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                if (pole[i][j] != 0) {
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
        return false;
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


