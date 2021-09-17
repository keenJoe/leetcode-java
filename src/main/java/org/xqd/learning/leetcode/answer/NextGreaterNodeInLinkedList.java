package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * @date 2021/8/31 07:31
 */
public class NextGreaterNodeInLinkedList {
    public static void main(String[] args) {

    }

    public int[] nextLargerNodes(ListNode head) {
        int length = calLength(head);
        int[] result = new int[length];
        int maxValue = 0;

        for (int i = 0; i < length; i++) {
            int value  = 0;
            if(head != null) {
                value = head.val;
            }

            ListNode next = head.next;
            if (next != null && next.val > value) {
                result[i] = next.val;
            } else {
                result[i] = 0;
            }

            head = head.next;
        }

        return null;
    }

    public int calLength(ListNode head) {
        if (head == null) return 0;
        if (head.next == null) return 1;

        int length = 1;
        while (head.next != null) {
            length++;
            head = head.next;
        }

        return length;
    }
}
