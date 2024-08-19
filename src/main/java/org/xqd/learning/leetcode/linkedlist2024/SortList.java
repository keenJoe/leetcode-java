package org.xqd.learning.leetcode.linkedlist2024;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 148. Sort List
 */
public class SortList {
//    public ListNode sortList(ListNode head) {
//        if (head == null) return head;
//        ListNode dummy = new ListNode(Integer.MIN_VALUE);
//        while (head != null) {
//            int x = head.val;
//            if (dummy.next != null) {
//                ListNode node = dummy;
//                while (node != null) {
//                    int current = node.val;
//                    int nextValue = Integer.MAX_VALUE;
//                    if (node.next != null) {
//                        nextValue = node.next.val;
//                    }
//
//                    if (x >= current && x <= nextValue) {
//                        ListNode next = node.next;
//                        node.next = null;
//                        node.next = new ListNode(x);
//                        node.next.next = next;
//                        break;
//                    }
//
//                    node = node.next;
//                }
//            } else {
//                dummy.next = new ListNode(x);
//            }
//
//            head = head.next;
//        }
//
//        return dummy.next;
//    }


    //好好理解一下这个插入排序，不需要新建节点，只需要改变next指针的指向即可
    public ListNode sortList1(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode p = head;

        while (p != null) {
            ListNode temp = p.next;
            ListNode q = dummy;

            //找到可以插入的结束位置，确定待插入元素的下一个元素
            while (q.next != null && q.next.val < p.val) {
                q = q.next;
            }

            //开始插入，其实是将两个链表进行重新指向
            p.next = q.next;
            q.next = p;

            p = temp;
        }

        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        //1. 如果head的长度大于1，那么就需要拆分
        //2. 如果head的长度等于，则开始进行合并
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) return head;

        //在整个的归并排序中，tail使用都是null
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        //找中间节点
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            //fast 向前移动两步，只要fast 不等于tail，那么就不会是空指针
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode sort1 = sortList(head, mid);
        ListNode sort2 = sortList(mid, tail);
        return merge(sort1, sort2);
    }

    private ListNode merge(ListNode sort1, ListNode sort2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy, temp1 = sort1, temp2 = sort2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        if (temp1 != null) {
            temp.next = temp1;
        } else {
            temp.next = temp2;
        }

        return dummy.next;
    }
}
