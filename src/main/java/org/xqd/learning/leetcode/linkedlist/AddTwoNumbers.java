package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 2. Add Two Numbers
 */
public class AddTwoNumbers {
    /**
     * @param l1
     * @param l2 两数相加，要记录进位，更新已有的链表，这样可以节省空间
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode head = new ListNode();
        dummy = head;

        ListNode head1 = l1;
        ListNode head2 = l2;

        /**
         * 两个同时不为空，开始进行相加计算
         */
        int carry = 0;
        ListNode previousNode = null;

        while (head1 != null && head2 != null) {
            int sum = head1.val + head2.val + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }

            ListNode temp = new ListNode();
            temp.val = sum;
            head.next = temp;
            head = head.next;

            head1 = head1.next;
            head2 = head2.next;
        }

        while (head1 != null) {
            int sum = head1.val + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }

            ListNode temp = new ListNode();
            temp.val = sum;
            head.next = temp;
            head = head.next;

            head1 = head1.next;
        }

        while (head2 != null) {
            int sum = head2.val + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }

            ListNode temp = new ListNode();
            temp.val = sum;
            head.next = temp;
            head = head.next;

            head2 = head2.next;
        }


        if (carry != 0) {
            ListNode temp = new ListNode();
            temp.val = carry;
            head.next = temp;
        }

        return dummy.next;
    }
}
