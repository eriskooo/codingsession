package com.wag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MaxEvenCountInWindowTest {

    // --- hook to your implementation ---
    private static int maxEvenCountInWindow(int[] a, int w) {
        return MaxEvenCountInWindow.maxEvenCountInWindow(a, w); // rename class as needed
    }

    @Test
    void example_1_2_4_5_6_w3_returns2() {
        assertEquals(2, maxEvenCountInWindow(new int[]{1, 2, 4, 5, 6}, 3));
    }

    @Test
    void allOdd_returns0() {
        assertEquals(0, maxEvenCountInWindow(new int[]{1, 3, 5, 7, 9}, 3));
    }

    @Test
    void allEven_returnsWindowSize() {
        assertEquals(4, maxEvenCountInWindow(new int[]{2, 4, 6, 8, 10}, 4));
    }

    @Test
    void windowSize1_returns1IfAnyEvenElse0() {
        assertEquals(1, maxEvenCountInWindow(new int[]{1, 2, 3}, 1));
        assertEquals(0, maxEvenCountInWindow(new int[]{1, 3, 5}, 1));
    }

    @Test
    void windowEqualsArrayLength_countsAll() {
        assertEquals(3, maxEvenCountInWindow(new int[]{2, 1, 4, 3, 6}, 5));
    }

    @Test
    void includesZero_zeroIsEven() {
        assertEquals(1, maxEvenCountInWindow(new int[]{0, 1, 2}, 2)); // [0,1] => 1, [1,2] => 1, best=1
        assertEquals(2, maxEvenCountInWindow(new int[]{0, 2, 1}, 2)); // [0,2] => 2 best=2
    }

    @Test
    void negativeNumbers_workAsExpected() {
        assertEquals(2, maxEvenCountInWindow(new int[]{-2, -3, -4, -5}, 3)); // [-2,-3,-4] => 2
    }

    @Test
    void throwsOnNullArray() {
        assertThrows(IllegalArgumentException.class, () -> maxEvenCountInWindow(null, 2));
    }

    @Test
    void throwsOnInvalidWindow() {
        assertThrows(IllegalArgumentException.class, () -> maxEvenCountInWindow(new int[]{1, 2, 3}, 0));
        assertThrows(IllegalArgumentException.class, () -> maxEvenCountInWindow(new int[]{1, 2, 3}, -1));
        assertThrows(IllegalArgumentException.class, () -> maxEvenCountInWindow(new int[]{1, 2, 3}, 4));
    }

    @Test
    void emptyArray_withAnyPositiveWindow_throws() {
        assertThrows(IllegalArgumentException.class, () -> maxEvenCountInWindow(new int[]{}, 1));
    }
}
