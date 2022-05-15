package org.xqd.learning.leetcode.struct;

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

    public int[] getHeap() {
        return heap;
    }

    public void setHeap(int[] heap) {
        this.heap = heap;
    }

    public MyOwnHeap(int limit) {
        this.heap = new int[limit];
        this.limit = limit;
        this.size = 0;
    }

    public void push(int node) {
        if (heap.length > limit) {
            throw new RuntimeException("heap is full");
        }

        heap[size] = node;
        heapInsert(heap, size);
        size++;
    }

    /**
     * 堆的节点位置索引也是从0开始，和数组一样。
     *
     * @param heap
     * @param size insert 方法会将末尾的元素不停地向上调整，直到child节点小于parent节点
     */
    public void heapInsert(int[] heap, int size) {
        int currentIndex = size;
        while (heap[currentIndex] > heap[(currentIndex - 1) / 2]) {
            swap(heap, (currentIndex - 1) / 2, currentIndex);
            currentIndex = (currentIndex - 1) / 2;
        }
    }

    private void swap(int[] heap, int parentIndex, int childIndex) {
        int temp = heap[childIndex];
        heap[childIndex] = heap[parentIndex];
        heap[parentIndex] = temp;
    }
}
