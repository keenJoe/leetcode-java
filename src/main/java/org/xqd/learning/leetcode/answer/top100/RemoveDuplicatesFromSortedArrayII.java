package org.xqd.learning.leetcode.answer.top100;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 80. Remove Duplicates from Sorted Array II
 */
public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 5, 6, 7};
        int i = removeDuplicates(nums);
        System.out.println("长度: " + i);
    }

    public static int removeDuplicates(int[] nums) {
        int start = 0, end = 0;
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;

        for (int i = 0; i < length; i++) {
//            end = i;
//            if (nums[start] != nums[end]) {
////                if (end - start > 2 && nums[start] == nums[start + 1]) {
////                    start += 2;
////                    int copyStart = start;
////                    for (int j = end; j < length; j++) {
////                        nums[copyStart++] = nums[j];
////                    }
////
////                    length = length - 2;
////                } else {
////                    start++;
////                }
//
//            }
            int c = map.get(nums[i]) == null ? 0 : map.get(nums[i]);
            if (i < 2 || c < 2) {
                nums[j++] = nums[i];
                int count = map.get(nums[i]) == null ? 0 : map.get(nums[i]);
                System.out.println(nums[i] + ":" + count);
                map.put(nums[i], count + 1);
            }
        }

        for (int i = 0; i < j; i++) {
            System.out.println(nums[i]);
        }

        return j;
    }
}
