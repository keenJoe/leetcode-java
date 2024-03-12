package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 * @author qidongxu
 */
public class BinaryTreePreorderTraversal {


    public List<Integer> preorderTraversal(TreeNode root) {
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
                    list.add(root.val);
                    mostRight.right = root;
                    root = root.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                list.add(root.val);
            }

            //左子树为空，直接向右走
            root = root.right;
        }

        return list;
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(3);
        TreeNode node1 = new TreeNode(2);
        TreeNode root = new TreeNode(1);

        root.right = node1;
        root.left = null;

        node1.left = node2;
        node1.right = null;

        preorderTraversal2(root);
    }

    //错误写法
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            System.out.println("当前根节点是：" + root.val);
            while(root.left != null) {
                list.add(root.val);
                root = root.left;
                stack.add(root);
            }

            TreeNode node = root.right;
//            System.out.println("当前node节点是：" + node.val);
            if (node == null) {
                node = stack.pop();
                root = node.right;
            } else {
                root = node;
            }
            System.out.println("=================");
        }

        return list;
    }
}
