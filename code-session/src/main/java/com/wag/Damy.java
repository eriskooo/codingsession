package com.wag;

public class Damy {

    @FunctionalInterface
    interface TriPredicate<A, B, C> {
        boolean test(A a, B b, C c);
    }

    static int[][] pole = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
    };

    static int[] colForRow = {-1, -1, -1, -1, -1, -1, -1, -1};

    static int solutions = 0; // sem budeme počítať počet riešení

    public static void main(String[] args) {
        int row = 0;

        while (row >= 0) {

            // 1) Ak máme umiestnené dámy vo všetkých 8 riadkoch, našli sme riešenie
            if (row == 8) {
                solutions++;

                // voliteľne: vypíš aktuálne riešenie
                printBoard(colForRow);
                System.out.println("Riešenie č. " + solutions);
                System.out.println();

                // backtracking: vrátime sa na posledný riadok a hľadáme ďalší stĺpec
                row--;
                continue;
            }

            // 2) Pokúsime sa nájsť ďalší bezpečný stĺpec v danom riadku
            int nextCol = hladajRexo(row, colForRow);

            if (nextCol != -1) {
                // našli sme bezpečný stĺpec – umiestnime dámu
                colForRow[row] = nextCol;
                // posunieme sa do ďalšieho riadku
                row++;
            } else {
                // v tomto riadku už niet žiadneho bezpečného stĺpca – resetneme ho
                colForRow[row] = -1;
                // a vrátime sa o riadok späť
                row--;
            }
        }

        System.out.println("Celkový počet riešení: " + solutions);
    }

    private static int hladajRexo(int row, int[] colForRow) {
        int startCol = colForRow[row] + 1;

        for (int col = startCol; col < 8; col++) {
            if (isSafe(row, col, colForRow)) {
                return col;
            }
        }
        return -1; // v tomto riadku už niet žiadneho bezpečného stĺpca
    }

    /**
     * Overí, či je bezpečné umiestniť dámu na (row, col),
     * ak v riadkoch 0..row-1 už dámu máme podľa colForRow.
     */
    private static boolean isSafe(int row, int col, int[] colForRow) {
        for (int r = 0; r < row; r++) {
            int c = colForRow[r];

            // rovnaký stĺpec
            if (c == col) {
                return false;
            }

            // diagonála: rozdiel riadkov == rozdiel stĺpcov
            if (Math.abs(row - r) == Math.abs(col - c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Pomocná metóda na vykreslenie riešenia.
     * 'Q' = dáma, '.' = prázdne pole.
     */
    private static void printBoard(int[] colForRow) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (colForRow[row] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
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

    static void kresli(int[][] pole) {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                System.out.print(pole[i][j] + "\t");
            }
            System.out.println();
        }
    }
}


