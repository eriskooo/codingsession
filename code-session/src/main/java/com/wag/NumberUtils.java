package com.wag;

import java.util.Arrays;

public class NumberUtils {

    public int findSecondLargest(int[] ints) {
        if (ints == null || ints.length < 2) {
            throw new IllegalArgumentException();
        }

        Arrays.stream(ints).forEach(System.out::println);

        Integer max = null;
        Integer second = null;

        for (int i : ints) {
            if (max == null || i > max) {
                second = max;
                max = i;
            } else if (i < max && (second == null || i > second)) {
                second = i;
            }
        }

        if (second == null) {
            throw new IllegalArgumentException(); // no second max, all same
        }

        return second;
    }
}
