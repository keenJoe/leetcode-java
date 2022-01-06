package org.xqd.learning.leetcode.answer;

import java.util.Arrays;

/**
 * @author XuQidong
 * @date 2022/1/5 23:38
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] maxs = new int[length];

        for (int i = 0; i < nums.length; i++) {

            maxs[i] = nums[i];
            int current = 0;
            for (int j = i; j < nums.length; j++) {
                current += nums[j];

                if (current > maxs[i]) {
                    maxs[i] = current;
                }
            }

            if (i > 0) {
                if (maxs[i] > maxs[0]) {
                    maxs[0] = maxs[i];
                }
            }
        }

        return maxs[0];
    }
}
