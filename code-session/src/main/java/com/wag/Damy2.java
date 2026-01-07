package com.wag;

public class Damy2 {

    static int[] colForRow = {-1,-1,-1,-1,-1,-1,-1,-1};

    public static void main(String[] args) {
        int row=0;
        while (row >= 0 && row < 8) {
            int nextCol =  najdiDalsiStlpec(row, colForRow);
            if (nextCol != -1) {
                // našli sme bezpečný stĺpec – umiestnime dámu
                colForRow[row] = nextCol;
                // ideme do ďalšieho riadku
                row++;
            } else {
                // v tomto riadku už niet kam dať dámu – musíme sa vrátiť o riadok späť
                colForRow[row] = -1; // tento riadok je aktuálne bez dámy
                row--;               // backtracking
            }
        }
        if (row == 8) {
            // máme riešenie – vypíšeme šachovnicu
            printBoard(colForRow);
        } else {
            System.out.println("Žiadne riešenie sa nenašlo.");
        }

    }

    private static int najdiDalsiStlpec(int row, int[] colForRow) {
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
}
