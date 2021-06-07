package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * @date 2021/6/7 18:18
 */
public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) throws InterruptedException {
//        ListNode node6 = new ListNode(7, null);
//        ListNode node5 = new ListNode(6, node6);
//        ListNode node4 = new ListNode(5, node5);
//        ListNode node3 = new ListNode(4, node4);
//        ListNode node2 = new ListNode(3, node3);
        //ListNode node1 = new ListNode(2, null);
        ListNode head = new ListNode(1, null);

        ListNode node = removeNthFromEnd(head,1);

        while (node != null){
            System.out.println(node.val);
            node = node.next;
            Thread.sleep(1000);
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = findLinkedListLength(head);
        System.out.println("长度: " + length);

        int k = length - n + 1;
        System.out.println("k值: " + k);

        if(k == 1){
            return head.next;
        }

        ListNode tempHead = head;
        int currentPosition = 1;
        ListNode beforeNode = null;
        ListNode afterNode = null;

        while(tempHead != null){
            if(currentPosition == k - 1){
                beforeNode = tempHead;
            }

            if(currentPosition == k + 1){
                afterNode = tempHead;
            }

            currentPosition++;
            tempHead = tempHead.next;
        }

        beforeNode.next = afterNode;

        return head;
    }

    public static int findLinkedListLength(ListNode head){
        if(head == null){
            return 0;
        }

        return findLinkedListLength(head.next) + 1;
    }
}
