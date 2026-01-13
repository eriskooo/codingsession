package com.wag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShortestSubarrayWithSumAtLeast_VariableWindowTest {

    // --- hook to your implementation ---
    private static ShortestSubarrayWithSumAtLeast_VariableWindow.Result shortestSubarrayWithSumAtLeast(int[] a, int k) {
        return ShortestSubarrayWithSumAtLeast_VariableWindow.shortestSubarrayWithSumAtLeast(a, k); // rename class if needed
    }

    @Test
    void example_2_3_1_2_4_3_k7_returnsStart4Len2() {
        ShortestSubarrayWithSumAtLeast_VariableWindow.Result r = shortestSubarrayWithSumAtLeast(new int[]{2, 3, 1, 2, 4, 3}, 7);
        assertEquals(4, r.startIndex());
        assertEquals(2, r.length());
    }

    @Test
    void singleElement_exactMatch_returnsLen1() {
        ShortestSubarrayWithSumAtLeast_VariableWindow.Result r = shortestSubarrayWithSumAtLeast(new int[]{7}, 7);
        assertEquals(0, r.startIndex());
        assertEquals(1, r.length());
    }

    @Test
    void singleElement_smallerThanK_returnsNoSolution() {
        ShortestSubarrayWithSumAtLeast_VariableWindow.Result r = shortestSubarrayWithSumAtLeast(new int[]{6}, 7);
        assertEquals(-1, r.startIndex());
        assertEquals(0, r.length());
    }

    @Test
    void noSolution_returnsStartMinus1Len0() {
        ShortestSubarrayWithSumAtLeast_VariableWindow.Result r = shortestSubarrayWithSumAtLeast(new int[]{1, 1, 1}, 5);
        assertEquals(-1, r.startIndex());
        assertEquals(0, r.length());
    }

    @Test
    void shrinkingIsRequired_1_2_3_4_k6_returnsStart2Len2() {
        // správne: [3,4] => start=2,len=2 (nie [1,2,3] => len=3)
        ShortestSubarrayWithSumAtLeast_VariableWindow.Result r = shortestSubarrayWithSumAtLeast(new int[]{1, 2, 3, 4}, 6);
        assertEquals(2, r.startIndex());
        assertEquals(2, r.length());
    }

    @Test
    void findsShortestNotFirstFound_5_1_3_5_10_7_4_9_2_8_k15_returnsStart3Len2() {
        // známy príklad: shortest je [5,10] (index 3, len 2)
        ShortestSubarrayWithSumAtLeast_VariableWindow.Result r = shortestSubarrayWithSumAtLeast(new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}, 15);
        assertEquals(3, r.startIndex());
        assertEquals(2, r.length());
    }

    @Test
    void tieOnShortestLength_chooseEarliestStartIndex() {
        // k=6, okná dĺžky 2: [2,4] at 0 a [4,2] at 3 -> obe sum>=6, vyhrá start=0
        ShortestSubarrayWithSumAtLeast_VariableWindow.Result r = shortestSubarrayWithSumAtLeast(new int[]{2, 4, 1, 1, 4, 2}, 6);
        assertEquals(0, r.startIndex());
        assertEquals(2, r.length());
    }

    @Test
    void prefersLength1_whenAnyElementMeetsK() {
        // prvý prvok >= k -> najkratšie je len=1, start=0
        ShortestSubarrayWithSumAtLeast_VariableWindow.Result r = shortestSubarrayWithSumAtLeast(new int[]{8, 1, 1, 1}, 7);
        assertEquals(0, r.startIndex());
        assertEquals(1, r.length());
    }

    @Test
    void laterElementMeetsK_length1_shouldWin() {
        // prvý >=k nie je, ale 7 je -> len=1, start=2
        ShortestSubarrayWithSumAtLeast_VariableWindow.Result r = shortestSubarrayWithSumAtLeast(new int[]{1, 2, 7, 1}, 7);
        assertEquals(2, r.startIndex());
        assertEquals(1, r.length());
    }

    @Test
    void wholeArrayNeeded_returnsLenN() {
        ShortestSubarrayWithSumAtLeast_VariableWindow.Result r = shortestSubarrayWithSumAtLeast(new int[]{1, 1, 1, 1}, 4);
        assertEquals(0, r.startIndex());
        assertEquals(4, r.length());
    }

    @Test
    void emptyArray_returnsNoSolution() {
        ShortestSubarrayWithSumAtLeast_VariableWindow.Result r = shortestSubarrayWithSumAtLeast(new int[]{}, 1);
        assertEquals(-1, r.startIndex());
        assertEquals(0, r.length());
    }

    @Test
    void nullArray_throws() {
        assertThrows(IllegalArgumentException.class, () -> shortestSubarrayWithSumAtLeast(null, 1));
    }

    @Test
    void nonPositiveK_returnsStart0Len0_policy() {
        ShortestSubarrayWithSumAtLeast_VariableWindow.Result r1 = shortestSubarrayWithSumAtLeast(new int[]{5, 1, 2}, 0);
        assertEquals(0, r1.startIndex());
        assertEquals(0, r1.length());

        ShortestSubarrayWithSumAtLeast_VariableWindow.Result r2 = shortestSubarrayWithSumAtLeast(new int[]{5, 1, 2}, -10);
        assertEquals(0, r2.startIndex());
        assertEquals(0, r2.length());
    }

}
