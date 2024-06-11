package org.xqd.learning.leetcode.linkedlist2024;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 24. Swap Nodes in Pairs
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy;
        while (head != null) {
            //当前节点的下一个节点
            ListNode next = head.next;
            //当前节点的下下节点
            ListNode nextNext = null;
            if (next != null) {
                nextNext = next.next;
                //断开当前节点和下一个节点
                head.next = null;
                //让pre指向next指针
                pre.next = next;
                //让next的next指向head，至此完成两个节点的交换
                next.next = head;
                //让head的next指向nextNext，将断开的连个节点指回原链表
                head.next = nextNext;
                pre = head;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
