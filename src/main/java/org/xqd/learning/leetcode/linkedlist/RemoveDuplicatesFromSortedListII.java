package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode cur = head.next;
//        ListNode pre = null;
//        ListNode firstDuplicatedNode = null;
//
//        while (cur != null) {
//            //如果head和cur不重复，
//            if (head != cur) {
//                if (firstDuplicatedNode != null) {
//                    if (pre == null) {
//                        dummy.next = cur;
//                    } else {
//                        pre.next = cur;
//                    }
//
//                    firstDuplicatedNode = null;
//                } else {
//                    pre = head;
//                }
//            } else {
//                //如果head和cur重复
//                if (firstDuplicatedNode == null) {
//                    firstDuplicatedNode = head;
//                }
//            }
//
//            head = cur;
//            cur = cur.next;
//        }
//
//        if (firstDuplicatedNode != null && cur == null) {
//            if (pre == null) {
//                dummy.next = cur;
//            } else {
//                pre.next = cur;
//            }
//        }

        ListNode cur = head;
        ListNode pre = dummy;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }

                pre.next = cur.next;
            } else {
                pre = pre.next;
            }

            cur = cur.next;
        }

        return dummy.next;
    }
}
