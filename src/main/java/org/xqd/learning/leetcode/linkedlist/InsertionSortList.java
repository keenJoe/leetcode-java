package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 147. Insertion Sort List
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null) {
            if (curr.val < prev.val) {
                ListNode temp = dummy;
                while (temp.next.val < curr.val) {
                    temp = temp.next;
                }

                //跳过cur节点，和后面的节点连接
                prev.next = curr.next;

                //temp比cur小，但是temp.next比cur大
                curr.next = temp.next;
                temp.next = curr;

                //回到未排序的链表的第一个节点
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
