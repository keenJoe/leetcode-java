package org.xqd.learning.leetcode.answer.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * LeetCode 143
 */
public class ReorderList {

    public static void main(String[] args) throws InterruptedException {
        ListNode node6 = new ListNode(6, null);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head1 = new ListNode(1, node2);

        ListNode listNode = new ReorderList().reorderList(head1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
            Thread.sleep(1000);
        }
    }

    public ListNode reorderList(ListNode head) {
        return null;
    }

    public int getListLength(ListNode head) {
        int count = 0;

        while (head != null) {
            count++;
            head = head.next;
        }

        return count;
    }
}
