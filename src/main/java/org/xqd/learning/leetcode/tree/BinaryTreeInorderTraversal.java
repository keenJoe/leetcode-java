package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 */
public class BinaryTreeInorderTraversal {

    /**
     * 二叉树的中序遍历
     * 非递归的方法
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.add(root);
        }

        /**
         * maybe add a or condition: root != null
         */
//        while (!stack.isEmpty()) {
//            //在这里陷入死循环了
//            TreeNode r1 = stack.pop();
//            if (r1.left != null) {
//                stack.add(r1);
//                stack.add(r1.left);
//            } else {
//                list.add(r1.val);
//                if (r1.right != null) {
//                    stack.add(r1.right);
//                }
//            }
//        }

        while(root != null || !stack.isEmpty()) {
            if (root.left != null) {
                stack.add(root.left);
                root = root.left;
            } else {
                list.add(root.val);
                if (root.right != null) {
                    stack.add(root.right);
                } else {
                    stack.pop();
                    root = stack.pop().right;
                }
            }
        }

        return list;
    }
}
