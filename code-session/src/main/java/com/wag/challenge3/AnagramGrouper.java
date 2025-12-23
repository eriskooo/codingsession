package com.wag.challenge3;

import java.util.*;

public class AnagramGrouper {


    /**
     * Task: Write a method that returns anagrams of a word in input.
     * <p>
     * Requirements: 1. Method accepts a list of words: List<String> words. 2. Returns a list of anagrams: List<String>. 3. Returned list must be sorted lexicographically
     * (ascending).
     *
     * <p>
     * Example: Input: "eat" ["eat", "tea", "tan", "ate", "nat", "bat"] Output: ["ate","eat","tea"]
     */
    public List<String> groupAnagrams(String word, List<String> words) {
        // TODO: Your implementation
        List<String> output = new ArrayList<>();

        for (String temp : words) {
            if (hasAll(word, temp)) {
                output.add(temp);
            }
        }
        // sort alphabetically
        System.out.println(output);


        return sorted(output);
    }

    private List<String> sorted(List<String> output) {
        int n = output.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                String left = output.get(j);
                String right = output.get(j + 1);
                if (left.compareTo(right) > 0) {
                    swapped = true;
                    output.set(j, right);
                    output.set(j + 1, left);
                }
            }
            if (!swapped) {
                break;
            }
        }
        return output;
    }

    private boolean hasAll(String word, String temp) {
        for (char ch : word.toCharArray()) {
            boolean contains = false;
            for (char ch2 : temp.toCharArray()) {
                if (ch == ch2) {
                    contains = true;
                }
            }
            if (!contains) {
                return contains;
            }
        }
        return true;
    }
}
