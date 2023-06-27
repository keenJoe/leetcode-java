package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

import java.util.ArrayDeque;

/**
 * @description: 86. Partition List
 * @author: Joe
 * @create: 2023-06-26 23:35
 **/
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ArrayDeque<ListNode> lessQueue = new ArrayDeque<>();
        ArrayDeque<ListNode> greaterQueue = new ArrayDeque<>();

        while (head != null) {
            if (head.val >= x) {
                greaterQueue.add(head);
            } else {
                lessQueue.add(head);
            }

            head = head.next;
        }

        ListNode dummy = new ListNode();
        ListNode tempHead = new ListNode();
        dummy = tempHead;

        while (!lessQueue.isEmpty()) {
            tempHead.next = lessQueue.poll();
            tempHead = tempHead.next;
        }

        while (!greaterQueue.isEmpty()) {
            tempHead.next = greaterQueue.poll();
            tempHead = tempHead.next;
        }

        //如果没有这一步，会形成一个cycle
        tempHead.next = null;

        return dummy.next;
    }
}
