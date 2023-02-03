package org.xqd.learning.leetcode.answer.heap;

import java.util.Arrays;

/**
 * @author XuQidong
 * @date 2022/5/15 18:37
 * LeetCode: 703. Kth Largest Element in a Stream
 */
public class KthLargest1 {

    private int k;

    private int[] heap;

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int[] getHeap() {
        return heap;
    }

    public void setHeap(int[] heap) {
        this.heap = heap;
    }

    public KthLargest1(int k, int[] nums) {
        this.k = k;
        heap = new int[nums.length];
        swim(nums);
    }

    public void swim(int[] heap, int size) {
        int currentIndex = size;
        while (heap[currentIndex] > heap[(currentIndex - 1) / 2]) {
            swap(heap, (currentIndex - 1) / 2, currentIndex);
            currentIndex = (currentIndex - 1) / 2;
        }
    }

    public void swim(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            heap[i] = number;
            int currentIndex = i;
            while (heap[currentIndex] > heap[(currentIndex - 1) / 2]) {
                swap(heap, (currentIndex - 1) / 2, currentIndex);
                currentIndex = (currentIndex - 1) / 2;
            }
        }
    }

    private void swap(int[] heap, int parentIndex, int childIndex) {
        int temp = heap[childIndex];
        heap[childIndex] = heap[parentIndex];
        heap[parentIndex] = temp;
    }

    public void sort(int[] nums) {
        int size = nums.length;
        swap(nums, 0, --size);
        while (size > 0) {
            sink(nums, 0, size);
            swap(nums, 0, --size);
        }
    }

    private void sink(int[] heap, int index, int i) {
        int left = index * 2 + 1;
        while (left < i) {
            int largesIndex = left + 1 < i && heap[left + 1] > heap[left] ? left + 1 : left;
            largesIndex = heap[largesIndex] > heap[index] ? largesIndex : index;
            if (largesIndex == index) {
                break;
            }

            swap(heap, index, largesIndex);
            index = largesIndex;
            left = index * 2 + 1;
        }
    }

    public int add(int val) {
        //新数组
        int[] newHeap = new int[heap.length + 1];
        System.out.println("此时的数组: " + Arrays.toString(Arrays.stream(newHeap).toArray()));

        for (int i = 0; i < heap.length; i++) {
            newHeap[i] = heap[i];
        }

        System.out.println("after for 数组: " + Arrays.toString(Arrays.stream(newHeap).toArray()));

        newHeap[heap.length] = val;
        System.out.println("adding for 数组: " + Arrays.toString(Arrays.stream(newHeap).toArray()));

        //产生一个新大根堆
        swim(newHeap, newHeap.length - 1);
        System.out.println("after swimming 数组: " + Arrays.toString(Arrays.stream(newHeap).toArray()));

        heap = new int[newHeap.length];
        for (int i = 0; i < heap.length; i++) {
            heap[i] = newHeap[i];
        }

        sort(newHeap);
        System.out.println("after sorting 数组: " + Arrays.toString(Arrays.stream(newHeap).toArray()));

        return newHeap[newHeap.length - k];
    }

    public static void main(String[] args) {
        KthLargest1 kthLargest1 = new KthLargest1(3, new int[]{4, 5, 8, 2});
        for (int i : kthLargest1.getHeap()) {
            System.out.println(i);
        }

        kthLargest1.add(3);
        System.out.println("****after adding 3*****");

        for (int i : kthLargest1.getHeap()) {
            System.out.println(i);
        }

        kthLargest1.add(5);
        System.out.println("****after adding 5*****");

        for (int i : kthLargest1.getHeap()) {
            System.out.println(i);
        }

        kthLargest1.add(10);
        System.out.println("****after adding 10*****");

        for (int i : kthLargest1.getHeap()) {
            System.out.println(i);
        }

        kthLargest1.add(9);
        System.out.println("****after adding 9*****");

        for (int i : kthLargest1.getHeap()) {
            System.out.println(i);
        }

        kthLargest1.add(4);
        System.out.println("****after adding 4*****");

        for (int i : kthLargest1.getHeap()) {
            System.out.println(i);
        }
    }
}
