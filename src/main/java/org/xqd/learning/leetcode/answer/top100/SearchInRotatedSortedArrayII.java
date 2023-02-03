package org.xqd.learning.leetcode.answer.top100;

/**
 * 81. Search in Rotated Sorted Array II
 */
public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) throws InterruptedException {
        int[] nums = new int[]{1, 0, 1, 1, 1};
        boolean search = search(nums, 0);
        System.out.println(search);
    }

    public static boolean search(int[] nums, int target) throws InterruptedException {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            System.out.println("当前 left 值：" + left);
            System.out.println("当前 right 值：" + right);

            int mid = left + ((right - left) >> 1);
            System.out.println("当前 mid 值：" + mid);

            if (target == nums[mid]) {
                return true;
            } else if (target > nums[mid]) {
                if (nums[mid] <= nums[left] && nums[mid] <= nums[right]) {
                    if (target <= nums[right]) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                } else {
                    left = mid;
                }
            } else {
                if (nums[mid] >= nums[left] && nums[mid] >= nums[right]) {
                    if (target >= nums[left]) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                } else {
                    right = mid;
                }
            }

            Thread.sleep(2000);
            System.out.println("************");
        }

        return false;
    }
}
