package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

import java.util.ArrayDeque;

/**
 * @description: 86. Partition List
 * @author: Joe
 * @create: 2023-06-26 23:35
 **/
public class PartitionList {
    public static void main(String[] args) {
        //[1,1,4,3,2,5,2]
//        ListNode node5 = new ListNode(2);
//        ListNode node4 = new ListNode(5);
//        node4.setNext(node5);
//        ListNode node3 = new ListNode(2);
//        node3.setNext(node4);
//        ListNode node2 = new ListNode(3);
//        node2.setNext(node3);
        ListNode node1 = new ListNode(4);
//        node1.setNext(node2);
        ListNode node0 = new ListNode(1);
        node0.setNext(node1);
        ListNode head = new ListNode(3);
        head.setNext(node0);
        ListNode partition = partition(head, 3);
        while (partition != null) {
            System.out.println(partition.val);
            partition = partition.next;
        }
    }

    /**
     * 使用two pointers
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode first = null;
        ListNode second = null;
        ListNode pre = null;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode tempHead = head;

        while (head != null) {
            System.out.println("当前的节点：" + head.val);

            if (head.val < x) {
                //确认了两个指针，开始在中间插入。但是pre指针需要变化
                if (first != null && second != null) {
                    System.out.println("在这");
                    ListNode temp = head;
                    ListNode next = head.next;
                    head.next = null;
                    System.out.println("当前的temp节点: " + temp.val);
//                    System.out.println("当前的next节点: " + next.val);

                    System.out.println("当前的first节点是: " + first.val);
                    System.out.println("当前的second节点是: " + second.val);
                    first.next = temp;
                    temp.next = second;

                    first = first.next;
                    System.out.println("当前的first节点: " + first.val);
                    pre.next = next;
                    head = next;
                } else if (first == null && second == null && second != null) {
                    System.out.println("第一个节点不是小于x的节点");
                    ListNode next = head.next;
                    head.next = null;

                    dummy.next = head;
                    first = head;
                    first.next = second;
                    if (pre.val == second.val) {
                        second.next = next;
                    }

                    head = next;
                } else {
                    first = head;
                    pre = head;
                    System.out.println("当前pre：" + pre.val);
                    head = head.next;
                }
            } else {
                //到这里，等于已经发现一个可以插入的区间了，确认了第二个指针
                if (second == null) {
                    System.out.println("发现第二个指针");
                    second = head;
                }

                pre = head;
                System.out.println("当前pre：" + pre.val);
                head = head.next;
            }

            System.out.println("=======");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }

        return dummy.next;
    }

    public ListNode partition1(ListNode head, int x) {
        ArrayDeque<ListNode> lessQueue = new ArrayDeque<>();
        ArrayDeque<ListNode> greaterQueue = new ArrayDeque<>();

        while (head != null) {
            if (head.val >= x) {
                greaterQueue.add(head);
            } else {
                lessQueue.add(head);
            }

            head = head.next;
        }

        ListNode dummy = new ListNode();
        ListNode tempHead = new ListNode();
        dummy = tempHead;

        while (!lessQueue.isEmpty()) {
            tempHead.next = lessQueue.poll();
            tempHead = tempHead.next;
        }

        while (!greaterQueue.isEmpty()) {
            tempHead.next = greaterQueue.poll();
            tempHead = tempHead.next;
        }

        //如果没有这一步，会形成一个cycle
        tempHead.next = null;

        return dummy.next;
    }
}
