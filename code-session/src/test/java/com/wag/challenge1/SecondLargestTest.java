package com.wag.challenge1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SecondLargestTest {
    @Test
    public void testFindSecondLargestWithValidInput() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        assertEquals(4, SecondLargest.findSecondLargest(integers));
    }

    @Test
    public void testFindSecondLargestWithDuplicates() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 5, 5);
        assertEquals(4, SecondLargest.findSecondLargest(integers));
    }

    @Test
    public void testFindSecondLargestWithTwoElementArray() {
        List<Integer> integers = List.of(5, 6);
        assertEquals(5, SecondLargest.findSecondLargest(integers));
    }

    @Test
    public void testFindSecondLargestWithTwoElementArray02() {
        List<Integer> integers = List.of(6, 5);
        assertEquals(5, SecondLargest.findSecondLargest(integers));
    }

    @Test
    public void testFindSecondLargestWithMoreElementsInTheArray() {
        List<Integer> integers = List.of(6, 3, 2, 5, 4);
        assertEquals(5, SecondLargest.findSecondLargest(integers));
    }

    @Test
    public void testFindSecondLargestWithNegativeElementsInTheArray() {
        List<Integer> integers = List.of(-1, 0, 2, 5, 4);
        assertEquals(4, SecondLargest.findSecondLargest(integers));
    }

    @Test
    public void testFindSecondLargestWithNegativeElementsInTheArray2() {
        List<Integer> integers = List.of(-1, 0, 2, 5, -3);
        assertEquals(2, SecondLargest.findSecondLargest(integers));
    }

    // ---------- DISTINCT VERSION TESTS ----------

    @Test
    void distinct_nullList_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> SecondLargest.findSecondLargest(null));
    }

    @Test
    void distinct_lessThanTwoElements_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> SecondLargest.findSecondLargest(List.of()));
        assertThrows(IllegalArgumentException.class,
                () -> SecondLargest.findSecondLargest(List.of(1)));
    }

    @Test
    void distinct_listContainsNull_throws() {
        assertThrows(NullPointerException.class,
                () -> SecondLargest.findSecondLargest(List.of(1, null, 2)));
    }

    @Test
    void distinct_twoElements_increasing_ok() {
        assertEquals(1, SecondLargest.findSecondLargest(List.of(2, 1)));
    }

    @Test
    void distinct_twoElements_decreasing_ok() {
        assertEquals(1, SecondLargest.findSecondLargest(List.of(1, 2)));
    }

    @Test
    void distinct_duplicateMax_returnsNextDistinct() {
        // second-largest distinct is 1 (not 5)
        assertEquals(1, SecondLargest.findSecondLargest(List.of(5, 5, 1)));
        assertEquals(1, SecondLargest.findSecondLargest(List.of(5, 1, 5)));
    }

    @Test
    void distinct_allSame_throwsBecauseNoSecondDistinct() {
        assertThrows(IllegalArgumentException.class,
                () -> SecondLargest.findSecondLargest(List.of(7, 7)));
        assertThrows(IllegalArgumentException.class,
                () -> SecondLargest.findSecondLargest(List.of(7, 7, 7, 7)));
    }

    @Test
    void distinct_negativeNumbers_ok() {
        // distinct order: -1 > -2 > -3, so second is -2
        assertEquals(-2, SecondLargest.findSecondLargest(List.of(-3, -1, -2)));
    }

    @Test
    void distinct_withIntegerExtremes_ok() {
        assertEquals(Integer.MIN_VALUE,
                SecondLargest.findSecondLargest(List.of(Integer.MAX_VALUE, Integer.MIN_VALUE)));

        assertEquals(0,
                SecondLargest.findSecondLargest(List.of(Integer.MIN_VALUE, 0, Integer.MAX_VALUE)));
    }

    @Test
    void distinct_secondDistinctLateInList_ok() {
        assertEquals(9, SecondLargest.findSecondLargest(List.of(10, 1, 1, 1, 9)));
    }


    // ---------- ALLOW DUPLICATES VERSION TESTS ----------

    @Test
    void dup_nullList_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> SecondLargest.findSecondLargest(null));
    }

    @Test
    void dup_lessThanTwoElements_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> SecondLargest.findSecondLargest(List.of()));
        assertThrows(IllegalArgumentException.class,
                () -> SecondLargest.findSecondLargest(List.of(1)));
    }

    @Test
    void dup_listContainsNull_throws() {
        assertThrows(NullPointerException.class,
                () -> SecondLargest.findSecondLargest(List.of(1, null, 2)));
    }

    @Test
    void dup_twoElements_ok() {
        assertEquals(1, SecondLargest.findSecondLargest(List.of(2, 1)));
        assertEquals(1, SecondLargest.findSecondLargest(List.of(1, 2)));
    }

//    @Test
//    void dup_duplicateMax_returnsMax() {
//        // because duplicates count: sorted desc would be [5,5,1], second is 5
//        assertEquals(5, SecondLargest.findSecondLargest(List.of(5, 5, 1)));
//        assertEquals(5, SecondLargest.findSecondLargest(List.of(5, 1, 5)));
//    }

//    @Test
//    void dup_allSame_returnsSame() {
//        assertEquals(7, SecondLargest.findSecondLargest(List.of(7, 7)));
//        assertEquals(7, SecondLargest.findSecondLargest(List.of(7, 7, 7, 7)));
//    }

    @Test
    void dup_negativeNumbers_ok() {
        // sorted desc: [-1, -2, -3], second is -2
        assertEquals(-2, SecondLargest.findSecondLargest(List.of(-3, -1, -2)));
    }

    @Test
    void dup_withIntegerExtremes_ok() {
        assertEquals(Integer.MIN_VALUE,
                SecondLargest.findSecondLargest(List.of(Integer.MAX_VALUE, Integer.MIN_VALUE)));

        assertEquals(0,
                SecondLargest.findSecondLargest(List.of(Integer.MIN_VALUE, 0, Integer.MAX_VALUE)));
    }

    @Test
    void dup_secondComputedFromEarlierFirst_ok() {
        assertEquals(9, SecondLargest.findSecondLargest(List.of(10, 9, 1, 2, 3)));
    }
}
