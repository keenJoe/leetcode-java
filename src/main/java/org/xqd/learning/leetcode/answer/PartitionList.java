package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * @date 2021/8/16 22:09
 */
public class PartitionList {
    public static void main(String[] args) throws InterruptedException {
        ListNode node6 = new ListNode(2, null);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(4, node3);
        ListNode head1 = new ListNode(1, node2);

        ListNode listNode = new PartitionList().partition(head1, 3);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode partition(ListNode head, int x) throws InterruptedException {
        if (head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode lessThanLinkedListNode = new ListNode(0);
        ListNode firstNode = lessThanLinkedListNode;
        ListNode greaterThanLinkedListNode = new ListNode(0);
        ListNode interactionNode = greaterThanLinkedListNode;

        while (head != null) {
            if (head.val < x) {
                lessThanLinkedListNode.next = head;
                lessThanLinkedListNode = lessThanLinkedListNode.next;
            } else {
                greaterThanLinkedListNode.next = head;
                greaterThanLinkedListNode = greaterThanLinkedListNode.next;
            }

            head = head.next;
        }

        lessThanLinkedListNode.next = null;
        greaterThanLinkedListNode.next = null;

        if (firstNode.next == null) {
            dummyNode.next = interactionNode.next;
        } else if (interactionNode.next == null) {
            dummyNode.next = firstNode.next;
        } else {
            lessThanLinkedListNode.next = interactionNode.next;
            dummyNode.next = firstNode.next;
        }

        return dummyNode.next;
    }
}
