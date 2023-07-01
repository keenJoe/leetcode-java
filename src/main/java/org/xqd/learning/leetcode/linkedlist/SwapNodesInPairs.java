package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 24. Swap Nodes in Pairs
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode();
        ListNode pre = null;

        while (head != null) {
            ListNode temp = head;
            ListNode headNext = temp.next;
            head.next = null;

            ListNode nextHead = null;
            if (headNext != null) {
                nextHead = headNext.next;
            }

            if (dummyNode.next == null) {
                dummyNode.next = headNext;
            }

            if (pre != null && headNext != null) {
                pre.next = headNext;
            } else if (pre != null) {
                pre.next = temp;
            }

            pre = temp;

            if (headNext != null) {
                headNext.next = temp;
            }

            temp.next = nextHead;
            head = nextHead;
        }

        return dummyNode.next;
    }
}
