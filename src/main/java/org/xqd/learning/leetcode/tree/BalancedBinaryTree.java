package org.xqd.learning.leetcode.tree;


import org.xqd.learning.leetcode.pojo.TreeNode;

/**
 * 110.Balanced Binary Tree
 * @author qidongxu
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.right);

        int abs = Math.abs(leftH - rightH);
        if (abs > 1) {
            return false;
        }

        boolean leftIsBst = isBalanced(root.left);
        boolean rightIsBst = isBalanced(root.right);

        return leftIsBst && rightIsBst;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
