package org.xqd.learning.leetcode.recursion;


/**
 * 50. Pow(x, n)
 */
public class Pow {
    public static void main(String[] args) {
        myPow(2.0000, 10);
    }


    public static double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return x;

        return f(x, n);
    }

    public static double f(double x, int n) {
        if (n == 1) {
            return x;
        }

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        double result = x * f(x, n - 1);
        System.out.println(result);

        return result;
    }
}
