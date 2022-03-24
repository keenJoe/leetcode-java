package org.xqd.learning.leetcode.answer.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * LeetCode 147
 */
public class InsertionSortList {
    public static void main(String[] args) {
        ListNode node8 = new ListNode(8, null);
        ListNode node7 = new ListNode(9, node8);
        ListNode node6 = new ListNode(7, node7);
        ListNode node5 = new ListNode(2, node6);
        ListNode node4 = new ListNode(5, node5);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(4, node3);
        ListNode head1 = new ListNode(3, node2);

        insertionSortList(head1);
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode next = head.next;
        ListNode first = head;
        while (next != null) {
            ListNode temp = next;

            next = next.next;
        }

        return null;
    }
}
