package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author XuQidong
 * @date 2021/6/8 19:06
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) throws InterruptedException {
//        ListNode node6 = new ListNode(7, null);
//        ListNode node5 = new ListNode(5, node6);
//        ListNode node4 = new ListNode(5, node5);
//        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(1, null);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = new ListNode(1, node1);

        ListNode node = deleteDuplicates(head);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
            Thread.sleep(1000);
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();

        ListNode dummyHead = new ListNode(0);
        ListNode p = head;
        ListNode pre = null;
        dummyHead.next = p;

        while (p != null) {
            boolean contains = set.contains(p.val);
            System.out.println(contains);
            if (contains) {
                if (p.next != null) {
                    ListNode temp = p;
                    pre.next = p.next;
                    p = temp.next;
                } else {
                    //p = p.next;
                    System.out.println(pre.val);
                    System.out.println(p.val);
                    System.out.println(p.next);
                    //pre.next = p.next;
                    p = p.next;
                    pre.next = p;
                }
            } else {
                set.add(p.val);
                pre = p;
                p = p.next;
            }

            System.out.println("********");
        }

        return dummyHead.next;
    }
}
