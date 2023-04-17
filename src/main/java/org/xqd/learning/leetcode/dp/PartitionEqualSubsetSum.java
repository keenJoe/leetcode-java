package org.xqd.learning.leetcode.dp;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 */
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        //int[] nums = {1, 5, 11, 5};
        int[] nums = {1, 2, 3, 5};
        System.out.println(canPartition(nums));
    }

    /**
     * 使用二维数组的方式
     */
    public static boolean canPartition2(int[] nums) {
        return true;
    }



    /**
     * 计算出总重量
     * 背包最大重量等于总重量的一半
     * 这样就转化为一个背包问题了
     * <p>
     * 这个问题现在不存在舍弃，最终所有的物品都会进入其中一个背包
     *
     * time limited
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;

        int r = r(nums, 0, sum / 2);

        if (r == -1) return false;

        if (r >= 1) return true;

        return false;
    }

    /**
     * 从一开始的设计就是错误的
     * 题目的结果是true或者false，而自己设计的方法返回int
     *
     * 其实也可以
     */
    public static int r(int[] nums, int index, int restWeight) {
        //如果剩余重量等于0，且索引小于等于数组长度，那么说明找到了一组符合的数据
        if (restWeight == 0 && index < nums.length) {
            return 1;
        }

        if (index >= nums.length) {
            return -1;
        }

        int p1 = r(nums, index + 1, restWeight - nums[index]);
        int p2 = r(nums, index + 1, restWeight);

        return Math.max(p1, p2);
    }

    /**
     * wrong answer
     */
    public static boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        Arrays.sort(nums);

        int half = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
            half += nums[i];
            if (sum / 2 == half && sum % 2 == 0) {

                return true;
            }
        }

        return false;
    }
}
