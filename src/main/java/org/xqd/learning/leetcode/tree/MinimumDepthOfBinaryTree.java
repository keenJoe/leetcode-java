package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

/**
 * @author qidongxu
 * <p>
 * 111. Minimum Depth of Binary Tree
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    public int minDepth(TreeNode root) {
        return 0;
    }
}
