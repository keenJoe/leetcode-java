package org.xqd.learning.leetcode.answer.top100;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) throws InterruptedException {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] range = searchRange(nums, 9);
        System.out.println("开始遍历输出结果");
        for (int i : range) {
            System.out.println(i);
        }
    }

    public static int[] searchRange(int[] nums, int target) throws InterruptedException {
        if (nums.length == 0 || (target > nums[nums.length -1] || target < nums[0])) {
            return new int[]{-1, -1};
        }

        int[] rs = new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        //Thread.sleep(5000);

        int start = -1;
        int end = -1;

        int middle = -1;
        while (left <= right) {
            middle = left + ((right - left) >> 1);
            if (nums[middle] >= target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            System.out.println("left is " + left);
            System.out.println("right is " + left);
        }

        start = left;

        left = 0;
        right = nums.length - 1;
        middle = -1;

        while (left <= right) {
            middle = left + ((right - left) >> 1);
            if (nums[middle] <= target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        end = right;

        System.out.println("当前 start: " + start);
        System.out.println("当前 end: " + end);
        if (start > end) {
            return new int[]{-1, -1};
        }

        rs[0] = start;
        rs[1] = end;
        return rs;
    }
}
