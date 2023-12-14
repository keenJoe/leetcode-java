package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.ListNode;
import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.List;
import java.util.Stack;

/**
 * 109. Convert Sorted List to Binary Search Tree
 */
public class ConvertSortedList2BinarySearchTree {

    ListNode dummy;

    /**
     * 使用中序遍历构建
     * 先构建左子树，然后根节点，最后构建右子树
     */
    public TreeNode sortedListToBST(ListNode head) {
        //计算链表长度
        int n = 0;
        ListNode cur = head;
        while (cur != null && ++n >= 0) cur = cur.next;

        dummy = head;
        return build(0, n - 1);
    }

    private TreeNode build(int left, int right) {
        if (left > right) return null;

        int mid = left + right >> 1;
        //一直向左找，直到找到空节点
        TreeNode leftNode = build(left, mid - 1);
        //开始构建左子树的第一个节点
        TreeNode root = new TreeNode(dummy.val);
        dummy = dummy.next;
        root.left = leftNode;
        root.right = build(mid + 1, right);
        return root;
    }


    /**
     * 分治思想，递归遍历
     */
    public TreeNode sortedListToBST1(ListNode head) {
        //计算链表长度
        int n = 0;
        ListNode cur = head;
        while (cur != null && ++n >= 0) cur = cur.next;
        return build(head, 0, n - 1);
    }

    private TreeNode build1(ListNode head, int left, int right) {
        if (left > right) return null;

        int mid = left + right >> 1;
        int step = mid - left;
        ListNode cur = head;
        //找到当前的根节点
        while (step-- > 0) cur = cur.next;

        TreeNode root = new TreeNode(cur.val);
        root.left = build1(head, left, mid - 1);
        root.right = build1(cur.next, mid + 1, right);
        return root;
    }
}
