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
        LongestRun.Result r = longestRun("aaabbccccdaa");
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

    @Test
    void earlierLongerRunOfSameChar_mustWin_notLastRun() {
        // Správne: najdlhší run 'a' je na začiatku (dĺžka 4), nie posledné "aa"
        LongestRun.Result r = LongestRun.longestRun("aaaaXaa");
        assertEquals('a', r.ch());
        assertEquals(4, r.length());
        assertEquals(0, r.startIndex());
    }

    @Test
    void earlierLongerRunOfSameChar_inMiddle_mustWin_notLastRun() {
        // Správne: "bbb" (index 2) je dlhšie než posledné "bb" (index 7)
        LongestRun.Result r = LongestRun.longestRun("aabbbXbb");
        assertEquals('b', r.ch());
        assertEquals(3, r.length());
        assertEquals(2, r.startIndex());
    }

    @Test
    void multipleRunsSameChar_keepMaximumOverAllRuns() {
        // Správne: najdlhší run 'a' je "aaaaa" (index 3), nie posledné "aa" (index 9)
        LongestRun.Result r = LongestRun.longestRun("bbbaaaaaXaa");
        assertEquals('a', r.ch());
        assertEquals(5, r.length());
        assertEquals(3, r.startIndex());
    }

    @Test
    void tieBreak_sameMaxLength_chooseEarlierStartIndex() {
        // Dva runy rovnakej max dĺžky 3: "aaa" (index 0) a "bbb" (index 4)
        // Správne má vyhrať skorší: 'a', 3, 0
        LongestRun.Result r = LongestRun.longestRun("aaaXbbb");
        assertEquals('a', r.ch());
        assertEquals(3, r.length());
        assertEquals(0, r.startIndex());
    }

    @Test
    void tieBreak_withMoreCandidates_chooseEarliestAmongMax() {
        // Max dĺžka = 2, kandidáti: "aa"(0), "bb"(2), "cc"(4)
        // Správne vyhrá prvý: 'a', 2, 0
        LongestRun.Result r = LongestRun.longestRun("aabbcc");
        assertEquals('a', r.ch());
        assertEquals(2, r.length());
        assertEquals(0, r.startIndex());
    }
}
