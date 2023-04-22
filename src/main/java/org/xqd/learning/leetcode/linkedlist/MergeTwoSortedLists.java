package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author qidongxu
 *
 * 21. Merge Two Sorted Lists
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode dummyNode = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }

            head = head.next;
        }

        // while (list1 != null) {
        //     head.next = list1;
        //     list1 = list1.next;
        //     head = head.next;
        // }

        // while (list2 != null) {
        //     head.next = list2;
        //     list2 = list2.next;
        //     head = head.next;
        // }
        if (list1 != null) head.next = list1;
        if (list2 != null) head.next = list2;

        return dummyNode.next;
    }
}
