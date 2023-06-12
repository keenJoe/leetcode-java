package org.xqd.learning.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 */
public class TwoSum {
    /**
     * @param nums
     * @param target
     * @return
     *
     * 但是这个不能通过排序啊😭
     */
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = bsearch(nums, target - nums[i], i + 1);
            if (j != -1) {
                return new int[]{i, j};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 二分法查找
     *
     * @param nums
     * @param i
     * @param i1
     * @return
     */
    private int bsearch(int[] nums, int key, int start) {
        int L = start;
        int R = nums.length;
        while (L < R) {
            int M = L + (R - L) / 2;
            //key is on the left of M
            if (nums[M] > key) {
                R = M;
            } else {
                L = M;
            }
        }

        return (L == R && nums[L] == key) ? L : -1;
    }


    /**
     * [3,2,3]
     * 6
     * 没有考虑到这种情况
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> value = new HashMap<>();
        int[] indexs = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int leftValue = target - nums[i];
            Integer index = value.get(leftValue);

            if (index == null) {
                value.put(nums[i], i);   //3,0
            } else {
                indexs[0] = index;
                indexs[1] = i;
                break;
            }
        }

        return indexs;
    }


    //纯暴力循环
    public int[] twoSum1(int[] nums, int target) {
        int[] indexs = new int[2];
        for (int i = 0; i < nums.length; i++) {
            indexs[0] = i;
            for (int j = i + 1; j < nums.length; j++) {
                indexs[1] = j;
                if (nums[i] + nums[j] == target) {
                    return indexs;
                }
            }
        }
        return indexs;
    }
}
