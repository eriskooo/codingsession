package com.wag;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberUtilsTest {

    private final NumberUtils numberUtils = new NumberUtils();

    @Test
    @DisplayName("Should return second largest for basic ascending array")
    void shouldReturnSecondLargestForBasicArray() {
        int result = numberUtils.findSecondLargest(new int[]{1, 2, 3, 4});
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Should return second largest when array is unordered")
    void shouldReturnSecondLargestForUnorderedArray() {
        int result = numberUtils.findSecondLargest(new int[]{10, 3, 8, 15, 6});
        assertEquals(10, result);
    }

    @Test
    @DisplayName("Should ignore duplicates of the largest number")
    void shouldIgnoreDuplicatesOfLargest() {
        int result = numberUtils.findSecondLargest(new int[]{7, 7, 5});
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Should ignore duplicates in general")
    void shouldIgnoreDuplicatesInGeneral() {
        int result = numberUtils.findSecondLargest(new int[]{4, 1, 4, 3, 3});
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Should work with negative numbers")
    void shouldWorkWithNegativeNumbers() {
        int result = numberUtils.findSecondLargest(new int[]{-10, -3, -20});
        assertEquals(-10, result);
    }

    @Test
    @DisplayName("Should work with mix of negative and positive numbers")
    void shouldWorkWithMixedNumbers() {
        int result = numberUtils.findSecondLargest(new int[]{-5, 100, 2, 1000, 7});
        assertEquals(100, result);
    }

    @Test
    @DisplayName("Should throw exception for null array")
    void shouldThrowExceptionForNullArray() {
        assertThrows(IllegalArgumentException.class,
                () -> numberUtils.findSecondLargest(null));
    }

    @Test
    @DisplayName("Should throw exception for empty array")
    void shouldThrowExceptionForEmptyArray() {
        assertThrows(IllegalArgumentException.class,
                () -> numberUtils.findSecondLargest(new int[]{}));
    }

    @Test
    @DisplayName("Should throw exception for array with one element")
    void shouldThrowExceptionForSingleElementArray() {
        assertThrows(IllegalArgumentException.class,
                () -> numberUtils.findSecondLargest(new int[]{42}));
    }

    @Test
    @DisplayName("Should throw exception when all numbers are the same")
    void shouldThrowExceptionWhenAllNumbersAreSame() {
        assertThrows(IllegalArgumentException.class,
                () -> numberUtils.findSecondLargest(new int[]{5, 5, 5}));
    }

    @Test
    @DisplayName("Should throw exception when only one distinct number exists")
    void shouldThrowExceptionWhenOnlyOneDistinctNumberExists() {
        assertThrows(IllegalArgumentException.class,
                () -> numberUtils.findSecondLargest(new int[]{9, 9, 9, 9, 9}));
    }
}