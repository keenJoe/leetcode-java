package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 19. Remove Nth Node From End of List
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = nodeLength(head);
        int removedIndex = length - n + 1;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = null;
        int curIndex = 1;
        while (curIndex < removedIndex) {
            //第一次版本，会导致每次删除指定节点的下一个节点，所以要先判断，再决定是否将head移动到下一个节点
//            head = head.next; //2 3 4
//            curIndex++;       //2 3 4

            curIndex++;       //2 3 4
            if (curIndex < removedIndex) {
                head = head.next; //2 3 4
            }
        }

        if (removedIndex == 1) {
            dummy.next = head.next;
        } else {
            pre = head;
            head = head.next;
            pre.next = head.next;
        }

        return dummy.next;
    }

    public int nodeLength(ListNode head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }


    /**
     * two pointers
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}
