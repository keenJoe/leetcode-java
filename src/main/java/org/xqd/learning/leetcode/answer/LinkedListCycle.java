package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * @date 2021/6/9 12:33
 */
public class LinkedListCycle {
    public static void main(String[] args) throws InterruptedException {
//        ListNode node7 = new ListNode(8, null);
//        ListNode node6 = new ListNode(7, node7);
//        ListNode node5 = new ListNode(4, node6);
//        ListNode node4 = new ListNode(5, node5);
//        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(1, null);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = new ListNode(1, node1);
       // node7.resetNext(node3);

        ListNode temp = head;

//        while(temp != null){
//            System.out.println(temp.val);
//            temp = temp.next;
//            Thread.sleep(1000);
//        }

        LinkedListCycle cycle = new LinkedListCycle();
        boolean b = cycle.hasCycle(head);
        System.out.println(b);
    }

    /**
     * using two pointers
     * **/
    public boolean hasCycle(ListNode head) throws InterruptedException {
        ListNode first = head;

        ListNode second = null;

        //少考虑了first为null的情况，造成了空指针异常runtime error
        if(first != null && first.next != null && first.next.next != null){
            second = first.next.next;
        }

        int count = 0;
        while(first != null && second != null){

            //遗漏了一种情况，就是1->1->1的情况
            if(first.val == second.val){
                count++;
                if(count > 1){
                    return true;
                }
            }

            first = first.next;
            if(second.next != null && second.next.next != null){
                second = second.next.next;
            } else {
                return false;
            }

            Thread.sleep(1000);
            System.out.println("********");
        }

        return false;
    }
}
