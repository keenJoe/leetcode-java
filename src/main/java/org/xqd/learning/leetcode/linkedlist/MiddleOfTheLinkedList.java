package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @description: 876. Middle of the Linked List
 * @author: Joe
 * @create: 2023-06-26 15:30
 **/
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            return head.next;
        }

        ListNode mid = head;
        ListNode fast = head;

        while (mid != null && fast != null) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }

            if (fast != null) {
                mid = mid.next;
            }
        }

        return mid;
    }
}
