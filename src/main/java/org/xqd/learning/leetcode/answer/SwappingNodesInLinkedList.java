package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * @date 2021/3/26 02:07
 */
public class SwappingNodesInLinkedList {

    public static void main(String[] args) throws InterruptedException {
//        ListNode node9 = new ListNode(9, null);
//        ListNode node8 = new ListNode(9, node9);
        ListNode node7 = new ListNode(0, null);
        ListNode node6 = new ListNode(3, node7);
        ListNode node5 = new ListNode(8, node6);
        ListNode node4 = new ListNode(1, node5);
        ListNode node3 = new ListNode(6, node4);
        ListNode node2 = new ListNode(8, node3);
        ListNode node1 = new ListNode(9, node2);
        ListNode head = new ListNode(7, node1);

        ListNode node = swapNodes(head, 8);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
            Thread.sleep(20);
        }
    }

    public static ListNode swapNodes(ListNode head, int k) {

        return head;
    }
}
