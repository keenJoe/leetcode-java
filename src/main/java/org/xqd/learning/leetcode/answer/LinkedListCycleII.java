package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author XuQidong
 * @date 2021/6/12 20:56
 */
public class LinkedListCycleII {
    public static void main(String[] args){

    }

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        while(head != null){
            if(set.contains(head)){
                return head;
            } else {
                set.add(head);
                head = head.next;
            }
        }

        return null;
    }
}
