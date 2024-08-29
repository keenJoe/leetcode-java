package org.xqd.learning.leetcode.mergesort;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf count = new CountOfSmallerNumbersAfterSelf();
        int[] nums = {1, 0, 2};
        count.countSmaller(nums);
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length <= 1) {
            list.add(0);
            return list;
        }

//        int[] tmp = new int[nums.length];
//        System.arraycopy(nums, 0, tmp, 0, nums.length);
        //索引数组
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
        }

        int[] res = new int[nums.length];

        countSmaller(nums, 0, nums.length - 1, indexes, res);

        for (int re : res) {
//            System.out.println(re);
            list.add(re);
        }

        return list;
    }

    private void countSmaller(int[] nums, int l, int r, int[] indexes, int[] res) {
        if (l >= r) return;

        int m = (l + r) >> 1;
        countSmaller(nums, l, m, indexes, res);
        countSmaller(nums, m + 1, r, indexes, res);
        merge(nums, l, m, r, indexes, res);
    }

    /**
     * @param nums：原数组
     * @param l：左边界
     * @param m：中点
     * @param r：右边界
     * @param indexes：索引数组
     * @param res：结果数组
     */
    private void merge(int[] nums, int l, int m, int r, int[] indexes, int[] res) {
        if (l == r) return;

        int[] helper = new int[r - l + 1];
        int length = helper.length - 1;

        int p1 = m;
        int p2 = r;
        while (p1 >= l && p2 > m) {
//            nums[indexes[p1]] > nums[indexes[p2]] ? p2 - m : 0
            //改变indexes位置
            int count = nums[indexes[p1]] > nums[indexes[p2]] ? p2 - m : 0;
            if (nums[indexes[p1]] > nums[indexes[p2]]) {
                res[indexes[p1]] += count;
            }
            helper[length--] = nums[indexes[p1]] > nums[indexes[p2]] ? indexes[p1--] : indexes[p2--];
        }
        //完成剩余数组的合并
        while (p1 >= l) {
            helper[length--] = indexes[p1--];
        }
        while (p2 > m) {
            helper[length--] = indexes[p2--];
        }
        //复制回原数组
        for (int i = 0; i < helper.length; i++) {
            indexes[l + i] = helper[i];
        }
    }
}
