package org.xqd.learning.leetcode.linkedlist2024;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                int x = head.val;
                while (head != null && head.next != null && head.next.val == x) {
                    head = head.next;
                }
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
