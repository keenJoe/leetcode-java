package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * @author XuQidong
 * @date 2021/6/9 17:18
 */
public class AddTwoNumbers {
    public static void main(String[] args) throws InterruptedException {
        //ListNode node6 = new ListNode(7, null);
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(5, node5);
        ListNode node3 = new ListNode(6, node4);
        ListNode node2 = new ListNode(9, node3);
        ListNode node1 = new ListNode(9, node2);
        ListNode l1 = new ListNode(9, node1);

        ListNode node12 = new ListNode(7, null);
        ListNode node11 = new ListNode(5, node12);
        ListNode node10 = new ListNode(5, node11);
        ListNode node9 = new ListNode(4, node10);
        ListNode node8 = new ListNode(1, node9);
        ListNode node7 = new ListNode(1, node8);
        ListNode l2 = new ListNode(1, node7);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode node = addTwoNumbers.addTwoNumbers(l1, l2);

        while (node != null) {
            System.out.println("当前节点值为：" + node.val);
            node = node.next;
            Thread.sleep(1000);
        }
    }

    /**
     * 0. 使用dummyNode
     * 1. 两个head一同遍历
     * 2. 设置一个记录进位值的参数
     * 3. while循环结束处理单个list
     **/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode pre = dummyNode;
        dummyNode.next = pre;

        //when to clear the value of carry
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int quotient = sum / 10;
            int left = sum % 10;

            //carry = digit / 10; 一个语句解决了自己的if-else语句判断
            if (quotient != 0) {
                carry = quotient;
            } else {
                carry = 0;
            }

            ListNode newNode = new ListNode(left);
            pre.next = newNode;
            pre = pre.next;
            System.out.println("当前pre节点的值为：" + pre.val);

            l1 = l1.next;
            l2 = l2.next;
        }

        System.out.println("当前carry值为：" + carry);

        //solve the left nodes of list
        while (l1 != null) {
            System.out.println("l1 here");
            int sum = l1.val + carry;
            int quotient = sum / 10;
            int left = sum % 10;

            //carry = digit / 10;
            if (quotient != 0) {
                carry = quotient;
            } else {
                carry = 0;
            }

            ListNode newNode = new ListNode(left);
            pre.next = newNode;
            pre = pre.next;

            l1 = l1.next;
        }

        while (l2 != null) {
            System.out.println("l2 here");
            int sum = l2.val + carry;
            int quotient = sum / 10;
            int left = sum % 10;

            //carry = digit / 10;
            if (quotient != 0) {
                carry = quotient;
            } else {
                carry = 0;
            }

            ListNode newNode = new ListNode(left);
            pre.next = newNode;
            pre = pre.next;

            l2 = l2.next;
        }

        //其实这个很容易被遗漏
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            pre.next = newNode;
            pre = pre.next;
        }

        return dummyNode.next;
    }

    public ListNode addTwoNumbersByHandbook(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;

        /**
         * 我的解题思路和这个一样，只是它一个while循环解决了我的三个while循环
         * 既然三个while循环如此相像，那么一定能够提取出公共的部分
         * 😂
         * **/
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int digit = carry + x + y;
            carry = digit / 10;
            curr.next = new ListNode(digit % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
