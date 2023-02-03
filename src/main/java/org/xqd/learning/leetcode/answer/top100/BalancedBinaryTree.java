package org.xqd.learning.leetcode.answer.top100;

import org.xqd.learning.leetcode.pojo.TreeNode;

/**
 * LeetCode 110. Balanced Binary Tree
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        System.out.println(Math.abs(1 - 3));
    }

    public static class Info {
        public boolean isBST;
        public int height;

        public Info(boolean ib, int h) {
            this.isBST = ib;
            this.height = h;
        }
    }

    public Info getBstInfo(TreeNode x) {
        if (x == null) return new Info(true, 0);

        Info leftInfo = getBstInfo(x.left);
        Info rightInfo = getBstInfo(x.right);

        boolean ib = true;
        if (!leftInfo.isBST || !rightInfo.isBST || Math.abs(leftInfo.height - rightInfo.height) > 1) {
            ib = false;
        }

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(ib, height);
    }

    public boolean isBalanced(TreeNode root) {
        return getBstInfo(root).isBST;
    }
}
