package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.Stack;

/**
 * 112. Path Sum
 *
 * @author qidongxu
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack();
        TreeNode curr = root;
        int sum = 0;

        while (curr != null || !nodeStack.isEmpty()) {
            while (curr != null) {
                sum += curr.val;
                nodeStack.push(curr);
                sumStack.push(sum);
                curr = curr.left;
            }

            curr = nodeStack.pop();
            sum = sumStack.pop();

            if (curr.left == null && curr.right == null && sum == targetSum) {
                return true;
            }

            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = null;
            }
        }

        return false;
    }
}
