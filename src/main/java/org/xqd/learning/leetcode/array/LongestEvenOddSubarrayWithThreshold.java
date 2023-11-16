package org.xqd.learning.leetcode.array;

/**
 * 2760. Longest Even Odd Subarray With Threshold
 */
public class LongestEvenOddSubarrayWithThreshold {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int l = -1;
        int r = -1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n % 2 == 0) {
                l = i;
                for (int j = l; j < nums.length; j++) {
                    if (nums[j] <= threshold) {
                        if (j + 1 < nums.length) {
                            if (nums[j] % 2 != nums[j + 1] % 2) {
                                r = j;
                                max = Math.max(max, r - l + 1);
                            } else {
                                r = j;
                                max = Math.max(max, r - l + 1);
                                break;
                            }
                        } else {
                            r = j;
                            max = Math.max(max, r - l + 1);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return max;
    }
}
