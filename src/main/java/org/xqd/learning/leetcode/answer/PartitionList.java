package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * @date 2021/8/16 22:09
 */
public class PartitionList {
    public static void main(String[] args) throws InterruptedException {
        ListNode node6 = new ListNode(2, null);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(4, node3);
        ListNode head1 = new ListNode(1, node2);

        ListNode listNode = new PartitionList().partition(head1, 3);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode partition(ListNode head, int x) throws InterruptedException {
        if (head == null || head.next == null) return head;

        ListNode lessThanLinkedListNode = new ListNode(0);
        ListNode firstNode = lessThanLinkedListNode;
        ListNode greaterThanLinkedListNode = new ListNode(0);
        ListNode interactionNode = greaterThanLinkedListNode;

        while (head != null) {
            if (head.val < x) {
                lessThanLinkedListNode.next = head;
                lessThanLinkedListNode = head;
            } else {
                greaterThanLinkedListNode.next = head;
                greaterThanLinkedListNode = head;
            }

            head = head.next;
        }

        greaterThanLinkedListNode.next = null;
        lessThanLinkedListNode.next = interactionNode.next;
        return firstNode.next;
    }

    public ListNode partition2(ListNode head, int x) throws InterruptedException {
        if (head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(0);
        ListNode lessThanLinkedListNode = new ListNode(0);
        dummyNode.next = lessThanLinkedListNode;

        ListNode greater = head;
        ListNode less = head;

        System.out.println("*******");

        ListNode temp = null;
        while (less != null) {
            System.out.println(less.val);
            if (less.val < x) {
                lessThanLinkedListNode.next = less;
                lessThanLinkedListNode = lessThanLinkedListNode.next;
            }

            less = less.next;

            if(less.val < x){
                temp = less;
            }
        }

        System.out.println("*******");

        while(greater != null){
            System.out.println(greater.val);
            greater = greater.next;
        }
//
//        while(greater != null){
//            System.out.println(greater.val);
//            if(greater.val >= x){
//                lessThanLinkedListNode.next = greater;
////                System.out.println(lessThanLinkedListNode.val);
//                lessThanLinkedListNode = lessThanLinkedListNode.next;
//            }
//
//            greater = greater.next;
//        }
//
//        lessThanLinkedListNode.next = null;

        return dummyNode.next;
    }
}
