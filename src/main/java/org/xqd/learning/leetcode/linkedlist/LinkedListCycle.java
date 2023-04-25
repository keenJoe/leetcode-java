package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author qidongxu
 *
 * 141. Linked List Cycle
 */
public class LinkedListCycle {
    /**
     * 双指针思想
     * 如果快指针能够追赶上慢指针，说明链表有环。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }

        ListNode sNode = head;
        ListNode fNode = null;
        if (head.next != null && head.next.next != null) {
            fNode = head.next.next;
        }

        while (sNode != null && fNode != null) {
            if (sNode == fNode) {
                return true;
            }

            sNode = sNode.next;
            if (fNode.next != null && fNode.next.next != null) {
                fNode = fNode.next.next;
            } else {
                fNode = null;
            }
        }

        return false;
    }
}
