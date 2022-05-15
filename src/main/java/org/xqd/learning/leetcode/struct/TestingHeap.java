package org.xqd.learning.leetcode.struct;

import java.util.PriorityQueue;

/**
 * @author XuQidong
 * @date 2022/5/15 15:30
 */
public class TestingHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        queue.add(2);
        queue.add(4);
        queue.add(1);
        queue.add(0);
        queue.add(5);

        for (Integer integer : queue) {
            System.out.println(integer);
        }

        System.out.println("*******************");

        MyOwnHeap myOwnHeap = new MyOwnHeap(5);
        myOwnHeap.push(2);
        myOwnHeap.push(4);
        myOwnHeap.push(1);
        myOwnHeap.push(0);
        myOwnHeap.push(5);

        for (int i : myOwnHeap.getHeap()) {
            System.out.println(i);
        }

        System.out.println("*******run heapSort()********");
        myOwnHeap.heapSort();
        for (int i : myOwnHeap.getHeap()) {
            System.out.println(i);
        }
    }
}
