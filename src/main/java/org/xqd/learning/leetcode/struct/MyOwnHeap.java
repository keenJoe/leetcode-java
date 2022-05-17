package org.xqd.learning.leetcode.struct;

import java.util.Comparator;

/**
 * @author XuQidong
 * @date 2022/5/15 15:26
 */
public class MyOwnHeap {
    /**
     * methods in heap
     * 1. peek:
     * 2. pop:
     * 3. comparator: 创建大根堆or小根堆
     * 4. push:
     * 5. isEmpty:
     * 6. size:
     * 7. constructor method:
     * 7.1 provide a parameter to initialize the size of heap
     * 7.2 without a parameter
     * 7.3 provide a parameter that is an array of T
     * 8. remove
     * 9.
     */

    private int[] heap;
    private int size;
    private int limit;
    private Comparator<Integer> comparator;

    public int[] getHeap() {
        return heap;
    }

    public void setHeap(int[] heap) {
        this.heap = heap;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 默认创建一个大根堆
     */
    public MyOwnHeap(int limit) {
        this.heap = new int[limit];
        this.limit = limit;
        this.size = 0;
        this.comparator = Comparator.comparingInt(c -> c);
    }

    /**
     * 通过comparator可以自由地指定比较规则
     */
    public MyOwnHeap(int limit, Comparator<Integer> comparator) {
        this.heap = new int[limit];
        this.limit = limit;
        this.size = 0;
        this.comparator = comparator;
    }

    /**
     * 添加一个元素到堆中
     *
     * @param node
     */
    public void push(int node) {
        if (heap.length > limit) {
            //TODO to increase the limit when the size equeals to the threshold of heap
            throw new RuntimeException("heap is full");
        }

        heap[size] = node;
        swim(heap, size);
        size++;
    }

    /**
     * 返回堆顶的元素
     *
     * @return
     */
    public int pop() {
        int firstNode = heap[0];
        int lastNode = heap[--size];
        heap[0] = lastNode;

        sink(heap, 0, size);

        return firstNode;
    }

    private void sink(int[] heap, int index, int i) {
        int left = index * 2 + 1;
        while (left < i) {
            //这个判断条件很重要left + 1 < i && heap[left + 1] < heap[left] ? left : left + 1;
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

    /**
     * 堆的节点位置索引也是从0开始，和数组一样。
     *
     * @param heap
     * @param size insert 方法会将末尾的元素不停地向上调整，直到child节点小于parent节点
     */
    public void swim(int[] heap, int size) {
        int currentIndex = size;
        while (comparator.compare(heap[currentIndex], heap[(currentIndex - 1) / 2]) > 0) {
            swap(heap, (currentIndex - 1) / 2, currentIndex);
            currentIndex = (currentIndex - 1) / 2;
        }
    }

    private void swap(int[] heap, int parentIndex, int childIndex) {
        int temp = heap[childIndex];
        heap[childIndex] = heap[parentIndex];
        heap[parentIndex] = temp;
    }

    /**
     * 要加入参区别正序or倒序，如果是一个已经排序好的堆，则直接返回
     */
    public void heapSort() {
        swap(heap, 0, --size);
        while (size > 0) {
            sink(heap, 0, size);
            swap(heap, 0, --size);
        }
    }
}
