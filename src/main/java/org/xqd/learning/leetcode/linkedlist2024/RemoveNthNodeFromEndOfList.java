package org.xqd.learning.leetcode.linkedlist2024;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 19. Remove Nth Node From End of List
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // if (n == 1) return head.next;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = null;
        int removedIndex = nodeLength(head) - n + 1;

        int i = 1;
        while (head != null) {
            if (i == removedIndex) {
                if (pre != null) {
                    pre.next = head.next;
                    break;
                } else {
                    dummy.next = head.next;
                }
            }
            pre = head;
            head = head.next;
            i++;
        }
        return dummy.next;
    }

    public int nodeLength(ListNode head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }
}
