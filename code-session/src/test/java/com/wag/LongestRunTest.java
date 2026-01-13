package com.wag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LongestRunTest {

    /*
     * Minimal placeholders so the test compiles once you paste it next to your implementation.
     * Remove these if you already have them in production code.
     */
    private static LongestRun.Result longestRun(String s) {
        return LongestRun.longestRun(s); // adjust to your class name / method location
    }

    @Test
    void aaabbccccd_returnsC4Start5() {
        LongestRun.Result r = longestRun("aaabbccccd");
        assertEquals('c', r.ch());
        assertEquals(4, r.length());
        assertEquals(5, r.startIndex());
    }

    @Test
    void singleChar_returnsThatChar1Start0() {
        LongestRun.Result r = longestRun("a");
        assertEquals('a', r.ch());
        assertEquals(1, r.length());
        assertEquals(0, r.startIndex());
    }

    @Test
    void abbbcc_returnsB3Start1() {
        LongestRun.Result r = longestRun("abbbcc");
        assertEquals('b', r.ch());
        assertEquals(3, r.length());
        assertEquals(1, r.startIndex());
    }

    @Test
    void ab_tieBreakPicksFirstRun_returnsA1Start0() {
        LongestRun.Result r = longestRun("ab");
        assertEquals('a', r.ch());
        assertEquals(1, r.length());
        assertEquals(0, r.startIndex());
    }

    @Test
    void emptyString_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> longestRun(""));
    }
}
