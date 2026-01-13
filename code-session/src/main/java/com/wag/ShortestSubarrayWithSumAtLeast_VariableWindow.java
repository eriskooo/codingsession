package com.wag;

public class ShortestSubarrayWithSumAtLeast_VariableWindow {


    /**
     * najkratší súvislý subarray so súčtom ≥ k (predpoklad: a obsahuje kladné čísla, inak tento O(n) prístup neplatí).
     *
     * @param a
     * @param k
     * @return
     */
    public static Result shortestSubarrayWithSumAtLeast(int[] a, int k) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException();
        }
        if (k < 1) {
            throw new IllegalArgumentException();
        }


        int left = 0;
        int sum = 0;

        int bestLen = Integer.MAX_VALUE;
        int bestStart = -1;


        for (int right = 0; right < a.length; right++) {
            sum += a[right];
            System.out.println("++sum = " + sum);
            while (sum >= k) {
                int currLen = right - left + 1;
                sum -= a[right - left + 1];

                System.out.println("--sum = " + sum);
                // update best: kratšie vyhráva; pri rovnosti skorší startIndex
                if (currLen < bestLen || (currLen == bestLen && left < bestStart)) {
                    bestLen = currLen;
                    bestStart = left;
                }

                sum -= a[left];
                left++;

            }
        }


        return new Result(bestStart, bestLen);
    }

    public record Result(int startIndex, int length) {
    }
}
