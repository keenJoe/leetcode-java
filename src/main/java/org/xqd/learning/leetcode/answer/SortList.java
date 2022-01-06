package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * @date 2021/6/13 20:54
 */
public class SortList {
    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        ListNode pre = dummyNode;

        while (head.next != null) {
            ListNode curNode = head.next;
            ListNode preNext = pre.next;

            if (preNext.val > curNode.val) {
                pre.next = curNode;
                curNode.next = preNext;
            } else {
                preNext.next = curNode;
            }

            pre = pre.next;
        }

        return dummyNode.next;
    }
}
