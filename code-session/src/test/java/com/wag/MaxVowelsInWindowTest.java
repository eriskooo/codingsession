package com.wag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MaxVowelsInWindowTest {

    // --- hook to your implementation ---
    private static int maxVowelsInWindow(String s, int w) {
        return MaxVowelsInWindow.maxVowelsInWindow(s, w); // rename class as needed
    }

    @Test
    void example_abciiidef_w3_returns3() {
        assertEquals(3, maxVowelsInWindow("abciiidef", 3));
    }

    @Test
    void allConsonants_returns0() {
        assertEquals(0, maxVowelsInWindow("bcdfg", 2));
    }

    @Test
    void allVowels_returnsWindowSize() {
        assertEquals(4, maxVowelsInWindow("aeiou", 4));
    }

    @Test
    void windowSize1_returns1IfAnyVowelElse0() {
        assertEquals(1, maxVowelsInWindow("bA", 1)); // 'A' is vowel (case-insensitive)
        assertEquals(0, maxVowelsInWindow("bc", 1));
    }

    @Test
    void windowEqualsStringLength_countsAll() {
        assertEquals(2, maxVowelsInWindow("hello", 5)); // e,o
    }

    @Test
    void mixedCase_isCaseInsensitive() {
        assertEquals(2, maxVowelsInWindow("aEbc", 2)); // "aE" => 2
    }

    @Test
    void emptyString_throws() {
        assertThrows(IllegalArgumentException.class, () -> maxVowelsInWindow("", 1));
    }

    @Test
    void nullString_throws() {
        assertThrows(IllegalArgumentException.class, () -> maxVowelsInWindow(null, 1));
    }

    @Test
    void invalidWindow_throws() {
        assertThrows(IllegalArgumentException.class, () -> maxVowelsInWindow("abc", 0));
        assertThrows(IllegalArgumentException.class, () -> maxVowelsInWindow("abc", -1));
        assertThrows(IllegalArgumentException.class, () -> maxVowelsInWindow("abc", 4)); // w > length
    }
}
