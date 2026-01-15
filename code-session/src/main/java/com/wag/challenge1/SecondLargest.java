package com.wag.challenge1;

import java.util.List;

public class SecondLargest {

    /**
     * You are given a list of integers, and you need to implement a function that returns the second-largest number in the list.
     * Validate that list has at least two elements.
     * <ul>
     * <li>You may assume that the input list contains only integers.</li>
     * <li>You may not use any built-in sorting functions.</li>
     * <li>You should aim for an efficient algorithm that runs in O(n) time complexity..</li>
     * </ul>
     */
    public static int findSecondLargest(List<Integer> integers) {
        if (integers == null || integers.size() < 2) {
            throw new IllegalArgumentException();
        }

        Integer m1 = null;
        Integer m2 = null;

        for (int i = 0; i < integers.size(); i++) {
            Integer current = integers.get(i);

            if (m1 == null || current > m1) {
                m2 = m1;
                m1 = current;
            } else if (m2 == null || m1 > current && m2 < current) {
                if (current != m1) { // duplikat
                    m2 = current;
                }
            }
        }

        if (m2 == null) { // rovnake
            throw new IllegalArgumentException();
        }


        return m2;
    }
}
