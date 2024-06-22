package org.xqd.learning.leetcode.linkedlist2024;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @description: 143. Reorder List
 * @author: Joe
 * @create: 2024-06-22 14:33
 **/
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        int length = calLength(head);
        int mid = 0;
        if (length % 2 == 0) {
            mid = length / 2;
        } else {
            mid = length / 2 + 1;
        }

        ListNode temp = head;
        ListNode half = new ListNode();
        int index = 0;
        ListNode pre = null;
        while (index <= mid) {
            pre = temp;
            temp = temp.next;
            index++;
        }

        pre.next = null;
        half.next = temp;

        //旋转节点
        ListNode head1 = half.next;
        while (head1 != null) {
            ListNode next = head1.next;
            head1.next = null;

            ListNode nextNext = null;
            if (next != null) {
                nextNext = next.next;
                next.next = null;
                head1.next = nextNext;
                half.next = next;
                next.next = head1;
                head1 = next.next;
            }
        }


        //合并两个链表
        ListNode t2 = half.next;
        while (head != null && t2 != null) {
            ListNode mergedNode = t2;
            ListNode next = head.next;
            head.next = mergedNode;
            mergedNode.next = next;
            head = next.next;
            t2 = t2.next;
        }

    }

    /**
     * 确认链表的中间节点
     * 1、先计算链表的长度
     * 2、使用双指针的方式
     */
    public int calLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }
}
