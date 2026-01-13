package com.wag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LongestSubarrayWithSumAtMostTest {

    // hook
    private static int longestSubarrayWithSumAtMost(int[] a, int k) {
        return LongestSubarrayWithSumAtMost.longestSubarrayWithSumAtMost(a, k); // rename as needed
    }

    @Test
    void example_2_1_3_1_1_k4_returns2() {
        assertEquals(2, longestSubarrayWithSumAtMost(new int[]{2, 1, 3, 1, 1}, 4));
    }

    @Test
    void wholeArrayFits_returnsN() {
        assertEquals(4, longestSubarrayWithSumAtMost(new int[]{1, 1, 1, 1}, 10));
    }

    @Test
    void kTooSmall_returns0() {
        assertEquals(0, longestSubarrayWithSumAtMost(new int[]{1, 2, 3}, 0));
    }

    @Test
    void singleElement_fits_returns1() {
        assertEquals(1, longestSubarrayWithSumAtMost(new int[]{5}, 5));
    }

    @Test
    void singleElement_tooLarge_returns0() {
        assertEquals(0, longestSubarrayWithSumAtMost(new int[]{6}, 5));
    }

    @Test
    void shrinkingNeeded_returnsCorrectMaxLen() {
        // best je [1,2,1] sum=4 len=3
        assertEquals(3, longestSubarrayWithSumAtMost(new int[]{1, 2, 3, 1, 2, 1}, 4));
    }

    @Test
    void emptyArray_returns0() {
        assertEquals(0, longestSubarrayWithSumAtMost(new int[]{}, 5));
    }

    @Test
    void nullArray_throws() {
        assertThrows(IllegalArgumentException.class, () -> longestSubarrayWithSumAtMost(null, 5));
    }

    @Test
    void negativeK_returns0() {
        assertEquals(0, longestSubarrayWithSumAtMost(new int[]{1, 1, 1}, -1));
    }
}
