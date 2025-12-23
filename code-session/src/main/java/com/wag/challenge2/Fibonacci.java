package com.wag.challenge2;

public class Fibonacci {

    /**
     * Find nth fibonacci number.
     * <p>
     * Fibonacci sequence is defined as follows:
     * F(0) = 0
     * F(1) = 1
     * F(n) = F(n-1) + F(n-2)
     * Example of sequence: 0, 1, 1, 2, 3, 5, 8....
     * Example F(6) = 8
     * <p>
     * What is wrong with following implementation?
     * <p>
     * Change it so all unit tests are passed.
     */
    public static long fibonacci(long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // return fibonacci(n - 1) + fibonacci(n - 2);

        Long l1 = 1l;
        Long l2 = 1l;
        System.out.println("n = " + n);
        System.out.println("=========================================");
        for (int i = 2; i < n; i++) {
            long temp = l2;
            l2 = l1 + l2;
            l1 = temp;

            System.out.println("l1 = " + l1);
            System.out.println("l2 = " + l2);
        }

        return l2;
    }
}
