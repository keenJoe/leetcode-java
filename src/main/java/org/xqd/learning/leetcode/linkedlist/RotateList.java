package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 61. Rotate List
 *
 * @author XuQidong
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int length = nodeLength(head);
        if (k == 0 || k % length == 0) return head;

        int index = length - k % length + 1;

        ListNode pre = null;
        ListNode first = head;

        int i = 1;
        while (i < index) {
            i++;
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

    public int nodeLength(ListNode head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }
}
