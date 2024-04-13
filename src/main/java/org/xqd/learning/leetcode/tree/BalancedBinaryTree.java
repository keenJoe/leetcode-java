package org.xqd.learning.leetcode.tree;


import org.xqd.learning.leetcode.pojo.TreeNode;

/**
 * 110.Balanced Binary Tree
 *
 * @author qidongxu
 */
public class BalancedBinaryTree {
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.right);

        int abs = Math.abs(leftH - rightH);
        if (abs > 1) {
            return false;
        }

        boolean leftIsBst = isBalanced1(root.left);
        boolean rightIsBst = isBalanced1(root.right);

        return leftIsBst && rightIsBst;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(check(root.left) - check(root.right)) <= 1;
    }

    private int check(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        return Math.max(check(root.left), check(root.right)) + 1;
    }
}
