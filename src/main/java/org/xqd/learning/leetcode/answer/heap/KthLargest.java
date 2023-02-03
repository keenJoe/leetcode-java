package org.xqd.learning.leetcode.answer.heap;

import java.util.PriorityQueue;

/**
 * @author XuQidong
 * @date 2022/5/15 18:37
 * LeetCode: 703. Kth Largest Element in a Stream
 */
public class KthLargest {
    private PriorityQueue<Integer> queue = new PriorityQueue<>();
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

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
    }

    public int add(int val) {
        if (queue.size() == k && val > queue.peek()) {
            queue.remove();
            queue.add(val);
        } else if (queue.size() < k) {
            queue.add(val);
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(2, new int[]{0});
        System.out.println(kthLargest.add(-1));
        System.out.println("&&&&&&&&&&");
        System.out.println(kthLargest.add(1));
        System.out.println("&&&&&&&&&&");
        System.out.println(kthLargest.add(-2));
        System.out.println("&&&&&&&&&&");
        System.out.println(kthLargest.add(-4));
        System.out.println("&&&&&&&&&&");
        System.out.println(kthLargest.add(3));
    }
}
