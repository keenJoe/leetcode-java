package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * @date 2021/6/11 19:31
 */
public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) throws InterruptedException {
//        ListNode node6 = new ListNode(5, null);
//        ListNode node5 = new ListNode(4, node6);
//        ListNode node4 = new ListNode(3, node5);
//        ListNode node3 = new ListNode(2, node4);
//        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, null);
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
        ListNode dummyNode = new ListNode(0);
        ListNode pre = dummyNode;
        pre.next = head;
        ListNode curr = head;
        ListNode after = head.next;
        boolean isCycle = false;

        while(curr != null && after != null){
            if(curr.val == after.val){
                System.out.println("相等");
                System.out.println("pre: " + pre.val);
                System.out.println("curr: " + curr.val);
                System.out.println("after: " + after.val);
                curr = curr.next;
                after = after.next;
                isCycle = true;
            } else {
                System.out.println("不相等");
                System.out.println("pre: " + pre.val);
                System.out.println("curr: " + curr.val);
                System.out.println("after: " + after.val);
                if(isCycle){
                    pre.next = after;
                    isCycle = false;
                } else {
                    pre = curr;
                }

                curr = curr.next;
                after = after.next;
            }

            System.out.println("*********");
        }
        if(curr != null && !isCycle){
            pre.next = curr;
        } else {
            pre.next = null;
        }

        return dummyNode.next;
    }
}
