package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * @date 2021/3/24 12:46
 */
public class SwapNodesInPairs {

    public static void main(String[] args) throws InterruptedException {
        ListNode node3 = new ListNode(4,null);
        ListNode node2 = new ListNode(3,node3);
        ListNode node1 = new ListNode(2,node2);
        ListNode head = new ListNode(1,node1);

        ListNode node = swapPairs(head);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode swapPairs(ListNode head) throws InterruptedException {
        if (head == null || head.next == null) return head;

        ListNode currentNode = head;
        ListNode temp = null;
        ListNode dummyNode = null;
        ListNode prev = null;

        while (currentNode != null && currentNode.next != null) {
            dummyNode = currentNode.next;

            if(temp == null){
                head = dummyNode;
            }

            /**
             * reverse linked list
             * **/
            temp = dummyNode.next;
            dummyNode.next = currentNode;
            if(prev != null){
                prev.next = dummyNode;
            }

            /**
             * connect linked list
             * **/
            if(temp != null) {
                currentNode.next = temp;
                /**
                 * next node
                 * **/
                prev = currentNode;
                currentNode = prev.next;
            } else {
                currentNode.next = null;
                return head;
            }
        }

        return head;
    }
}
