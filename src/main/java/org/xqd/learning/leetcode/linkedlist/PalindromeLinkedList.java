package org.xqd.learning.leetcode.linkedlist;


import org.xqd.learning.leetcode.pojo.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 234. Palindrome Linked List
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        int length = calLengthOfLinkedList(head);
        if (length <= 1) return true;
        char[] chars = convertLinkedList2Str(head).toCharArray();
        int L = 0;
        int R = chars.length - 1;

        while (L <= R) {
            if (chars[L] != chars[R]) {
                return false;
            }

            L++;
            R--;
        }

        return true;
    }

    public String convertLinkedList2Str(ListNode head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val);
            head = head.next;
        }

        return builder.toString();
    }

    public boolean isPalindrome1(ListNode head) {
        int length = calLengthOfLinkedList(head);
        if (length <= 1) return true;

        int index = 1;
        int mid = length / 2;
        int remainder = length % 2;

        Map<Integer, Integer> table = new HashMap<>();
        while (head != null) {
            if (remainder == 0) {
                if (index > mid) {
                    System.out.println(index + "---" + mid);
                    Integer key = table.get(length - index + 1);
                    if (key != null) {
                        if (key != head.val) return false;
                    } else {
                        return false;
                    }
                }
            } else {
                if (index > mid + 1) {
                    System.out.println(index + "---" + mid);
                    Integer key = table.get(length - index + 1);
                    if (key != null) {
                        if (key != head.val) return false;
                    } else {
                        return false;
                    }
                }
            }

            table.put(index, head.val);
            head = head.next;
            index++;
        }

        return true;
    }

    public int calLengthOfLinkedList(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
