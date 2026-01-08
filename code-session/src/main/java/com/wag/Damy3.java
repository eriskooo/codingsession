package com.wag;

public class Damy3 {

    public static void main(String[] args) {
        int[] pole = {-1, -1, -1, -1, -1, -1, -1, -1};

        int total = 0;

        int row = 0;
        while (row >= 0) {
            int nextCol = najdiDalsiCol(row, pole);
            if (nextCol != -1) {
                pole[row] = nextCol;
                row++;
            } else {
                pole[row] = -1;
                row--;
            }

            if (row == 8) {
                total++;

                // voliteľne: vypíš aktuálne riešenie
                printBoard(pole);
                System.out.println("Riešenie č. " + total);
                System.out.println();

                // backtracking: vrátime sa na posledný riadok a hľadáme ďalší stĺpec
                row--;
                continue;
            }
        }

    }

    private static int najdiDalsiCol(int row, int[] pole) {
        int startCol = pole[row] + 1;
        for (int col = startCol; col < 8; col++) {
            if (jePouzitelny(col, row, pole)) {
                return col;
            }
        }
        return -1; // nemame ziadny dostupny stlpec
    }

    /**
     *
     * @param col  -> chcem umiestnit
     * @param row  -> chcem umiestnit
     * @param pole -> existujuce
     * @return
     */
    private static boolean jePouzitelny(int col, int row, int[] pole) {

        // Prejde všetky predchádzajúce riadky (tam už dámy sú) a porovná ich s kandidátom
        for (int kandidat = 0; kandidat < row; kandidat++) {
            int c = pole[kandidat];

            if (c == col) { // ten isty stlpec, odchod
                return false;
            }

            if (Math.abs(row - kandidat) == Math.abs(col - c)) return false;


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
