package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.Stack;

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


    public int sumOfLeftLeaves1(TreeNode root) {
        if (root != null && root.left == null && root.right == null) return 0;

        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();
            if (root != null && root.left == null && root.right == null) {
                sum += root.val;
            }

            root = root.right;
            //现在已经确定是右节点，如果还是一个右叶子节点，那么就不计算这个节点的值
            if (root != null && root.left == null && root.right == null) {
                root = null;
            }
        }
        return sum;
    }
}
