package com.wag.challenge2;

public class Fibonacci {

    /**
     * Find nth fibonacci number.
     *
     * Fibonacci sequence is defined as follows:
     * F(0) = 0
     * F(1) = 1
     * F(n) = F(n-1) + F(n-2)
     * Example of sequence: 0, 1, 1, 2, 3, 5, 8....
     * Example F(6) = 8
     *
     * What is wrong with following implementation?
     *
     * Change it so all unit tests are passed.
     */
//    public static long fibonacci(long n) {
//        if (n <= 1) {
//            return n;
//        }
//        return fibonacci(n - 1) + fibonacci(n - 2);
//    }

    public static long fibonacci(long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long first = 0;
        long sec = 1;

        for (int i = 2; i < n; i++) {
            long t = first + sec;
            first = sec;
            sec = t;
        }

        return first + sec;
    }
}
