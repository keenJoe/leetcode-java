package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

/**
 * 404. Sum of Left Leaves
 */
public class SumLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root != null && root.left == null && root.right == null) return 0;
        return dfs(root, true);
    }

    private int dfs(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        }

        int left = dfs(root.left, true);
        int right = dfs(root.right, false);
        return left + right;
    }
}
