package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 783. Minimum Distance Between BST Nodes
 */
public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        int preValue = Integer.MAX_VALUE;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();
            if (preValue != Integer.MAX_VALUE) {
                if (root != null && Math.abs(root.val - preValue) < min) {
                    min = Math.abs(root.val - preValue);
                }

            }
            preValue = root.val;

            root = root.right;
            if (root != null && Math.abs(root.val - preValue) < min) {
                min = Math.abs(root.val - preValue);
            }
        }

        return min;
    }
}
