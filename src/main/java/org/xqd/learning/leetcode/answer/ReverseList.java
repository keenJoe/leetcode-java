package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * @date 2021/3/19 23:42
 */
public class ReverseList {
    public static void main(String[] args){
        ListNode node4 = new ListNode(5,null);
        ListNode node3 = new ListNode(4,node4);
        ListNode node2 = new ListNode(3,node3);
        ListNode node1 = new ListNode(2,node2);
        ListNode head = new ListNode(1,node1);

        ListNode listNode = reverseList(head);

        while (listNode.next != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while(current != null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }
}
