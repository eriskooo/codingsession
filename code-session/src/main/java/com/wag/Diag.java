package com.wag;

public class Diag {


    /**
     * Mozes umiestnit damu ? validacia diagonaly.
     *
     * @param row
     * @param col
     * @param plocha
     * @return
     */
    static boolean isSafe(int row, int col, int plocha[]) {
        for (int i = 0; i < plocha.length; i++) {
            if (plocha[i] != -1) {
                if (Math.abs(row - i) == Math.abs(col - plocha[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
