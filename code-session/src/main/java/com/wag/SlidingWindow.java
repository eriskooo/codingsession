package com.wag;

import java.util.Arrays;

public class SlidingWindow {

    /**
     * Máš pole int[] a a číslo w (veľkosť okna). Nájdite maximálny súčet ľubovoľných w po sebe idúcich prvkov.
     *
     * @param a
     * @param w
     * @return
     */
    static int maxSumWindow(int[] a, int w) {
        if (a == null || a.length < w) {
            throw new IllegalArgumentException();
        }

        if (w < 1) {
            throw new IllegalArgumentException();
        }

        System.out.println("a = " + Arrays.toString(a));
        System.out.println("w = " + w);

        int sum = 0;
        for (int i = 0; i < w; i++) {
            sum += a[i];
        }

        System.out.println("initial : " + sum);

        int best = sum;
        for (int i = w; i < a.length; i++) {
            int left = a[i - w];
            int right = a[i];
            sum = sum - left + right;
            if (sum > best) {
                best = sum;
            }
        }

        System.out.println("best = " + best);
        return best;
    }

}
