package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * 160. Intersection of Two Linked Lists
 */
public class IntersectionOfTwoLinkedLists {
    /**
     * 1 想到的第一种方案是从后向前找intersection
     * 2 分别统计出两个链表的长度，然后再找两个链表的intersection
     * 3 ToDo
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int aLength = linkedListLenth(headA);
        int bLength = linkedListLenth(headB);

        //headA 的长度大于 headB 的长度
        if (aLength - bLength > 0) {
            while (aLength - bLength > 0) {
                headA = headA.next;
                aLength--;
            }
        } else {
            while (bLength - aLength > 0) {
                headB = headB.next;
                bLength--;
            }
        }

        //到这里headA和headB的长度已经拉齐

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public int linkedListLenth(ListNode head){
        int length = 0;

        while (head != null) {
            length += 1;
            head = head.next;
        }

        return length;
    }
}
