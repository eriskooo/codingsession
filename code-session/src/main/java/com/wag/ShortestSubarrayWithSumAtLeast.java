package com.wag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Napíš metódu, ktorá pre pole kladných celých čísel nájde najkratší súvislý úsek (subarray), ktorého súčet je ≥ K.
 * <p>
 * Ak taký úsek neexistuje, vráť Result s length = 0 a startIndex = -1 (alebo Optional<Result> – ale nech je to konzistentné).
 */
public class ShortestSubarrayWithSumAtLeast {

    public static Result shortestSubarrayWithSumAtLeast(int[] a, int k) {
        if (a == null) {
            throw new IllegalArgumentException();
        }

        if (a.length == 0) {
            return new Result(-1, 0);
        }

        if (k <= 0) {
            return new Result(0, 0);
        }

        System.out.println("a = " + Arrays.toString(a));
        System.out.println("k = " + k);

        int startIndex = 0;
        int length = 0;
        int temp = 0;

        List<Result> outputs = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            if (temp == 0) {
                startIndex = i;
            }
            temp = temp + a[i];
            length++;

            if (temp >= k) {
                outputs.add(new Result(startIndex, length));
                if (length > 1) {
                    i = startIndex;
                }
                temp = 0;
                length = 0;
            }
        }

        if (outputs.isEmpty()) {
            return new Result(-1, 0);
        }

        System.out.println("*** out ***");

        Result shortest = null;
        for (Result r : outputs) {
            System.out.println(r);
            if (shortest == null) {
                shortest = r;
            } else if (r.length < shortest.length) {
                shortest = r;
            }
        }


        return shortest;
    }

    public record Result(int startIndex, int length) {
    }
}
