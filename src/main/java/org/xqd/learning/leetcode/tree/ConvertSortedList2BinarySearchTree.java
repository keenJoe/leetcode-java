package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.ListNode;
import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.Stack;

/**
 * 109. Convert Sorted List to Binary Search Tree
 */
public class ConvertSortedList2BinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        int length = getListNodeLength(head);
        int mid = length / 2;
        System.out.println(mid);

        ListNode temp = head;
        Stack<TreeNode> stack = new Stack<>();

        int index = 0;
        while (index < mid) {
            TreeNode treeNode = new TreeNode(temp.val);
            System.out.println(temp.val);
            stack.add(treeNode);
            temp = temp.next;
            index++;
        }

        TreeNode root = new TreeNode(temp.val);

        TreeNode left = root;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.val != root.val) {
                left.left = new TreeNode(pop.val);
                left = left.left;
            }
        }

        TreeNode right = root;
        while (temp != null) {
            if (temp.val != root.val) {
                right.right = new TreeNode(temp.val);
                right = right.right;
            }

            temp = temp.next;
        }

        return root;
    }

    public int getListNodeLength(ListNode head) {
        int legnth = 0;
        while (head != null) {
            legnth += 1;
            head = head.next;
        }
        return legnth;
    }
}
