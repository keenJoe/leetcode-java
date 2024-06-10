package org.xqd.learning.leetcode.linkedlist2024;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 61. Rotate List
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int l = calLength(head);
        int index = l - k % l;
        if (index == k) {
            return head;
        }

        ListNode first = head;
        ListNode pre = null;
        while (index-- >= 0) {
            pre = head;
            head = head.next;
        }

        ListNode tempHead = head;
        pre.next = null;

        while (head != null) {
            if (head.next == null) {
                head.next = first;
                break;
            }

            head = head.next;
        }

        return tempHead;
    }

    private int calLength(ListNode head) {
        int l = 0;
        while (head != null) {
            l++;
            head = head.next;
        }

        return l;
    }
}
