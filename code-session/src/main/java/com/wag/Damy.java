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
        int[] rowBoard = board[row];
        for (int r = 0; r < board.length; r++) {
            if (rowBoard[r] != 0) {
                return true; // found
            }
        }
        return false;
    };

    static TriPredicate<int[][], Integer, Integer> vertical = (board, row, col) -> {
        for (int c = 0; c < board.length; c++) {
            int[] rowBoard = board[c];
            if (rowBoard[col] != 0) return true; // found
        }
        return false;
    };

    static TriPredicate<int[][], Integer, Integer> diagonal = (board, row, col) -> {
        int leftUp = col;
        for (int i = row - 1; i >= 0; i--) {
            int[] rowBoard = board[i];
            if (--leftUp >= 0) {
                if (rowBoard[leftUp] != 0) return true;
            }
        }

        int rightUp = col;
        for (int i = row - 1; i >= 0; i--) {
            int[] rowBoard = board[i];
            if (++rightUp <= rowBoard.length - 1) {
                if (rowBoard[rightUp] != 0) return true;
            }
        }

        int leftDown = col;
        for (int i = row + 1; i < board.length; i++) {
            int[] rowBoard = board[i];
            if (--leftDown >= 0) {
                if (rowBoard[leftDown] != 0) return true;
            }
        }

        int rightDown = col;
        for (int i = row + 1; i < board.length; i++) {
            int[] rowBoard = board[i];
            if (++rightDown <= rowBoard.length - 1) {
                if (rowBoard[rightDown] != 0) return true;
            }
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


