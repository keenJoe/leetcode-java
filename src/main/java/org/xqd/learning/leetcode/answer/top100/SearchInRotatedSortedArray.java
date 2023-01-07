package org.xqd.learning.leetcode.answer.top100;

/**
 * 33. Search in Rotated Sorted Array
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {
        int p = -1;

        int start = 0;
        int end = nums.length -1;

        /**
         * maybe need to compare the nums[middle] with target,
         * and compare nums[start] or nums[end] with target
         * not just using one condition like nums[middle]
         */
        while (start <= end) {
            int middle = start + ((end - start) >> 1);
//            if (nums[middle] )
        }

        return p;
    }
}
