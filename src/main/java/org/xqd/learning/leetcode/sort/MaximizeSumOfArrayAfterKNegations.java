package org.xqd.learning.leetcode.sort;


import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1005. Maximize Sum Of Array After K Negations
 */
public class MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        int[] nums = new int[]{3, -1, 0, 2};
        largestSumAfterKNegations(nums, 2);
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
        int max = 0;
        int minPositiveInteger = 0;

        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }

        while (k > 0) {
            Integer peek = queue.poll();
            int reverseValue = -peek;

            queue.add(reverseValue);

            k--;
        }


        for (int num : queue) {
            max += num;
        }

        return max;
    }
}
