package org.xqd.learning.leetcode.linkedlist2024;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 92. Reverse Linked List II
 * 1-2-3-4-5 reverse 1-3
 * 1-2-3-4-5 reverse 2-4
 * 1-2-3-4-5 reverse 3-5
 * 1-2-3-4-5 reverse 1-5
 */
public class ReverseLinkedListII {


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.val == left && head.val == right) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = null;

        ListNode start = null;
        ListNode end = null;
        ListNode endNext = null;
        ListNode temp = head;
        while (temp != null) {


            if (temp.val == left) {
                start = temp;
            }

            if (temp.val == right) {
                end = temp;
                endNext = temp.next;
                end.next = null;
            }

            //确认start的前置节点
            if (start == null) {
                pre = temp;
                pre.next = null;
            }

            temp = temp.next;
        }

        ListNode newHead = new ListNode();

        while (start != null) {
            ListNode next = newHead.next;
            newHead.next = null;
            newHead.next = start;

            ListNode startNext = start.next;
            start.next = next;

            start = startNext;
        }

        pre.next = newHead.next;

        return dummy.next;
    }
}
