package org.xqd.learning.leetcode.answer.top100;

/**
 * 26. Remove Duplicates from Sorted Array
 */
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            end = i;
            if (nums[end] != nums[start]) {
                if (start + 1 != end) {
                    nums[start + 1] = nums[end];
                    start++;
                } else {
                    start = end;
                }
            }
        }

        return start + 1;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums = new int[]{1};
        System.out.println(removeDuplicates(nums));

        System.out.println("********");

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
