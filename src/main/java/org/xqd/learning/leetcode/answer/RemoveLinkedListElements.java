package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * @date 2021/6/12 21:47
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) throws InterruptedException {
        ListNode node6 = new ListNode(2, null);
        ListNode node5 = new ListNode(2, node6);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(2, node1);

        ListNode listNode = removeElements(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
            Thread.sleep(1000);
        }

    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);
        ListNode pre = dummyNode;
        pre.next = head;

        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                //head = head.next;
            } else {
                pre = head;
                //head = head.next;
            }

            //确实可以再精进一下！！！代码似乎好看了，但是比原来慢了1ms！！！
            head = head.next;
        }

        return dummyNode.next;
    }
}
