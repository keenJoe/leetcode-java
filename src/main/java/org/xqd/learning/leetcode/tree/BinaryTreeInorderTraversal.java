package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * @author qidongxu
 */
public class BinaryTreeInorderTraversal {

    /**
     * 二叉树的中序遍历
     * 非递归的方法
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if (root == null) return list;
//
//        if (root != null) {
//            list.addAll(inorderTraversal(root.left));
//        }
//
//        list.add(root.val);
//
//        if (root.right != null) {
//            list.addAll(inorderTraversal(root.right));
//        }
//
//        return list;
        //这个递归的版本才是正确的。root.left 是误打误撞的方法
        //递归一定对应while循环

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }
}
