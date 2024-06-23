package org.xqd.learning.leetcode.linkedlist2024;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 21. Merge Two Sorted Lists
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode dummy = head;
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

        if (list1 != null) head.next = list1;
        if (list2 != null) head.next = list2;
        return dummy.next;
    }

    /**
     * 递归
     * 两个链表合并，当前两个节点进行比较，小的节点在前。
     * 那么小的next节点就是两个链表剩余部分的合并。也就是第一个链表的head.next 和第二个链表的head开始进行比较。
     * 这样就开始了递归。
     * <p>
     * 终止条件就是两个链表全都是null
     */

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        //一定要注意，如果其中一个链表是null，那么返回另外一个链表。等于把另外一个链表完全连接到next
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val <= list2.val) {
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
        //至于最后返回list1还是list2，由两个链表的头结点决定
    }
}
