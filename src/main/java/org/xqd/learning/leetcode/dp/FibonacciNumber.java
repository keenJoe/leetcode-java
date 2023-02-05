package org.xqd.learning.leetcode.dp;

/**
 * 509. Fibonacci Number
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        int fib = fibonacciNumber.fib(9);
        int i = fibonacciNumber.fib1(9);
        System.out.println(fib);
        System.out.println(i);
    }

    public int fib(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[n];
    }

    public int fib1(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        return fib(n - 1) + fib(n - 2);
    }
}
