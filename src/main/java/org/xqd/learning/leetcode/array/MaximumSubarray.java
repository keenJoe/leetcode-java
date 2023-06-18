package org.xqd.learning.leetcode.array;

/**
 * 53. Maximum Subarray
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    public int process(int[] nums, int start, int end) {
        int r1 = 0;
        if (start + 1 < end) {
            r1= process(nums, start + 1, end);
        }

        int r2 = 0;
        if (start + 1 < end) {
            r2= process(nums, start, end + 1);
        }

        int r3 = 0;
        if (start + 1 < end) {
            r3= process(nums, start + 1, end + 1);
        }


        return Math.max(r1, Math.max(r2, r3));
    }
}
