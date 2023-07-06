package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 147. Insertion Sort List
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummyNode= new ListNode();
        ListNode pre = head;
        dummyNode.next = pre;

        pre.next = null;

        ListNode cur = head.next;

        while (cur != null) {
            while (pre.val > cur.val) {
                ListNode temp = pre;
                pre = cur;
                pre.next = temp;
                cur = temp;
            }
        }

        return dummyNode.next;
    }
}
