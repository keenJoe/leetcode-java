package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * @date 2021/6/7 18:37
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) throws InterruptedException {
        ListNode node6 = new ListNode(7, null);
        ListNode node4 = new ListNode(5, node6);
        ListNode node2 = new ListNode(3, node4);
        ListNode head1 = new ListNode(1, node2);


        ListNode node5 = new ListNode(6, null);
        ListNode node3 = new ListNode(4, node5);
        ListNode node1 = new ListNode(2, node3);
        ListNode head2 = new ListNode(1, node1);

        ListNode node = mergeTwoLists(head1, head2);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
            Thread.sleep(1000);
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return dummyHead.next;
    }
}
