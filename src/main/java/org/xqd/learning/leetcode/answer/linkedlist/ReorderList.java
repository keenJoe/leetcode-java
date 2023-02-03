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
     * TODO
     */
    public static void reorderList(ListNode head) {
        int index = 0;
        int length = getListLength(head);
        int stackStartIndex = length / 2 + 1;
        ListNode tempNode = head;
        ListNode tempNode1 = head;
        ListNode tempNode2 = head;
        ListNode preNode = null;
        ListNode fakeHead = new ListNode();
        ListNode dummyNode = fakeHead;

        while (tempNode != null) {
            if (index >= stackStartIndex) {
                preNode.next = null;
                dummyNode.next = tempNode;
                dummyNode = dummyNode.next;
            }

            preNode = tempNode;
            tempNode = tempNode.next;
            index++;
        }

        int fakeLength = getListLength(fakeHead.next);
        index = 0;
        fakeHead = fakeHead.next;
        while (index < fakeLength) {
            ListNode tempNext = tempNode1.next;  //2,
            ListNode fakeNext = fakeHead.next;   //7
            fakeHead.next = null;

            tempNode1.next = fakeHead;    //8,
            tempNode1 = tempNode1.next;   //8,
            tempNode1.next = tempNext;    //8-->2
            tempNode1 = tempNode1.next;

            index++;
        }

        head = tempNode2;
    }

    /**
     * 快慢指针思想
     */
    public void reorderList3(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }//slow is preMid

        ListNode preMid = slow;
        ListNode cur = slow.next;//cur is mid
        while(cur.next != null){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = preMid.next;
            preMid.next = next;
        }

        ListNode p1 = head;
        ListNode p2 = preMid.next;

        while(p1 != preMid){
            preMid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMid.next;
        }
    }

    /**
     * without queue
     */
    public static void reorderList2(ListNode head) {
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
