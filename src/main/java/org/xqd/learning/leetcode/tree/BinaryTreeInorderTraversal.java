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

    //使用栈模拟递归
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            //模拟在递归中一直向左遍历
            while (root != null) {
                stack.add(root);
                root = root.left;
//                list.add(root.val);
            }
            //已经走到最左的节点
            TreeNode node = stack.peek();
            list.add(node.val);
            root = node.right;
        }

        return list;
    }

    public static List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return f(root,list);
    }

    private static List<Integer> f(TreeNode root, List<Integer> list) {
        if (root == null) return list;

        if (root.left != null) f(root.left,list);
        list.add(root.val);
        if (root.right != null) f(root.right,list);
        return list;
    }


    /**
     * 二叉树的中序遍历
     * 非递归的方法
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
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

    //使用线索化二叉树的方法

    /**
     * 如果一个节点可能来到两次，那么第二次来到该节点的时候再将其加入到list中
     * 如果一个节点只会到达一次，那么第一次就将其加入到list中
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        while (root != null) {
            TreeNode mostRight = root.left;
            if (mostRight != null) {
                //找当前节点的左子树的最右节点
                while (mostRight.right != null && mostRight.right != root) {
                    mostRight = mostRight.right;
                }

                //走到这里，要么mostRight.right == null，要么mostRight.right == root
                if (mostRight.right == null) {
                    mostRight.right = root;
                    root = root.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }

            /**
             * 如果当前节点没有左节点，那么一定先到这里
             * 如果当前节点有左节点，会走到上面的else，然后再走到这里
             */
            list.add(root.val);
            //左子树为空，直接向右走
            root = root.right;
        }

        return list;
    }
}
