package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.ListNode;
import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.Stack;

/**
 * 109. Convert Sorted List to Binary Search Tree
 */
public class ConvertSortedList2BinarySearchTree {

    /**
     * 分治思想，递归遍历
     */
    public TreeNode sortedListToBST(ListNode head) {
        //计算链表长度
        int n = 0;
        ListNode cur = head;
        while (cur != null && ++n >= 0) cur = cur.next;
        return build(head, 0, n - 1);
    }

    private TreeNode build(ListNode head, int left, int right) {
        if (left > right) return null;

        int mid = left + right >> 1;
        int step = mid - left;
        ListNode cur = head;
        //找到当前的根节点
        while (step-- > 0) cur = cur.next;

        TreeNode root = new TreeNode(cur.val);
        root.left = build(head, left, mid - 1);
        root.right = build(cur.next, mid + 1, right);
        return root;
    }
}
