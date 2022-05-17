package org.xqd.learning.leetcode.answer.heap;

import java.util.HashMap;

/**
 * @author XuQidong
 * @date 2022/5/15 18:37
 * LeetCode: 703. Kth Largest Element in a Stream
 */
public class KthLargest {
    private int[] heap;
    private int k;

    public int[] getHeap() {
        return heap;
    }

    public void setHeap(int[] heap) {
        this.heap = heap;
    }

    public KthLargest(int k, int[] nums) {
        int size = 0;
        this.k = k;

        heap = new int[k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < 3) {
                heap[i] = nums[i];
                swim(heap, size);
                size++;
            } else {
                if (nums[i] > heap[0]) {
                    heap[i] = nums[i];
                    swim(heap, size);
                    size++;
                }
            }
        }
    }

    public void swim(int[] heap, int size) {
        int currentIndex = size;
        while (heap[currentIndex] < heap[(currentIndex - 1) / 2]) {
            swap(heap, (currentIndex - 1) / 2, currentIndex);
            currentIndex = (currentIndex - 1) / 2;
        }
    }

    private void swap(int[] heap, int parentIndex, int childIndex) {
        int temp = heap[childIndex];
        heap[childIndex] = heap[parentIndex];
        heap[parentIndex] = temp;
    }

    private void sink(int[] heap, int index, int i) {
        int left = index * 2 + 1;
        while (left < i) {
            int smallestIndex = left + 1 < i && heap[left + 1] < heap[left] ? left + 1 : left;
            smallestIndex = heap[smallestIndex] < heap[index] ? smallestIndex : index;
            if (smallestIndex == index) {
                break;
            }

            swap(heap, index, smallestIndex);
            index = smallestIndex;
            left = index * 2 + 1;
        }
    }

    public int add(int val) {
        int size = k;
        if (val > heap[0]) {
            heap[size] = val;
            swap(heap, 0, size);
            sink(heap, 0, size);
        }

        return heap[0];
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
//        KthLargest kthLargest = new KthLargest(1, new int[]{});
        System.out.println(kthLargest.add(3));
        System.out.println("&&&&&&&&&&");
        System.out.println(kthLargest.add(5));
        System.out.println("&&&&&&&&&&");
        System.out.println(kthLargest.add(10));
        System.out.println("&&&&&&&&&&");
        System.out.println(kthLargest.add(9));
        System.out.println("&&&&&&&&&&");
        System.out.println(kthLargest.add(4));
    }
}
