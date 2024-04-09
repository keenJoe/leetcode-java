package org.xqd.learning.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XuQidong
 * @date 2022/12/16 19:26
 * 96. Unique Binary Search Trees
 */
public class UniqueBinarySearchTrees {
    //记忆化搜索版本
    Map<Integer, Integer> map = new HashMap<>();
    public int numTrees1(int n) {
        if (n <= 1) {
            return 1;
        }

        if (map.containsKey(n)){
            return map.get(n);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int left = numTrees(i - 1);
            int right = numTrees(n - i);

            count += left * right;
        }

        map.put(n,count);

        return count;
    }


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
            //第一个for循环还能理解，但是不能理解第二个
            //https://leetcode.cn/problems/unique-binary-search-trees/solutions/330990/shou-hua-tu-jie-san-chong-xie-fa-dp-di-gui-ji-yi-h/
            //不如这个解释的清楚
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
