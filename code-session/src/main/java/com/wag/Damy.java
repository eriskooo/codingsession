package com.wag;

public class Damy {

    @FunctionalInterface
    interface TriPredicate<A, B, C> {
        boolean test(A a, B b, C c);
    }

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
                    boolean b = horizontal.test(pole, i, j) && vertical.test(pole, i, j);
                    if (b == false) {
                        System.out.println("fail at i=" + i + ", j=" + j);
                        return false;
                    }
                }
            }
        }
        return true;
    }


    static TriPredicate<int[][], Integer, Integer> horizontal = (board, row, col) -> {
        for (int r = 0; r < board.length; r++) {
            if (r == row) continue;
            if (board[r][col] != 0) return true; // found
        }
        return false;
    };

    static TriPredicate<int[][], Integer, Integer> vertical = (board, row, col) -> {
        for (int c = 0; c < board.length; c++) {
            if (c == col) continue;
            if (board[row][c] != 0) return true; // found
        }
        return false;
    };

    static TriPredicate<int[][], Integer, Integer> diagonal = (board, row, col) -> {
        // todo:
        for (int c = 0; c < row; c++) {

        }
        return false;
    };

    private static void kresli(int[][] pole) {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                System.out.print(pole[i][j]);
            }
            System.out.println();
        }
    }
}


