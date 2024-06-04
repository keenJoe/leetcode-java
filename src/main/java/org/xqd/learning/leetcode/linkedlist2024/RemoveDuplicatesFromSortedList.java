package org.xqd.learning.leetcode.linkedlist2024;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 83. Remove Duplicates from Sorted List
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = null;
        while (head != null) {
            if (pre != null) {
                if (pre.val != head.val) {
                    pre.next = head;
                    pre = head;
                } else if (head.next == null) {
                    pre.next = null;
                }
            } else {
                pre = head;
            }

            head = head.next;
        }

        return dummy.next;
    }
}
