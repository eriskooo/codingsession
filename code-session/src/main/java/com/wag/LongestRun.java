package com.wag;

public class LongestRun {
    public static Result longestRun(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input string must not be null/empty.");
        }

        // current run
        char currCh = s.charAt(0);
        int currStart = 0;
        int currLen = 1;

        // best run so far
        char bestCh = currCh;
        int bestStart = 0;
        int bestLen = 1;

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == currCh) {
                currLen++;
            } else {
                // close current run and compare to best
                if (currLen > bestLen || (currLen == bestLen && currStart < bestStart)) {
                    bestCh = currCh;
                    bestLen = currLen;
                    bestStart = currStart;
                }

                // start new run
                currCh = ch;
                currStart = i;
                currLen = 1;
            }
        }

        // final run (string may end while still in a run)
        if (currLen > bestLen || (currLen == bestLen && currStart < bestStart)) {
            bestCh = currCh;
            bestLen = currLen;
            bestStart = currStart;
        }

        return new Result(bestCh, bestLen, bestStart);
    }

    public record Result(char ch, int length, int startIndex) {
    }
}
