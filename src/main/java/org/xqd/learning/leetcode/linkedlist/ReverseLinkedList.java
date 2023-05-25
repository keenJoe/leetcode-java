package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 206. Reverse Linked List
 * @author XuQidong
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode pre = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }
}
