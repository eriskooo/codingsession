package com.wag;

import java.util.Arrays;

public class MaxEvenCountInWindow {

    /**
     * Napíš metódu, ktorá pre pole int[] a a veľkosť okna w vráti maximálny počet párnych čísel v ľubovoľnom súvislom úseku dĺžky w.
     *
     * @param a
     * @param w
     * @return
     */
    public static int maxEvenCountInWindow(int[] a, int w) {
        System.out.println("a : " + Arrays.toString(a));
        System.out.println("w : " + w);
        if (a == null || a.length < 1) {
            throw new IllegalArgumentException();
        }
        if (w <= 0 || w > a.length) {
            throw new IllegalArgumentException();
        }

        int sum = 0;
        for (int i = 0; i < w; i++) {
            if (isParneAleboNula(a[i])) {
                sum++;
            }
        }

        int best = sum;
        for (int i = w; i < a.length; i++) {
            if (isParneAleboNula(a[i - w])) {
                sum--;
            }
            if (isParneAleboNula(a[i])) {
                sum++;
            }
            if (sum > best) {
                best = sum;
            }
        }

        return best;
    }

    private static boolean isParneAleboNula(int a) {
        if (a == 0) {
            return true;
        }
        return a % 2 == 0;
    }
}
