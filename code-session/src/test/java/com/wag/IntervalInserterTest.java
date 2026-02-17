package com.wag;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntervalInserterTest {

    private static List<int[]> list(int[][] arr) {
        List<int[]> out = new ArrayList<>();
        for (int[] a : arr) out.add(a);
        return out;
    }

    private static void assertIntervals(List<int[]> actual, int[][] expected) {
        assertNotNull(actual);
        assertEquals(expected.length, actual.size(), "size mismatch");

        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual.get(i), "mismatch at index " + i);
        }
    }

    @Test
    void insertsIntoEmptyList() {
        List<int[]> input = List.of();
        int[] newInterval = new int[]{2, 4};

        List<int[]> out = IntervalInserter.insertInterval(input, newInterval);

        assertIntervals(out, new int[][]{{2, 4}});
    }

    @Test
    void noOverlap_insertBeforeAll() {
        List<int[]> input = list(new int[][]{{5, 7}, {8, 10}});
        int[] newInterval = new int[]{1, 2};

        List<int[]> out = IntervalInserter.insertInterval(input, newInterval);

        assertIntervals(out, new int[][]{{1, 2}, {5, 7}, {8, 10}});
    }

    @Test
    void noOverlap_insertAfterAll() {
        List<int[]> input = list(new int[][]{{1, 2}, {5, 7}});
        int[] newInterval = new int[]{10, 12};

        List<int[]> out = IntervalInserter.insertInterval(input, newInterval);

        assertIntervals(out, new int[][]{{1, 2}, {5, 7}, {10, 12}});
    }

    @Test
    void overlapWithOneInterval() {
        List<int[]> input = list(new int[][]{{1, 3}, {6, 9}});
        int[] newInterval = new int[]{2, 5};

        List<int[]> out = IntervalInserter.insertInterval(input, newInterval);

        assertIntervals(out, new int[][]{{1, 5}, {6, 9}});
    }

    @Test
    void overlapWithMultipleIntervals() {
        List<int[]> input = list(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}});
        int[] newInterval = new int[]{4, 8};

        List<int[]> out = IntervalInserter.insertInterval(input, newInterval);

        assertIntervals(out, new int[][]{{1, 2}, {3, 10}, {12, 16}});
    }

    @Test
    void newIntervalCoversAll() {
        List<int[]> input = list(new int[][]{{2, 3}, {5, 6}, {8, 9}});
        int[] newInterval = new int[]{1, 10};

        List<int[]> out = IntervalInserter.insertInterval(input, newInterval);

        assertIntervals(out, new int[][]{{1, 10}});
    }

    @Test
    void newIntervalInsideExisting_intervalUnchanged() {
        List<int[]> input = list(new int[][]{{1, 10}});
        int[] newInterval = new int[]{3, 5};

        List<int[]> out = IntervalInserter.insertInterval(input, newInterval);

        // (1,10) už pokrýva (3,5), výsledok zostáva (1,10)
        assertIntervals(out, new int[][]{{1, 10}});
    }

    // ---------- helpers ----------

    @Test
    void touchingBorders_mergeIfClosedIntervals() {
        // berieme intervaly ako uzavreté [start,end], takže (1,2) a (2,3) sa majú zmergeovať
        List<int[]> input = list(new int[][]{{1, 2}, {5, 6}});
        int[] newInterval = new int[]{2, 5};

        List<int[]> out = IntervalInserter.insertInterval(input, newInterval);

        assertIntervals(out, new int[][]{{1, 6}});
    }

    @Test
    void invalidNewInterval_throws() {
        List<int[]> input = list(new int[][]{{1, 2}});
        int[] newInterval = new int[]{5, 3}; // start > end

        assertThrows(IllegalArgumentException.class,
                () -> IntervalInserter.insertInterval(input, newInterval));
    }
}
