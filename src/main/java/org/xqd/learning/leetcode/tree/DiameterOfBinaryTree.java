package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

public class DiameterOfBinaryTree {

    int maxPathLength = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        f(root);
        return maxPathLength;
    }


    private int f(TreeNode root) {
        if (root == null) return 0;

        int leftMax = f(root.left);
        int rightMax = f(root.right);

        if (leftMax + rightMax > maxPathLength) {
            maxPathLength = leftMax + rightMax;
        }

        return Math.max(leftMax, rightMax) + 1;
    }
}
