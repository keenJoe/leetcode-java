package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 92. Reverse Linked List II
 * @author XuQidong
 *
 * 第二次竟然没有做出来，上次做这道题是2021年6月17日
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int currentIndex = 1;
        ListNode current = head;
        ListNode prevTail = head;
        ListNode lastHead = null;

        /**
         * move the current to the positioin of left
         **/
        while(currentIndex < left){
            currentIndex ++;
            prevTail = current;
            current = current.next;
        }

        ListNode prev = null;
        ListNode temp = null;

        while(currentIndex >= left && currentIndex <= right){
            //next node of current;
            temp = current.next;

            if(prev == null){
                lastHead = current;
            }

            current.next = prev;
            prev = current;

            //last node or null
            current = temp;
            currentIndex++;
        }

        if(left == 1){
            head = prev;
        } else {
            prevTail.next = prev;
        }
        lastHead.next = current;

        return head;
    }
}
