package org.xqd.learning.leetcode.dp;


/**
 * 70. Climbing Stairs
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int i = climbStairs1(3);
        System.out.println(i);
    }

    public static int climbStairs1(int n) {
        if(n==1) return 1;
        if(n==2) return 2;

        int[] a =  new int[n];
        a[0]=1;
        a[1]=2;

        for(int i=2;i<n;i++){
            a[i]=a[i-1]+a[i-2];
        }
        return a[n-1];
    }

    /**
     * Time limit exceeded
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
