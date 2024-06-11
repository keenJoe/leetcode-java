package org.xqd.learning.leetcode.linkedlist2024;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 86. Partition List
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode lessHead = new ListNode();
        ListNode lessHeadTemp = lessHead;
        ListNode greaterHead = new ListNode();
        ListNode greaterHeadTemp = greaterHead;

        while (head != null) {
            if (head.val <= x) {
                lessHeadTemp.next = head;
                lessHeadTemp = lessHeadTemp.next;
            } else {
                greaterHeadTemp.next = head;
                greaterHeadTemp = greaterHeadTemp.next;
            }

            head = head.next;
        }

        greaterHeadTemp.next = null;
        lessHeadTemp.next = greaterHead;


        return lessHead.next;
    }
}
