package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;
import org.xqd.learning.leetcode.pojo.TreeNode;

/**
 * @author XuQidong
 * @date 2021/6/11 19:31
 *
 * 82. Remove Duplicates from Sorted List II
 */
public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) throws InterruptedException {
        ListNode node6 = new ListNode(5, null);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);

        RemoveDuplicatesFromSortedListII removeDuplicatesFromSortedListII = new RemoveDuplicatesFromSortedListII();
        ListNode listNode = removeDuplicatesFromSortedListII.deleteDuplicates(head);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
            Thread.sleep(1000);
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode preNode = new ListNode();
        preNode.next = head;

        while (head != null) {
            ListNode next = head.next;
            if (next != null) {
                if (head.val == next.val) {

                } else {

                }
            }
        }

        return preNode.next;
    }










    public ListNode deleteDuplicates1(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        ListNode pre = dummyNode;
        pre.next = head;
        ListNode curr = head;
        ListNode after = head != null ? head.next : null;
        boolean isCycle = false;

        while(curr != null && after != null){
            if(curr.val == after.val){
                curr = curr.next;
                after = after.next;
                isCycle = true;
            } else {
                if(isCycle){
                    pre.next = after;
                    isCycle = false;
                } else {
                    pre = curr;
                }

                curr = curr.next;
                after = after.next;
            }
        }

        if(curr != null && !isCycle){
            pre.next = curr;
        } else {
            pre.next = null;
        }

        return dummyNode.next;
    }
}
