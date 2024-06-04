package org.xqd.learning.leetcode.linkedlist2024;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 24. Swap Nodes in Pairs
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        while (head!= null) {
            if (head.next != null) {
                ListNode temp = head;
                head = head.next.next;

                ListNode next = temp.next;
//                temp.next = null;
                temp.next = next.next;
                next.next = temp;
//                head = head.next;
            }
        }
        return dummy.next;
    }
}
