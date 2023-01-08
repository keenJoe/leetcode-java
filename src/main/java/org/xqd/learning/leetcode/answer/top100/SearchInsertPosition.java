package org.xqd.learning.leetcode.answer.top100;

/**
 * 35. Search Insert Position
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + ((right - left) >> 1);

            if (nums[middle] == target) return middle;
            if (nums[left] == target) return left;
            if (nums[right] == target) return right;

            if (nums[middle] > target)
                right = middle - 1;
            else if (nums[middle] < target)
                left = middle + 1;
        }

        return left;
    }
}
