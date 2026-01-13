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

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= a.length - w; i++) {
            int temp = 0;

            // spocitame vsetko pre okno
            for (int j = 0; j < w; j++) {
                temp = temp + a[i + j];
            }

            if (temp > max) {
                max = temp;
            }
        }

        System.out.println("max = " + max);
        return max;
    }

}
