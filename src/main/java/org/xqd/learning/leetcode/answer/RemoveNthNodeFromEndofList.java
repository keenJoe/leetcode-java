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

    /**
     * from discussion of leetocde
     * 如果只需要确定一个节点的位置，那么完全不需要计算list的长度，只需要通过一个值一直累加到n值就可以了
     * 这样避免了一次list计算会提高速度，降低了runtime和memory
     * 尽量减少无意义的变量和计算，这样都会降低runtime和memory
     * **/
    public ListNode removedNthFromEnd(ListNode head, int n){
        /**
         * 1. find target node to remove from the linked list.
         */
        int count = 1;
        ListNode cursor = head;
        ListNode target = head;
        int distanceFromTempToCursor = 0;
        while (cursor.next != null) {
            cursor = cursor.next;
            count++;

            if (distanceFromTempToCursor < n) {
                distanceFromTempToCursor++; // update distance.
            } else {
                target = target.next; // move target to keep the distance = n.
            }
        }

        if (n == count) {
            return head.next;
        }

        target.next = target.next.next; // remove the node.
        return head;
    }

    /**
     * 还有一种思路，是快慢节点的方式
     * 但是没有明白快慢节点的原理是什么！
     * **/
    public ListNode removedNthFromEnd2(ListNode head, int n) {
        ListNode slow=head,fast=head;

        for(int i=0;i<n;i++)
            fast=fast.next;

        if(fast==null)
            return head.next;

        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        slow.next=slow.next.next;

        return head;
    }
}
