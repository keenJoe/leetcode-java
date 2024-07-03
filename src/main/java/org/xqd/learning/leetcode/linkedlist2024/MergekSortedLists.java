package org.xqd.learning.leetcode.linkedlist2024;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 23. Merge k Sorted Lists
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode list : lists) {
            ans = mergeTwoLinkedList(ans, list);
        }

        return ans;
    }

    private ListNode mergeTwoLinkedList(ListNode ans, ListNode list) {
        if (ans == null || list == null) {
            return ans != null ? ans : list;
        }

        ListNode head = new ListNode();
        ListNode dummy = head;

        while (ans != null && list != null) {
            if (ans.val <= list.val) {
                head.next = ans;
                ans = ans.next;
            } else {
                head.next = list;
                list = list.next;
            }

            head = head.next;
        }

        if (ans != null) head.next = ans;
        if (list != null) head.next = list;

        return dummy.next;
    }
}
