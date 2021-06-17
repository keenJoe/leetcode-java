package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * @date 2021/3/26 02:07
 */
public class SwappingNodesInLinkedList {

    public static void main(String[] args) throws InterruptedException {
        ListNode node6 = new ListNode(7, null);
        ListNode node5 = new ListNode(6, node6);
        ListNode node4 = new ListNode(5, node5);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);

        //index = 1,2,3,4
        ListNode node = swapNodes(head, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
            Thread.sleep(1000);
        }
    }

    public static ListNode swapNodes(ListNode head, int k) {

        if(head.next == null && k == 1)
        {
            return head;
        }

        int length = 0;
        ListNode headL = head;
        //figure out the number of linked list
        while(headL != null)
        {
            length++;
            headL = headL.next;
        }
        System.out.println("当前链表长度为: " + length);

        //figure out two node position
        int p = length - k + 1;
        int cp = 1;
        ListNode firstNode = null;
        ListNode secondeNode = null;

        ListNode tempHead = head;
        while(tempHead != null)
        {
            if(cp == k)
            {
                firstNode = tempHead;
            }

            if(cp == p)
            {
                secondeNode = tempHead;
            }

            cp++;
            tempHead = tempHead.next;
        }

        int value = secondeNode.val;
        secondeNode.val = firstNode.val;
        firstNode.val = value;

        return head;
    }
}
