package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

import java.util.Stack;

/**
 * @author XuQidong
 * @date 2021/8/31 06:18
 */
public class AddTwoNumbers2 {
    public static void main(String[] args) throws InterruptedException {
        //        ListNode nodeA8 = new ListNode(9, null);
//        ListNode nodeA7 = new ListNode(8, nodeA8);
//        ListNode nodeA6 = new ListNode(7, nodeA7);
//        ListNode nodeA5 = new ListNode(6, nodeA6);
        ListNode nodeA4 = new ListNode(5, null);
        ListNode nodeA3 = new ListNode(4, nodeA4);
        ListNode nodeA2 = new ListNode(8, nodeA3);
        ListNode nodeA1 = new ListNode(1, nodeA2);
        ListNode headA = new ListNode(4, nodeA1);

//        ListNode nodeB8 = new ListNode(9, null);
//        ListNode nodeB7 = new ListNode(8, nodeB8);
//        ListNode nodeB6 = new ListNode(7, nodeB7);
        ListNode nodeB5 = new ListNode(5, null);
        ListNode nodeB4 = new ListNode(4, nodeB5);
        ListNode nodeB3 = new ListNode(8, nodeB4);
        ListNode nodeB2 = new ListNode(1, nodeB3);
        ListNode nodeB1 = new ListNode(6, nodeB2);
        ListNode headB = new ListNode(5, nodeB1);

        ListNode node = new AddTwoNumbers2().addTwoNumbers(headA,headB);

        while (node != null) {
            System.out.println(node.val);
            Thread.sleep(1000);
            node = node.next;
        }
    }

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

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ListNode node1 = stack1.pop();
            ListNode node2 = stack2.pop();
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

        while (!stack1.isEmpty()) {
            ListNode node1 = stack1.pop();
            int value = node1.val + carry;
            if (value >= 10) {
                carry = 1;
                value = value - 10;
            } else {
                carry = 0;
            }

            ListNode newNode = new ListNode(value);
            result.add(newNode);
        }

        while (!stack2.isEmpty()) {
            ListNode node2 = stack2.pop();
            int value = node2.val + carry;
            if (value >= 10) {
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
}
