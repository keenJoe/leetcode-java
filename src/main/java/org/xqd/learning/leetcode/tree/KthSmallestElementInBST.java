package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST
 */
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        int pre = 0;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();
            if (root != null && root.val != pre) {
                count++;
                pre = root.val;
            }
            if (count == k) {
                min = root.val;
                break;
            }

            root = root.right;
        }

        return min;
    }
}
