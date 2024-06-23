package org.xqd.learning.leetcode.linkedlist2024;

import org.xqd.learning.leetcode.pojo.ListNode;

import java.io.Serializable;

/**
 * 19. Remove Nth Node From End of List
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // if (n == 1) return head.next;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = null;
        int removedIndex = nodeLength(head) - n + 1;

        int i = 1;
        while (head != null) {
            if (i == removedIndex) {
                if (pre != null) {
                    pre.next = head.next;
                    break;
                } else {
                    dummy.next = head.next;
                }
            }
            pre = head;
            head = head.next;
            i++;
        }
        return dummy.next;
    }

    public int nodeLength(ListNode head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = nodeLength(head);

        //从cur开始遍历，保证整个链表只有一个的情况
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }

        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    //使用快慢指针删除节点
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
