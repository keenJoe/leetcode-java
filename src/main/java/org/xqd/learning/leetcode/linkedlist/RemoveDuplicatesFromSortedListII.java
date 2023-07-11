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

    /**
     * 思路大致相同，但是这个方法会更简单一些
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        //use two pointers, slow - track the node before the dup nodes,
        // fast - to find the last node of dups.
        ListNode dummy = new ListNode(0), fast = head, slow = dummy;
        slow.next = fast;
        while (fast != null) {

            //while loop to find the last node of the dups.
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }

            //duplicates detected.
            if (slow.next != fast) {
                //remove the dups.
                slow.next = fast.next;
                //reposition the fast pointer.
                fast = slow.next;
            } else {
                //no dup, move down both pointer.
                slow = slow.next;
                fast = fast.next;
            }
        }

        return dummy.next;
    }
}
