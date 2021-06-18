package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * @date 2021/6/13 20:54
 */
public class SortList {
    public static void main(String[] args) throws InterruptedException {
        ListNode node7 = new ListNode(8, null);
        ListNode node6 = new ListNode(9, node7);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(6, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(4, node3);
        ListNode node1 = new ListNode(3, node2);
        ListNode head = new ListNode(1, node1);

        SortList sortList = new SortList();
        ListNode listNode = sortList.sortList(head);

        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
            Thread.sleep(1000);
        }
    }

    public ListNode sortList(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        ListNode pre = dummyNode;
        pre.next = head;

        return dummyNode.next;
    }
}
