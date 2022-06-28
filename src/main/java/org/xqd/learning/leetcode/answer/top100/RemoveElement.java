package org.xqd.learning.leetcode.answer.top100;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 2, 2, 3, 3, 3, 3, 4, 5, 6, 7};
        int i = removeElement(nums, 2);
        System.out.println("长度: " + i);
    }

    public static int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        System.out.println(nums);
        for (int num : nums) {
            System.out.println("排序后: " + num);
        }
        System.out.println("打印结束");

        int start = -1, end = -1;
        boolean isFirst = true;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == val) {
//                if (isFirst) {
//                    start = i;
//                    end = i;
//                    isFirst = false;
//                } else {
//                    end = i;
//                }
//            } else {
//                if (start != -1 && end != -1) {
//
//                }
//            }
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }

        for (int i = 0; i < j; i++) {
            System.out.println(nums[i]);
        }

        return j;
    }
}
