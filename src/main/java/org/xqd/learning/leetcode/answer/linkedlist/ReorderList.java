package org.xqd.learning.leetcode.answer.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * LeetCode 143
 */
public class ReorderList {

    public static void main(String[] args) throws InterruptedException {
        ListNode node8 = new ListNode(8, null);
        ListNode node7 = new ListNode(7, node8);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head1 = new ListNode(1, node2);

        reorderList(head1);
        while (head1 != null) {
            System.out.println(head1.val);
            head1 = head1.next;
        }
    }

    /**
     * without queue
     */
    public static void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        int index = 0;
        int length = getListLength(head);
        int stackStartIndex = length / 2 + 1;
        ListNode tempNode = head;
        ListNode tempNode1 = head;
        ListNode tempNode2 = head;
        ListNode preNode = null;

        while (tempNode != null) {
            if (index >= stackStartIndex) {
                //多个tempNode指向同一个head，只要其中给一个改变了head的结构，那么所有的其他node都会受影响，这就是指针。
                //通过这行代码，可以让再次之后的节点和链表断开
                preNode.next = null;
                stack.push(tempNode);
            }

            preNode = tempNode;
            tempNode = tempNode.next;
            index++;
        }

        index = 0;

        while (index < stackStartIndex) {
            if (!stack.isEmpty()) {
                ListNode temp = head.next;
                ListNode stackNode = stack.pop();
                stackNode.next = null;
                head.next = stackNode;
                head = head.next;
                head.next = temp;
            }

            //虽然现在1-->4-->2，但是2后面还跟着3，3后面还跟着4，4后面还跟着2，
            //通过preNode.next = null，断开之后的节点
            head = head.next;

            index++;
        }

        head = tempNode2;
    }

    /**
     * using stack he queue
     */
    public static void reorderList1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        Queue<ListNode> queue = new LinkedBlockingQueue<>();
        int index = 0;
        int length = getListLength(head);
        int stackStartIndex = length / 2 + 1;
        ListNode tempNode = head;

        while (tempNode != null) {
            if (index >= stackStartIndex) {
                stack.push(tempNode);
            } else {
                queue.offer(tempNode);
            }

            tempNode = tempNode.next;
            index++;
        }

        //两个node指向同一个地址，其中一个向后移动
        ListNode fakeHead = new ListNode();
        ListNode dummyNode = fakeHead;
        for (ListNode listNode : queue) {
            fakeHead.next = listNode;
            fakeHead = fakeHead.next;
            if (!stack.empty()) {
                fakeHead.next = stack.pop();
                fakeHead = fakeHead.next;
            }
        }

        //这一步很关键，否则就会形成死循环
        fakeHead.next = null;
        head = dummyNode.next;
    }

    public static int getListLength(ListNode head) {
        int count = 0;

        while (head != null) {
            count++;
            head = head.next;
        }

        return count;
    }
}
