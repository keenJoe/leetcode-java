package org.xqd.learning.leetcode.linkedlist2024;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 23. Merge k Sorted Lists
 */
public class MergekSortedLists {
    /**
     * 顺序合并：用一个变量 ans 来维护以及合并的链表，第 i 次循环把第 i 个链表和 ans 合并，答案保存到 ans 中。
     */
    public ListNode mergeKLists1(ListNode[] lists) {
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

    /**
     * 148 是将一个链表拆成两部分，这道题将集合拆成两部分
     * 只是拆分的时候不同，最后合并的时候一致
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKListsByLength(lists, 0, lists.length - 1);
    }

    private ListNode mergeKListsByLength(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];

        if (start > end) return null;

        int middle = (start + end) >> 1;
        return merge(mergeKListsByLength(lists, start, middle), mergeKListsByLength(lists, middle + 1, end));
    }

    private ListNode merge(ListNode listNode1, ListNode listNode2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy, temp1 = listNode1, temp2 = listNode2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        if (temp1 != null) {
            temp.next = temp1;
        } else {
            temp.next = temp2;
        }

        return dummy.next;
    }
}
