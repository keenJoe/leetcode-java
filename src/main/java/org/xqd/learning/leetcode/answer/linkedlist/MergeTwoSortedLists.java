package org.xqd.learning.leetcode.answer.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 21. Merge Two Sorted Lists
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode node8 = new ListNode(8, null);
        ListNode node7 = new ListNode(5, node8);
        ListNode node6 = new ListNode(3, node7);
        ListNode head2 = new ListNode(2, node6);

        ListNode node4 = new ListNode(4, null);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head1 = new ListNode(1, node2);

        ListNode listNode = mergeTwoLists(head1, head2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = new ListNode();
        ListNode dummyNode = head;

        ListNode head1 = list1;
        ListNode head2 = list2;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                head.next = head1;
                head1 = head1.next;
            } else {
                head.next = head2;
                head2 = head2.next;
            }
            head = head.next;
        }

        while (head1 != null) {
            head.next = head1;
            head = head.next;
            head1 = head1.next;
        }

        while (head2 != null) {
            head.next = head2;
            head = head.next;
            head2 = head2.next;
        }

        return dummyNode.next;
    }
}
