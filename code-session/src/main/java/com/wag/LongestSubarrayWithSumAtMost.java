package com.wag;

import java.util.Arrays;

public class LongestSubarrayWithSumAtMost {


    /**
     * Máš pole kladných čísel int[] a a limit k. Nájdeš maximálnu dĺžku súvislého úseku, ktorého súčet je ≤ k.
     *
     * @param a
     * @param k
     * @return
     */
    public static int longestSubarrayWithSumAtMost(int[] a, int k) {
        if (a == null) {
            throw new IllegalArgumentException();
        }
        if (a.length == 0) {
            return 0;
        }
//        if (k == 0) {
//            return 0;
//        }

        System.out.println("a : " + Arrays.toString(a));
        System.out.println("k : " + k);

        int temp = 0;
        int start = 0;
        int lenght = 0;
        int max = 0;

        for (int i = 0; i < a.length; i++) {
            temp += a[i];
            ++lenght;
            if (temp <= k) {
                if (lenght > max) {
                    max = lenght;
                }
                continue;
            }
            while (temp > k) {
                temp = temp - a[start];
                start++;
                lenght--;
                if (start == a.length) {
                    return 0;
                }
            }
        }

        return max;
    }
}
