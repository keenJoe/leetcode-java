package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

import java.beans.EventHandler;

/**
 * 83. Remove Duplicates from Sorted List
 * @author mac
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return dummyNode.next;
    }
}
