package org.xqd.learning.leetcode.array;

/**
 * 2560. House Robber IV
 */
public class HouseRobberIV {
    public int minCapability(int[] nums, int k) {
        int cur_max = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            //确认查找范围
            int left = i - 1;
            int right = i + 1;

            //还要考虑到K，要找出一组不连续的K-1个数值的最小和
        }

        return cur_max;
    }
}
