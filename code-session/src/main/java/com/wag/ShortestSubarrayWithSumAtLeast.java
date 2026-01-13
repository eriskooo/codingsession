package com.wag;

/**
 * Napíš metódu, ktorá pre pole kladných celých čísel nájde najkratší súvislý úsek (subarray), ktorého súčet je ≥ K.
 * <p>
 * Ak taký úsek neexistuje, vráť Result s length = 0 a startIndex = -1 (alebo Optional<Result> – ale nech je to konzistentné).
 */
public class ShortestSubarrayWithSumAtLeast {

    public static Result shortestSubarrayWithSumAtLeast(int[] a, int k) {
        return null;
    }

    public record Result(int startIndex, int length) {
    }
}
