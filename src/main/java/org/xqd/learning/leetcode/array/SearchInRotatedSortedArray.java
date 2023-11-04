package org.xqd.learning.leetcode.array;

/**
 * 33. Search in Rotated Sorted Array
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) throws InterruptedException {
        int[] array = {1, 0, 1, 1, 1};

        System.out.println("返回值:" + search(array, 0));
    }

    public static boolean search(int[] nums, int target) throws InterruptedException {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            System.out.println("左值" + left);
            System.out.println("右值" + right);
            int mid = left + (right - left) / 2;
            System.out.println("中间" + mid);

            if (target == nums[mid]) {
                return true;
            } else {
                if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                    int[] leftArray = new int[mid - left + 1];
                    System.arraycopy(nums, left, leftArray, 0, mid - left + 1);
                    int[] rightArray = new int[right - mid + 1];
                    System.arraycopy(nums, mid + 1, rightArray, 0, right - mid);
                    return search(leftArray, target) && search(rightArray, target);
                } else {
                    if (nums[left] <= nums[mid]) {
                        if (target >= nums[left] && target <= nums[mid]) {
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    } else {
                        if (target >= nums[mid] && target <= nums[right]) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                }
            }

            Thread.sleep(1);
            System.out.println("=========");
        }

        return false;
    }
}
