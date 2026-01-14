package com.wag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BestWindowTest {

    @Test
    void shouldThrow_whenArrayIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                BestWindow.bestWindowAtLeastT(null, 3, 0)
        );
    }

    @Test
    void shouldThrow_whenArrayIsEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                BestWindow.bestWindowAtLeastT(new int[]{}, 1, 0)
        );
    }

    @Test
    void shouldThrow_whenWIsZero() {
        assertThrows(IllegalArgumentException.class, () ->
                BestWindow.bestWindowAtLeastT(new int[]{1, 2, 3}, 0, 2)
        );
    }

    @Test
    void shouldThrow_whenWIsNegative() {
        assertThrows(IllegalArgumentException.class, () ->
                BestWindow.bestWindowAtLeastT(new int[]{1, 2, 3}, -1, 2)
        );
    }

    @Test
    void shouldThrow_whenWGreaterThanLength() {
        assertThrows(IllegalArgumentException.class, () ->
                BestWindow.bestWindowAtLeastT(new int[]{1, 2, 3}, 4, 2)
        );
    }

    @Test
    void basicExample_shouldPickWindowWithMostGoodDays() {
        // t=3, good = >=3
        // windows w=3:
        // [1,3,5] -> 2 good (3,5)
        // [3,5,2] -> 2 good (3,5)
        // [5,2,4] -> 2 good (5,4)
        // remíza -> najskoršie => start 0
        var r = BestWindow.bestWindowAtLeastT(new int[]{1, 3, 5, 2, 4}, 3, 3);
        assertEquals(0, r.startIndex());
        assertEquals(2, r.goodCount());
    }

    @Test
    void tieBreak_shouldReturnEarliestStartIndex() {
        // t=10, w=2
        // [10,9] => 1 good
        // [9,10] => 1 good
        // earliest => 0
        var r = BestWindow.bestWindowAtLeastT(new int[]{10, 9, 10}, 2, 10);
        assertEquals(0, r.startIndex());
        assertEquals(1, r.goodCount());
    }

    @Test
    void worksWithNegativeNumbersAndThreshold() {
        // t=-2, good >= -2
        // a: [-5,-2,-1,-3]
        // w=2:
        // [-5,-2] => 1 good (-2)
        // [-2,-1] => 2 good
        // [-1,-3] => 1 good (-1)
        var r = BestWindow.bestWindowAtLeastT(new int[]{-5, -2, -1, -3}, 2, -2);
        assertEquals(1, r.startIndex());
        assertEquals(2, r.goodCount());
    }

    @Test
    void thresholdVeryHigh_shouldReturnZeroGoodDaysAndEarliest() {
        // t=100 => nikto nie je good
        // w=3 => všetky okná majú 0 => vráť 0
        var r = BestWindow.bestWindowAtLeastT(new int[]{1, 2, 3, 4}, 3, 100);
        assertEquals(0, r.startIndex());
        assertEquals(0, r.goodCount());
    }

    @Test
    void wEqualsOne_shouldPickFirstBestSingleElement() {
        // w=1, t=0, good >=0
        // a: [-1, 0, 5, 0]
        // goodCount je vždy 0 alebo 1, maximum 1; earliest good je index 1
        var r = BestWindow.bestWindowAtLeastT(new int[]{-1, 0, 5, 0}, 1, 0);
        assertEquals(1, r.startIndex());
        assertEquals(1, r.goodCount());
    }

    @Test
    void wEqualsLength_shouldEvaluateWholeArray() {
        // w=5, t=2 => good: [2,2,3] => 3
        var r = BestWindow.bestWindowAtLeastT(new int[]{-1, 2, 0, 2, 3}, 5, 2);
        assertEquals(0, r.startIndex());
        assertEquals(3, r.goodCount());
    }

    @Test
    void allGood_shouldReturnStartZero() {
        var r = BestWindow.bestWindowAtLeastT(new int[]{5, 6, 7, 8}, 2, 5);
        assertEquals(0, r.startIndex());
        assertEquals(2, r.goodCount());
    }

    @Test
    void noGood_shouldReturnStartZero() {
        var r = BestWindow.bestWindowAtLeastT(new int[]{-5, -6, -7, -8}, 2, 0);
        assertEquals(0, r.startIndex());
        assertEquals(0, r.goodCount());
    }
}
