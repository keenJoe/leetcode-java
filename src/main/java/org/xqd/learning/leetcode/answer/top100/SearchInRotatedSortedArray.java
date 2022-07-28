package org.xqd.learning.leetcode.answer.top100;

/**
 * 33. Search in Rotated Sorted Array
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        //int[] nums = new int[]{4, 5, 6, 8, 0, 1, 2};
        //int[] nums = new int[]{7, 8, 9, 0, 1, 2, 3, 4, 5, 6};
        int[] nums = new int[]{3, 4, 5, 6, 7, 8, 1, 2};
        //int[] nums = new int[]{5, 1, 3};
        //int[] nums = new int[]{4, 5, 6, 7, 8, 1, 2, 3};
        int search = search(nums, 2);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (target < nums[left] && target > nums[right]) return -1;

        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            System.out.println("当前 middle 值为：" + middle);

            if (target == nums[middle]) {
                return middle;
            } else {
                //判断[left,middle) 的单调性，或者判断(middle,right]的单调性
                boolean monotonicityOfLeft = false;
                if (middle >= left && nums[middle] - nums[left] >= 0) {
                    monotonicityOfLeft = true;
                }

                if (monotonicityOfLeft) {
                    if (target >= nums[left] && target < nums[middle]) {
                        right = middle - 1;
                    } else {
                        left = middle + 1;
                    }
                } else {
                    if (target > nums[middle] && target <= nums[right]) {
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                }
            }
//            if (target == nums[middle]) {
//                return middle;
//            } else if (target > nums[middle]) {
//                if (nums[right] - nums[left] < 0) {
//                    if (nums[left] <= target) {
//                        right = middle - 1;
//                    } else if (target <= nums[right]) {
//                        left = middle + 1;
//                    } else {
//                        return -1;
//                    }
//                } else {
//                    left = middle + 1;
//                }
//            } else if (target < nums[middle]) {
//                if (nums[right] - nums[left] < 0) {
//                    if (nums[left] <= target) {
//                        right = middle - 1;
//                    } else if (target <= nums[right]) {
//                        left = middle + 1;
//                    } else {
//                        return -1;
//                    }
//                } else {
//                    right = middle - 1;
//                }
//            }
        }

        return -1;
    }
}
