package org.xqd.learning.leetcode.answer.heap;

import java.util.PriorityQueue;

/**
 * @author XuQidong
 * @date 2022/5/18 12:38
 * <p>
 * LeetCode 215. Kth Largest Element in an Array
 * <p>
 * Example 1
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * <p>
 * Example 2
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 */
public class KthLargestElementInArray {
    private PriorityQueue<Integer> queue = new PriorityQueue<>();

    public int findKthLargest(int[] nums, int k) {
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                Integer peek = queue.peek();
                if (num > peek.intValue()) {
                    queue.remove();
                    queue.add(num);
                }
            }
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
        int kthLargest = kthLargestElementInArray.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        System.out.println(kthLargest);
    }
}
