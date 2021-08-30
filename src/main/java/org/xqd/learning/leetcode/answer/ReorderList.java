package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author XuQidong
 * @date 2021/8/17 00:11
 */
public class ReorderList {

    public static void main(String[] args) throws InterruptedException {
        ListNode node6 = new ListNode(6, null);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head1 = new ListNode(1, node2);

        ListNode listNode = new ReorderList().reorderList(head1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
            Thread.sleep(1000);
        }
    }

    public ListNode reorderList(ListNode head) {
        int length = getListLength(head);
        int position = length / 2;

        Stack<ListNode> stack = new Stack<>();
        LinkedList<ListNode> linkedList = new LinkedList<>();

        int index = 0;
        while (index < length) {
            if (index >= position) {
                stack.add(head);
            } else {
                linkedList.add(head);
            }

            head = head.next;
            index++;
        }

        ListNode dummyNode = new ListNode(0);
        ListNode pre = dummyNode;
        while (!stack.isEmpty()) {
            ListNode lNode = linkedList.pop();
            System.out.println(lNode.val);
            ListNode sNode = stack.pop();
            System.out.println(sNode.val);

            lNode.next = sNode;
            dummyNode.next = lNode;
            dummyNode = dummyNode.next.next;
            System.out.println("******");
        }

        return pre.next;
//        return null;
    }

    public int getListLength(ListNode head) {
        int count = 0;

        while (head != null) {
            count++;
            head = head.next;
        }

        return count;
    }
}
