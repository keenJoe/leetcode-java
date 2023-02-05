package org.xqd.learning.leetcode.dp;

/**
 * 509. Fibonacci Number
 */
public class FibonacciNumber {
    public static void main(String[] args) {

    }

    public int fib(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        return fib(n - 1) + fib(n - 2);
    }
}
