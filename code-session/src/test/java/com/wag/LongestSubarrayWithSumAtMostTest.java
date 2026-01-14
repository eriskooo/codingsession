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

    /**
     * Referenčná implementácia O(n^2) – vhodná do testov ako oracle.
     * Funguje pre ľubovoľné int (vrátane záporných).
     */
    private static int bruteForceLongestSubarrayWithSumAtMost(int[] a, int k) {
        int max = 0;
        for (int start = 0; start < a.length; start++) {
            int sum = 0;
            for (int end = start; end < a.length; end++) {
                sum += a[end];
                if (sum <= k) {
                    max = Math.max(max, end - start + 1);
                }
            }
        }
        return max;
    }

    @Test
    void nullArray_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> LongestSubarrayWithSumAtMost.longestSubarrayWithSumAtMost(null, 10));
    }

    @Test
    void emptyArray_returnsZero() {
        assertEquals(0, LongestSubarrayWithSumAtMost.longestSubarrayWithSumAtMost(new int[]{}, 10));
    }

    @Test
    void notLastWindowButLongest_shouldReturnMaxLen() {
        // Najdlhšie okno je [1,2,3] (suma 6), nie posledné okno [4]
        int[] a = {1, 2, 3, 4};
        int k = 6;

        assertEquals(3, LongestSubarrayWithSumAtMost.longestSubarrayWithSumAtMost(a, k),
                "Should return the length of the longest valid subarray, not the last window.");
    }

    @Test
    void allElementsFit_returnsWholeLength() {
        int[] a = {1, 1, 1};
        int k = 10;
        assertEquals(3, LongestSubarrayWithSumAtMost.longestSubarrayWithSumAtMost(a, k));
    }

    @Test
    void kZero_withZeros_shouldCountZeros() {
        int[] a = {0, 0, 0};
        int k = 0;
        assertEquals(3, LongestSubarrayWithSumAtMost.longestSubarrayWithSumAtMost(a, k));
    }

    @Test
    void negativeNumbers_shouldWorkForGeneralDefinition_example1() {
        // Správna odpoveď je 3: suma celého poľa je 1 <= 5
        int[] a = {5, -10, 6};
        int k = 5;

        int expected = bruteForceLongestSubarrayWithSumAtMost(a, k);
        assertEquals(expected, LongestSubarrayWithSumAtMost.longestSubarrayWithSumAtMost(a, k),
                "If negatives are allowed, sliding-window approach is not generally correct.");
    }

    @Test
    void negativeNumbers_kNegative_shouldNotAutoReturnZero() {
        // Aj keď k < 0, stále môže existovať validné okno (napr. [-5] <= -1)
        int[] a = {-5};
        int k = -1;

        int expected = bruteForceLongestSubarrayWithSumAtMost(a, k); // expected = 1
        assertEquals(expected, LongestSubarrayWithSumAtMost.longestSubarrayWithSumAtMost(a, k),
                "For arrays with negatives, returning 0 for k < 0 is not correct.");
    }

    @Test
    void mixedNumbers_randomLike_shouldMatchBruteForce() {
        int[] a = {2, -1, 2, -3, 4, -2, 1};
        int k = 3;

        int expected = bruteForceLongestSubarrayWithSumAtMost(a, k);
        assertEquals(expected, LongestSubarrayWithSumAtMost.longestSubarrayWithSumAtMost(a, k));
    }
}
