package org.xqd.learning.leetcode.answer.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * LeetCode 148
 */
public class SortList {
    public static void main(String[] args) {
        ListNode node8 = new ListNode(8, null);
        ListNode node7 = new ListNode(9, node8);
        ListNode node6 = new ListNode(7, node7);
        ListNode node5 = new ListNode(2, node6);
        ListNode node4 = new ListNode(5, node5);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(4, node3);
        ListNode head1 = new ListNode(3, node2);

        ListNode listNode = sortList(head1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    //使用选择排序实现
    public static ListNode sortList(ListNode head) {
        if (head != null && head.next == null) return head;

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode unsortedHead = head;
        ListNode returnNode = dummyNode;

        while (unsortedHead != null) {
            ListNode minNode = unsortedHead;
            ListNode headOfLeftNodes = unsortedHead.next;
            ListNode t = unsortedHead.next;

            //寻找最小节点，应该sorted list 的tail
            ListNode preNode = null;
            ListNode nextNode = null;
            ListNode minPreNode = null;
            while (headOfLeftNodes != null) {
                if (headOfLeftNodes.val < minNode.val) {
                    //只需要记录最小节点的前一个节点就可以
                    minPreNode = preNode;
                    minNode = headOfLeftNodes;
                    nextNode = headOfLeftNodes.next;
                }

                //这里有问题，找到最小节点才记录preNode
                preNode = headOfLeftNodes;
                headOfLeftNodes = headOfLeftNodes.next;
            }

            //交换最小节点
            ListNode tempHead = dummyNode.next;
            tempHead.next = null;

            minNode.next = null;
            dummyNode.next = minNode;

            minPreNode.next = tempHead;
            tempHead.next = nextNode;

            unsortedHead =  t;
        }

        return returnNode;
    }
}
