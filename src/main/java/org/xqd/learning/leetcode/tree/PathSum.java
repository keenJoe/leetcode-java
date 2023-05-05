package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.ListNode;
import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.*;

/**
 * 112. Path Sum
 *
 * @author qidongxu
 */
public class PathSum {
    public static void main(String[] args) {
//        TreeNode head = new TreeNode(5);
//        head.left = new TreeNode(4);
//        head.right = new TreeNode(8);
//
//        head.left.left = new TreeNode(11);
//        head.left.left.left = new TreeNode(7);
//        head.left.left.right = new TreeNode(2);
//
//        head.right.left = new TreeNode(13);
//        head.right.right = new TreeNode(4);
//
//        head.right.right.right = new TreeNode(1);

//        TreeNode head = new TreeNode(1);
//        head.left = new TreeNode(2);
//        head.right = new TreeNode(3);

        TreeNode head = new TreeNode(1);
        head.right = new TreeNode(2);
        head.right.right = new TreeNode(3);
        head.right.right.right = new TreeNode(4);
        head.right.right.right.right = new TreeNode(5);

        boolean b = hasPathSum(head, 3);
        System.out.println(b);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
//        while (root != null || !stack.isEmpty()) {
//            System.out.println("当前栈: " + stack);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//            while (root != null) {
//                stack.add(root);
//                sum += root.val;
//                root = root.left;
//            }
//
//            System.out.println("总和" + sum);
//
//            //如果这个节点不是叶子节点，那么不行
//            root = stack.peek();
//            if (pre != null && pre == root) {
//                sum -= pre.val;
//                stack.pop();
//                root = stack.peek();
//            }
//
//            if (root.left == null && root.right == null) {
////                sum += root.val;
//                if (sum == targetSum) {
//                    return true;
//                } else {
//                    sum -= root.val;
//                    root = stack.pop();
//                }
//            } else {
//                if (root.left != null && root.right != null) {
//                    pre = root;
//                }
//            }
//
//            root = root.right;
//        }

        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            sum += pop.val;
            if (pop.left == null && pop.right == null) {
                if (targetSum == sum) {
                    return true;
                }
            }

            if (pop.right != null) {
                stack.push(pop.right);
            }

            if (pop.left != null) {
                stack.push(pop.left);
            }
        }

        return false;
    }
}
