package com.wag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GptUloha1Test {

    //s="ADOBECODEBANC", t="ABC" → "BANC"
    @Test
    public void test1() {
        assertEquals("BANC", GptUloha1.doJob("ADOBECODEBANC", "ABC"));
    }

    //s="ADOBECODEBANC", t="ABC" → "BANC"
    @Test
    public void test2() {
        assertEquals("", GptUloha1.doJob("a", "aa"));
    }

    //s="ADOBECODEBANC", t="ABC" → "BANC"
    @Test
    public void test3() {
        assertEquals("abc", GptUloha1.doJob("aaabcbc", "abc"));
    }

}