package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

import java.awt.*;

/**
 * @author XuQidong
 * @date 2021/6/14 09:52
 */
public class MiddleOfTheLinkedList {
    public static void main(String[] args) throws InterruptedException {
        ListNode node8 = new ListNode(9, null);
        ListNode node7 = new ListNode(8, node8);
        ListNode node6 = new ListNode(7, node7);
        ListNode node5 = new ListNode(6, node6);
        ListNode node4 = new ListNode(5, node5);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);

        ListNode node = middleNode2(head);

        while(node != null){
            System.out.println(node.val);
            node = node.next;
            Thread.sleep(1000);
        }
    }

    private static ListNode middleNode2(ListNode head) {
        if (head == null || head.next == null) return head;
        int count = 0;
        //ListNode dummyNode = new ListNode(0);
        ListNode pre = head;
        //pre.next = head;

        while(head != null){
            head = head.next;
            count++;
        }

        int middle = count / 2 + 1;
        System.out.println(middle);

        while (middle != 1){
            pre = pre.next;
            System.out.println(pre.val);
            middle--;
        }

        System.out.println("******");

        return pre;
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode firstPointer = head;
        ListNode secondPointer = null;
        if (head.next.next != null) {
            //向后找到第四个node
            secondPointer = head.next.next.next;
        } else {
            return head.next;
        }

        if (secondPointer == null) {
            return head.next;
        }

        if(secondPointer.next == null){
            return head.next.next;
        }

        int first = 1;
        int second = 4;

        while (firstPointer.next != null && secondPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
            first++;
            second++;
        }

        System.out.println(first);
        System.out.println(second);
        System.out.println("***********");

        if(second % first == 0 || second / 2 == first){
            firstPointer = firstPointer.next;
        }

        return firstPointer;
    }
}
