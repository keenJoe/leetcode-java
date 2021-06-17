package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * @date 2021/6/12 20:56
 */
public class LinkedListCycleII {
    public static void main(String[] args){

    }

    public ListNode detectCycle(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        ListNode pre = dummyNode;
        pre.next = head;

        return dummyNode.next;
    }
}
