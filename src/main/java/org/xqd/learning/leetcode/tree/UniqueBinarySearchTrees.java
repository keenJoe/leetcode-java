package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

/**
 * @author XuQidong
 * @date 2022/12/16 19:26
 * 96. Unique Binary Search Trees
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int left = numTrees(i - 1);
            int right = numTrees(n - i);

            count += left * right;
        }

        return count;
    }

    public int dp(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
