package com.wag;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MergeIntervalsTest {

    static Stream<org.junit.jupiter.params.provider.Arguments> cases() {
        return Stream.of(
                arguments(
                        listOf(new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}),
                        listOf(new int[]{1, 6}, new int[]{8, 10}, new int[]{15, 18})
                ),
                arguments(
                        listOf(new int[]{1, 4}, new int[]{4, 5}), // touching -> merge
                        listOf(new int[]{1, 5})
                ),
                arguments(
                        listOf(new int[]{5, 5}, new int[]{1, 2}), // unsorted input
                        listOf(new int[]{1, 2}, new int[]{5, 5})
                ),
                arguments(
                        listOf(new int[]{1, 10}, new int[]{2, 3}, new int[]{4, 8}), // contained intervals
                        listOf(new int[]{1, 10})
                ),
                arguments(
                        listOf(new int[]{-10, -1}, new int[]{-5, 0}), // negatives
                        listOf(new int[]{-10, 0})
                ),
                arguments(
                        listOf(), // empty
                        listOf()
                ),
                arguments(
                        null, // null input -> empty output
                        listOf()
                )
        );
    }

    private static List<int[]> listOf(int[]... intervals) {
        return intervals == null ? List.of() : List.of(intervals);
    }

    private static List<int[]> copyIntervals(List<int[]> src) {
        if (src == null) return null;
        List<int[]> copy = new ArrayList<>(src.size());
        for (int[] it : src) {
            copy.add(it == null ? null : new int[]{it[0], it[1]});
        }
        return copy;
    }

    private static void assertIntervalsEquals(List<int[]> expected, List<int[]> actual) {
        assertNotNull(actual, "actual list must not be null");
        if (expected == null) {
            fail("expected should not be null in these tests");
        }
        assertEquals(expected.size(), actual.size(), "size mismatch");
        for (int i = 0; i < expected.size(); i++) {
            assertArrayEquals(expected.get(i), actual.get(i), "interval mismatch at index " + i);
        }
    }

    @ParameterizedTest(name = "{index}: input={0}")
    @MethodSource("cases")
    void shouldMergeIntervals(List<int[]> input, List<int[]> expected) {
        List<int[]> result = MergeIntervals.mergeIntervals(input);
        assertIntervalsEquals(expected, result);
    }

    @Test
    @DisplayName("Should not modify the original list order/contents (defensive copy behavior)")
    void shouldNotModifyInputList() {
        List<int[]> input = new ArrayList<>();
        input.add(new int[]{2, 3});
        input.add(new int[]{1, 2});

        // snapshot deep-ish (copy arrays)
        List<int[]> snapshot = copyIntervals(input);

        MergeIntervals.mergeIntervals(input);

        assertIntervalsEquals(snapshot, input);
    }

    @Test
    @DisplayName("Invalid interval array length -> IllegalArgumentException")
    void invalidIntervalLengthShouldThrow() {
        List<int[]> input = List.of(new int[]{1}, new int[]{2, 3});
        assertThrows(IllegalArgumentException.class, () -> MergeIntervals.mergeIntervals(input));
    }

    @Test
    @DisplayName("Start > end -> IllegalArgumentException")
    void startGreaterThanEndShouldThrow() {
        List<int[]> input = List.of(new int[]{5, 4});
        assertThrows(IllegalArgumentException.class, () -> MergeIntervals.mergeIntervals(input));
    }
}
