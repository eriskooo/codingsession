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
        List<List<String>> result = grouper.groupAnagrams(Collections.emptyList());
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void testSingleWord() {
        List<List<String>> result = grouper.groupAnagrams(List.of("hello"));
        assertEquals(List.of(List.of("hello")), result);
    }

    @Test
    void testTypicalCase() {
        List<String> input = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        List<List<String>> expected = List.of(
                List.of("ate", "eat", "tea"),
                List.of("bat"),
                List.of("nat", "tan")
        );
        assertEquals(expected, grouper.groupAnagrams(input));
    }

    @Test
    void testEmptyStrings() {
        List<String> input = Arrays.asList("", "");
        List<List<String>> expected = List.of(
                List.of("", "")
        );
        assertEquals(expected, grouper.groupAnagrams(input));
    }

    @Test
    void testCaseSensitive() {
        List<String> input = Arrays.asList("Ab", "bA", "ba");
        List<List<String>> expected = List.of(
                List.of("Ab"),
                List.of("bA"),
                List.of("ba")
        );
        assertEquals(expected, grouper.groupAnagrams(input));
    }

    @Test
    void testMultipleGroups() {
        List<String> input = Arrays.asList("ab","ba","abc","bca","cab","c");
        List<List<String>> expected = List.of(
                List.of("ab","ba"),
                List.of("abc","bca","cab"),
                List.of("c")
        );
        assertEquals(expected, grouper.groupAnagrams(input));
    }
}
