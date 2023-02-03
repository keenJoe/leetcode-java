package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author XuQidong
 * @date 2021/6/14 09:50
 */
public class IntersectionOfTwoLinkedLists {
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

        ListNode node = getIntersectionNode(headA, headB);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
            Thread.sleep(1000);
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int lengthA = getLinkedListLength(headA);
        int lengthB = getLinkedListLength(headB);

        if (lengthA - lengthB > 0) {
            for (int i = 0; i < lengthA - lengthB; i++) headA = headA.next;
        } else {
            for (int i = 0; i < lengthB - lengthA; i++) headB = headB.next;
        }

//        if (diff > 0) {
//            while (diff != 0) {
//                headA = headA.next;
//                diff--;
//            }
//        } else {
//            while (diff != 0) {
//                headB = headB.next;
//                diff++;
//            }
//        }

        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public static int getLinkedListLength(ListNode head) {
        if (head == null) return 0;

        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }
}
