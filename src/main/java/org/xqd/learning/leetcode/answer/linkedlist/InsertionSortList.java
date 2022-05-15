package org.xqd.learning.leetcode.answer.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * LeetCode 147
 */
public class InsertionSortList {
    public static void main(String[] args) {
        ListNode node8 = new ListNode(8, null);
        ListNode node7 = new ListNode(9, node8);
        ListNode node6 = new ListNode(7, node7);
        ListNode node5 = new ListNode(2, node6);
        ListNode node4 = new ListNode(5, node5);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(4, node3);
        ListNode head1 = new ListNode(3, node2);

        ListNode listNode = insertionSortList(head1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head.next == null) return head;

        //从第二个node开始插入排序的遍历
        ListNode unsortedHead = head.next;

        ListNode sortedHead = head;
        //让sorted list 保持独立
        sortedHead.next = null;

        ListNode sortedHeadPre = null;

        ListNode dummySortedHead = head;

        ListNode tempHead = null;

        while (unsortedHead != null) {
            //find palce to insert
            while (sortedHead != null && unsortedHead.val > sortedHead.val) {
                if (sortedHeadPre == null) {
                    //保留第一个节点的信息
                    dummySortedHead = sortedHead;
                }
                sortedHeadPre = sortedHead;
                sortedHead = sortedHead.next;
            }

            //has found the place to insert
            if (sortedHeadPre == null) {
                ListNode tempSortedHead = sortedHead;
                ListNode tempUnsortedHead = unsortedHead.next;
                //让节点保持独立，和后续的next断开
                unsortedHead.next = null;

                sortedHead = unsortedHead;
                sortedHead.next = tempSortedHead;

                unsortedHead = tempUnsortedHead;
            } else {
                ListNode tempUnsortedHead = unsortedHead.next;
                unsortedHead.next = null;
                sortedHeadPre.next = unsortedHead;

                if (sortedHead != null) {
                    unsortedHead.next = sortedHead;
                }

                sortedHead = dummySortedHead;
                unsortedHead = tempUnsortedHead;
            }

            tempHead = sortedHead;
            sortedHeadPre = null;
        }

        return tempHead;
    }
}
