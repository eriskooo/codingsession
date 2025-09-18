package com.wag.challenge3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramGrouperTest {

    private final AnagramGrouper grouper = new AnagramGrouper();

    @Test
    void testEmptyInput() {
        List<String> result = grouper.groupAnagrams("", Collections.emptyList());
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void testSingleWord() {
        List<String> result = grouper.groupAnagrams("hello", List.of("hello"));
        assertEquals(List.of("hello"), result);
    }

    @Test
    void testTypicalCase() {
        List<String> input = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        List<String> expected = List.of("ate", "eat", "tea");

        assertEquals(expected, grouper.groupAnagrams("eat", input));
    }

    @Test
    void testEmptyStrings() {
        List<String> input = Arrays.asList("", "");
        List<String> expected = List.of("", "");
        assertEquals(expected, grouper.groupAnagrams("", input));
    }

    @Test
    void testCaseSensitive() {
        List<String> input = Arrays.asList("Ab", "bA", "ba", "BA");
        List<String> expected = List.of("Ab", "bA");

        assertEquals(expected, grouper.groupAnagrams("Ab", input));
    }

}
