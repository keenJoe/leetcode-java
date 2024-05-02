package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

/**
 * 112. Path Sum
 *
 * @author qidongxu
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root != null && root.val == targetSum && (root.left != null || root.right != null)) return false;
//
//        Stack<TreeNode> stack = new Stack<>();
//        int sum = 0;
////        TreeNode pre = null;
//        Set<TreeNode> set = new HashSet<>();
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                sum += root.val;
//                stack.push(root);
//                root = root.left;
//            }
//
//            TreeNode pop = stack.pop();
//            if (pop.left == null && pop.right == null) {
//                if (sum == targetSum ) {
//                    return true;
//                }
//                sum -= pop.val;
//            } else if (pop.left != null && pop.right == null) {
//                set.add(pop.left);
//                sum -= pop.val;
//                pop = stack.pop();
//            } else if (pop.left == null && pop.right != null) {
//
//            } else if (pop.left != null && pop.right != null) {
//                set.add(pop);
//                sum -= pop.val;
//                pop = stack.pop();
//            }
//
//            root = pop.right;
//        }
//
        return false;

    }

    public boolean f(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return false;
        }

        if (sum == targetSum && root.left == null && root.right == null) {
            return true;
        }

        f(root.left, sum + root.left.val, targetSum);
        sum -= root.left.val;
        f(root.right, sum + root.right.val, targetSum);
        return false;
    }
}
