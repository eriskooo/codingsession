package com.wag;

import java.util.Arrays;

public class BestWindow {

    /**
     * Máš pole denných zmien int[] a (môžu byť aj záporné). Deň je dobrý, ak a[i] >= t (prahová hodnota).
     * Napíš metódu ktorá nájde súvislé okno dĺžky w s maximálnym počtom dobrých dní.
     *
     * @param a pole denných zmien
     * @param w nájde súvislé okno dĺžky
     * @param t prahová hodnota
     * @return
     */
    public static Result bestWindowAtLeastT(int[] a, int w, int t) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException();
        }

        if (w < 1 || w > a.length) {
            throw new IllegalArgumentException();
        }

        System.out.println("a = " + Arrays.toString(a));
        System.out.println("w = " + w);
        System.out.println("t = " + t);

        int sum = 0;
        int startIndex = 0;

        for (int i = 0; i < w; i++) {
            if (a[i] >= t) {
                sum++;
            }
        }

        int best = sum;

        for (int i = w; i < a.length; i++) {
            int left = a[i - w];
            int right = a[i];
            if (left >= t) {
                --sum;
            }
            if (right >= t) {
                ++sum;
            }

            if (sum > best) {
                startIndex = i - w + 1;
                best = sum;
            }
        }

        return new Result(startIndex, best);
    }

    public record Result(int startIndex, int goodCount) {
    }

}
