package org.xqd.learning.leetcode.linkedlist2024;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 141. Linked List Cycle
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;

        slow = slow.next;
        if (fast.next != null) {
            fast = fast.next.next;
        } else {
            return false;
        }

        // 只要出现null，那么链表就没有环
        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }

            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
        }
        return false;
    }
}
