package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 * @author qidongxu
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
