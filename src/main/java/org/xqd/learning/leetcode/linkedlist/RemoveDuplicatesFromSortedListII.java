package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head.next;
        ListNode pre = null;

        while (cur != null) {
            if (head != cur) {
                if (pre == null) {

                }
            }

            head = cur;
            cur = cur.next;
        }

        return null;
    }
}
