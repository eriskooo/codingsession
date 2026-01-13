package com.wag;

import java.util.HashMap;
import java.util.Map;

public class LongestRun {
    public static Result longestRun(String s) {
        System.out.println(s);

        if (s == null || s.isEmpty()) throw new IllegalArgumentException();

        Map<Character, Result> lenght = new HashMap<>();
        Character latestChar = null;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (latestChar == null) {
                startIndex = i;
                latestChar = ch;
                Result r = new Result(ch, 1, startIndex);
                lenght.put(ch, r);
            } else {
                if (ch == latestChar) {
                    if (lenght.containsKey(ch)) {
                        Result r = lenght.get(ch);
                        int i1 = r.length + 1;
                        int i2 = r.startIndex;
                        lenght.put(ch, new Result(ch, i1, i2));
                    } else {
                        Result r = new Result(ch, 1, startIndex);
                        lenght.put(ch, r);
                    }
                } else {
                    startIndex = i;
                    latestChar = ch;
                    lenght.put(ch, new Result(ch, 1, startIndex));
                }
            }
        }

        // najdi najvacsi
        int maxValue = 0;
        Character maxChar = null;
        for (Character ch : lenght.keySet()) {
            if (maxValue < lenght.get(ch).length) {
                maxValue = lenght.get(ch).length;
                maxChar = ch;
            }
        }


        return lenght.get(maxChar);
    }

    public record Result(char ch, int length, int startIndex) {
    }
}
