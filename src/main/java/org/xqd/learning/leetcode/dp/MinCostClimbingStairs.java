package org.xqd.learning.leetcode.dp;

import java.util.Arrays;

/**
 * 746. Min Cost Climbing Stairs
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        int[] cost = {10, 15, 20};
//        int[] cost = {1, 100};
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int i = minCostClimbingStairs.minCostClimbingStairs(cost);
        System.out.println(i);
    }

    public int minCostClimbingStairs(int[] cost) {
        //int zero = fromIndexZero(cost, 0, cost.length);
        //int one = fromIndexOne(cost, 1, cost.length);
        //int zero = dp0(cost);
        //int one = dp1(cost);
        //return Math.min(zero, one);

        return process0(cost);
    }

    public int process0(int[] cost) {
        int length = cost.length;
        int[][] array = new int[length + 1][length + 1];

        for (int row = 0; row < length; row++) {
            array[row][0] = 0;
        }

        for (int col = 0; col < length; col++) {
            array[length][col] = 0;
        }

        for (int col = 1; col < length + 1; col++) {
            array[length - 1][col] = cost[length - 1];
        }

        for (int col = 1; col < length + 1; col++) {
            for (int row = 0; row < length - 1; row++) {
                int a = array[row + 1][col - 1];
                int b = 0;
                if (col - 2 >= 0) {
                    b = array[row + 2][col - 2];
                }
                array[row][col] = cost[row] + Math.min(a, b);
            }
        }

        return Math.min(array[0][cost.length], array[1][cost.length]);
    }

    public int dp0(int[] cost) {
        int[][] result = new int[cost.length + 1][cost.length + 1];

        int length = cost.length + 1;
        int j = 1;
        for (int i = length - 2; i >= 0; i--) {
            int a;
            if (i + 1 >= length - 1 || j - 1 <= 0) {
                a = 0;
            } else {
                a = result[i + 1][j - 1];
            }

            int b;
            if (i + 2 >= length - 1 || j - 2 <= 0) {
                b = 0;
            } else {
                b = result[i + 2][j - 2];
            }

            int min = Math.min(a, b);
            result[i][j] = cost[i] + min;
            j++;
        }

        return result[0][length - 1];
    }

    public int dp1(int[] cost) {
        int[][] result = new int[cost.length + 1][cost.length + 1];

        int length = cost.length + 1;
        int j = 2;
        for (int i = length - 2; i > 0; i--) {
            int a;
            if (i + 1 >= length - 1 || j - 1 <= 0) {
                a = 0;
            } else {
                a = result[i + 1][j - 1];
            }

            int b;
            if (i + 2 >= length - 1 || j - 2 <= 0) {
                b = 0;
            } else {
                b = result[i + 2][j - 2];
            }

            int min = Math.min(a, b);
            result[i][j] = cost[i] + min;
            j++;
        }

        return result[1][length - 1];
    }

    public int fromIndexZero(int[] cost, int index, int rest) {
//        if (index >= cost.length) {
//            return 0;
//        }

        if (rest <= 0) {
            return 0;
        }

        int currentCost = 0;
        if (index < cost.length) {
            currentCost = cost[index];
        }

        int one = fromIndexZero(cost, index + 1, rest - 1);
        int two = fromIndexZero(cost, index + 2, rest - 2);

        return currentCost + Math.min(one, two);
    }

    public int fromIndexOne(int[] cost, int index, int rest) {
//        if (index >= cost.length) {
//            return 0;
//        }
        if (rest <= 0) {
            return 0;
        }

        int currentCost = 0;
        if (index < cost.length) {
            currentCost = cost[index];
        }

        return currentCost + Math.min(fromIndexOne(cost, index + 1, rest - 1),
                fromIndexOne(cost, index + 2, rest - 2));
    }
}
