package com.wag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubStringTest {

    @Test
    void subStringTest() {
        assertEquals(0, SubString.lengthOfLongestUniqueSubstring(""));
        assertEquals(1, SubString.lengthOfLongestUniqueSubstring("aaaa"));
        assertEquals(3, SubString.lengthOfLongestUniqueSubstring("abcabcbb"));
        assertEquals(3, SubString.lengthOfLongestUniqueSubstring("pwwkew"));
        assertEquals(3, SubString.lengthOfLongestUniqueSubstring("dvdf"));
    }

    @Test
    void hasAllDifferent() {
        assertTrue(SubString.hasAllDifferent("abc"));
        assertFalse(SubString.hasAllDifferent("abca"));
    }
}