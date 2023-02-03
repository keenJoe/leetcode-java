package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * @date 2021/8/5 21:03
 */
public class MergeInBetweenLinkedLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if (list1 == null || list2 == null) return null;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = list1;

        ListNode nodeA = null;
        ListNode nodeB = null;
        int i = 0;
        for (i = 0; i < a - 1; i++) list1 = list1.next;
        nodeA = list1;

        for (i++; i <= b; i++) list1 = list1.next;
        nodeB = list1.next;

        ListNode head2 = list2;
        ListNode tail = null;
        while (list2 != null && list2.next != null) {
            list2 = list2.next;
        }

        tail = list2;

        nodeA.next = head2;
        tail.next = nodeB;

        return dummyNode.next;
    }

    public static int getListLength(ListNode head) {
        int count = 0;

        while (head != null) {
            count++;
            head = head.next;
        }

        return count;
    }
}
