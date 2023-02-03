package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * @date 2021/8/24 21:51
 */
public class RotateList {
    public static void main(String[] args) throws InterruptedException {
//        ListNode node6 = new ListNode(6, null);
//        ListNode node5 = new ListNode(5, node6);
//        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode head1 = new ListNode(1, node2);

        ListNode node = new RotateList().rotateRight(head1,4);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
            Thread.sleep(1000);
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        //计算旋转节点的位置
        ListNode tempNode = head;
        int length = calLength(tempNode);
        int position = 0;
        if(length > k){
            position = length - k + 1;
        } else {
            position = k - length;
        }

        if(position == length){
            return head;
        }

        System.out.println(position);

        ListNode realHeadNode =  new ListNode(0);
        realHeadNode.next = head;

        //找到rotate head的前一个节点
        int index = 1;
        while(index != position - 1 && head != null){
            head = head.next;
            index++;
        }

        //System.out.println("tailNode" + head.val);
        ListNode tailNode = head;
        //System.out.println("rotate node value is " + rotateNode.val);

        ListNode rotateNode = null;
        if(head != null){
            rotateNode = head.next;
            head.next = null;
        }

        System.out.println("  tail next " + tailNode.next);

        head = rotateNode;
        System.out.println("current head is "  + head.val);
        while (head.next != null){
            head = head.next;
        }

        ListNode realTailNode = head;
        System.out.println("real tail node value is " + realTailNode.val);
        realTailNode.next = realHeadNode.next;
        System.out.println("real tail node next node value now is " + realTailNode.next.val);

        System.out.println("rotate next node value is " + rotateNode.next.val);

        return rotateNode;
    }

    public int calLength(ListNode head){
        if(head == null) return 0;
        if(head != null && head.next == null) return 1;

        int length = 1;
        while(head.next != null){
            length++;
            head = head.next;
        }

        return length;
    }
}
