package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * @date 2021/3/24 07:44
 */
public class ReverseLinkedListII {

    public static void main(String[] args){
        int index = 1;
        if(index >= 1 && index <= 2) System.out.println(index);
    }

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
            //prevTail = prev;
            head = prev;
            lastHead.next = current;
        } else {
            prevTail.next = prev;
            lastHead.next = current;
        }

        return head;

    }
}
