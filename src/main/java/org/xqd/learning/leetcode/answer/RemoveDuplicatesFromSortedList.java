package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

import java.util.*;
import java.util.prefs.PreferenceChangeEvent;

/**
 * @author XuQidong
 * @date 2021/6/8 19:06
 *
 * 83. Remove Duplicates from Sorted List
 */
public class RemoveDuplicatesFromSortedList {

    /**
     * 链表删除问题，一定要保留当前节点的前一个节点
     * 链表删除重复节点问题一定要确认后续节点没有重复元素再移动当前的节点。 ​​​
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode preNode = head;

        //忘记了判空
        while (head != null && head.next != null) {
            ListNode curNode = head.next;

            //忘记了判空
            while (curNode != null && curNode.val == preNode.val) {
                curNode = curNode.next;
            }

            preNode.next = curNode;
            preNode = curNode;
            head = curNode;
        }

        return dummy.next;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return head;
        ListNode dummyNode = head;

        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return dummyNode;
    }
}
