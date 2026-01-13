package com.wag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShortestSubarrayWithSumAtLeastTest {

    /*
     * Minimal placeholders so the test compiles once you paste it next to your implementation.
     * Adjust these to your actual class/method names and ShortestSubarrayWithSumAtLeast.Result type.
     */
    private static ShortestSubarrayWithSumAtLeast.Result shortestSubarrayWithSumAtLeast(int[] a, int k) {
        return ShortestSubarrayWithSumAtLeast.shortestSubarrayWithSumAtLeast(a, k); // <- rename to your class
    }

    @Test
    void example_2_3_1_2_4_3_k7_returnsStart4Len2() {
        ShortestSubarrayWithSumAtLeast.Result r = shortestSubarrayWithSumAtLeast(new int[]{2, 3, 1, 2, 4, 3}, 7);
        assertEquals(4, r.startIndex());
        assertEquals(2, r.length());
    }

    @Test
    void noSolution_returnsStartMinus1Len0() {
        ShortestSubarrayWithSumAtLeast.Result r = shortestSubarrayWithSumAtLeast(new int[]{1, 1, 1}, 5);
        assertEquals(-1, r.startIndex());
        assertEquals(0, r.length());
    }

    @Test
    void singleElement_exactMatch_returnsLen1() {
        ShortestSubarrayWithSumAtLeast.Result r = shortestSubarrayWithSumAtLeast(new int[]{7}, 7);
        assertEquals(0, r.startIndex());
        assertEquals(1, r.length());
    }

    @Test
    void singleElement_smallerThanK_returnsNoSolution() {
        ShortestSubarrayWithSumAtLeast.Result r = shortestSubarrayWithSumAtLeast(new int[]{6}, 7);
        assertEquals(-1, r.startIndex());
        assertEquals(0, r.length());
    }

    @Test
    void anySingleElementEqualOrAboveK_chooseShortestLen1() {
        ShortestSubarrayWithSumAtLeast.Result r = shortestSubarrayWithSumAtLeast(new int[]{1, 4, 4}, 4);
        // shortest is length 1; tie-break should pick earliest such index (1)
        assertEquals(1, r.startIndex());
        assertEquals(1, r.length());
    }

    @Test
    void tieOnLength_chooseEarliestStartIndex() {
        // Two solutions of length 2 that reach >= 6: [2,4] at 0 and [4,2] at 2
        ShortestSubarrayWithSumAtLeast.Result r = shortestSubarrayWithSumAtLeast(new int[]{2, 4, 1, 4, 2}, 6);
        assertEquals(0, r.startIndex());
        assertEquals(2, r.length());
    }

    @Test
    void solutionIsWholeArray_whenNeeded() {
        ShortestSubarrayWithSumAtLeast.Result r = shortestSubarrayWithSumAtLeast(new int[]{1, 1, 1, 1}, 4);
        assertEquals(0, r.startIndex());
        assertEquals(4, r.length());
    }

    @Test
    void emptyArray_returnsNoSolution() {
        ShortestSubarrayWithSumAtLeast.Result r = shortestSubarrayWithSumAtLeast(new int[]{}, 1);
        assertEquals(-1, r.startIndex());
        assertEquals(0, r.length());
    }

    @Test
    void nullArray_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> shortestSubarrayWithSumAtLeast(null, 1));
    }

    @Test
    void nonPositiveK_returnsImmediateShortestEmptyOrFirstElement_policyExample() {
        // If you choose policy: k <= 0 means "already satisfied" -> return start=0,len=0 (empty window)
        // If you prefer throwing, change this test accordingly.
        ShortestSubarrayWithSumAtLeast.Result r = shortestSubarrayWithSumAtLeast(new int[]{5, 1, 2}, 0);
        assertEquals(0, r.startIndex());
        assertEquals(0, r.length());
    }


}
