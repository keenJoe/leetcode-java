package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 86. Partition List
 */
public class PartitionList {
    /**
     * 基于partition1，ChatGPT给出的优化方案
     * 使用链表模拟两个队列，然后再将队列串联
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode lessTail = lessHead;
        ListNode greaterHead = new ListNode(0);
        ListNode greaterTail = greaterHead;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                lessTail.next = curr;
                lessTail = curr;
            } else {
                greaterTail.next = curr;
                greaterTail = curr;
            }
            curr = curr.next;
        }

        lessTail.next = greaterHead.next;
        greaterTail.next = null;
        return lessHead.next;
    }

    public ListNode partition1(ListNode head, int x) {
        ListNode first = null;
        ListNode second = null;
        ListNode pre = null;

        ListNode dummy = new ListNode();
        dummy.next = head;

        while (head != null) {
            if (head.val < x) {
                //确认了两个指针，开始在中间插入。但是pre指针需要变化
                if (first != null && second != null) {
                    ListNode next = head.next;
                    head.next = null;

                    first.next = head;
                    head.next = second;

                    first = first.next;
                    pre.next = next;
                    head = next;
                } else if (second != null) {
                    ListNode next = head.next;
                    head.next = null;

                    dummy.next = head;
                    first = head;
                    first.next = second;

                    pre.next = next;
                    head = next;
                } else {
                    first = head;
                    pre = head;
                    head = head.next;
                }
            } else {
                //到这里，等于已经发现一个可以插入的区间了，确认了第二个指针
                if (second == null) {
                    second = head;
                }

                pre = head;
                head = head.next;
            }
        }

        return dummy.next;
    }
}
