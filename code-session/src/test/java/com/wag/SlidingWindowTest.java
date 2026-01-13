package com.wag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SlidingWindowTest {

    // --- hook to your implementation ---
    private static int maxSumWindow(int[] a, int w) {
        return SlidingWindow.maxSumWindow(a, w); // rename class as needed
    }

    @Test
    void example_returns10() {
        int result = maxSumWindow(new int[]{1, 3, 2, 5, 1, 1, 7}, 3);
        assertEquals(10, result);
    }

    @Test
    void windowSize1_returnsMaxElement() {
        int result = maxSumWindow(new int[]{-5, 2, 0, 7, -1}, 1);
        assertEquals(7, result);
    }

    @Test
    void windowEqualsArrayLength_returnsTotalSum() {
        int result = maxSumWindow(new int[]{2, 3, 4}, 3);
        assertEquals(9, result);
    }

    @Test
    void allNegative_stillFindsMaximumSumWindow() {
        // windows of size 2: [-8], [-9], [-7] => max is -7
        int result = maxSumWindow(new int[]{-3, -5, -4, -3}, 2);
        assertEquals(-7, result);
    }

    @Test
    void multipleBestWindows_returnsBestSum() {
        // size 2 windows: [5,5]=10, [5,5]=10, [5,0]=5 => best 10
        int result = maxSumWindow(new int[]{5, 5, 5, 5, 0}, 2);
        assertEquals(10, result);
    }

    @Test
    void throwsOnNullArray() {
        assertThrows(IllegalArgumentException.class, () -> maxSumWindow(null, 3));
    }

    @Test
    void throwsOnNonPositiveWindow() {
        assertThrows(IllegalArgumentException.class, () -> maxSumWindow(new int[]{1, 2, 3}, 0));
        assertThrows(IllegalArgumentException.class, () -> maxSumWindow(new int[]{1, 2, 3}, -1));
    }

    @Test
    void throwsWhenWindowTooLarge() {
        assertThrows(IllegalArgumentException.class, () -> maxSumWindow(new int[]{1, 2}, 3));
    }
}