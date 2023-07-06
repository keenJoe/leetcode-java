package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

import java.util.Stack;

/**
 * 445. Add Two Numbers II
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        Stack<ListNode> result = new Stack<>();

        while (l1 != null) {
            stack1.add(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.add(l2);
            l2 = l2.next;
        }

        int carry = 0;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ListNode node1 = new ListNode(0);
            if (!stack1.isEmpty()) {
                node1 = stack1.pop();
            }

            ListNode node2 = new ListNode(0);
            if (!stack2.isEmpty()) {
                node2 = stack2.pop();
            }

            int value = node1.val + node2.val + carry;
            if(value >= 10) {
                carry = 1;
                value = value - 10;
            } else {
                carry = 0;
            }

            ListNode newNode = new ListNode(value);
            result.add(newNode);
        }

        if(carry != 0) {
            ListNode node = new ListNode(carry);
            result.add(node);
        }

        ListNode head = new ListNode(0);
        ListNode dummy = head;
        while (!result.isEmpty()) {
            head.next = result.pop();
            head = head.next;
        }

        return dummy.next;
    }

    public int length(ListNode head){
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }
}
