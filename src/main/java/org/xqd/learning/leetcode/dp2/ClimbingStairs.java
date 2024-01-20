package org.xqd.learning.leetcode.dp2;

/**
 * 70. Climbing Stairs
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return dfs(n, memo);
    }

    private int dfs(int i, int[] memo) {
        if (i <= 1) { // 递归边界
            return 1;
        }
        if (memo[i] != 0) { // 之前计算过
            return memo[i];
        }
        return memo[i] = dfs(i - 1, memo) + dfs(i - 2, memo); // 记忆化
    }

    /**
     * 时间超限
     *
     * @param n
     * @return
     */
    public int climbStairs_1(int n) {
        if (n <= 1) {
            return 1;
        }

        return climbStairs_1(n - 1) + climbStairs_1(n - 2);
    }

    /**
     * To calculate the new value we only leverage the previous two values.
     * So we don't need to use an array to store all the previous values.
     *
     * @param n
     * @return
     */
    public int climbStairs0(int n) {
        if (n <= 1) {
            return 1;
        }

        int prev1 = 1;
        int prev2 = 2;

        for (int i = 3; i <= n; i++) {
            int newValue = prev1 + prev2;
            prev1 = prev2;
            prev2 = newValue;
        }

        return prev2;
    }

    int climbStairs2(int n) {
        if (n == 0) return 0;
        int rest[] = new int[n + 1];

        rest[0] = 1;
        rest[1] = 1;
        for (int i = 2; i <= n; i++) {
            rest[i] = rest[i - 1] + rest[i - 2];
        }

        return rest[n];
    }

    int climbStairs1(int n) {
        if (n == 0) return 0;

        return f(n);
    }

    //rest: 剩余rest步到达
    //rest == 0 已经到达，算作一种方法
    //rest == 1 还剩一步到达，算法一种方法
    // rest > 1 开始递归
    private int f(int rest) {
        if (rest == 0) return 1;
        if (rest == 1) return 1;

        return f(rest - 1) + f(rest - 2);
    }
}
