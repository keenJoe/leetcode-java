package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * 203. Remove Linked List Elements
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);
        ListNode pre = dummyNode;
        pre.next = head;

        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                head = head.next;
            } else {
                pre = head;
                head = head.next;
            }
        }

        return dummyNode.next;
    }
}
