package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode rootLeftLeftLeft = new TreeNode(5);
        TreeNode rootLeftLeftRigh = new TreeNode(1);

        TreeNode rootLeftLeft = new TreeNode(1, rootLeftLeftLeft, rootLeftLeftRigh);


        TreeNode rootRightLeft = new TreeNode(15);
        TreeNode rootRightRight = new TreeNode(7);

        TreeNode rootLeft = new TreeNode(9, rootLeftLeft, null);
        TreeNode rootRight = new TreeNode(20, rootRightLeft, rootRightRight);
        TreeNode root = new TreeNode(3, rootLeft, rootRight);
        List<List<Integer>> list = zigzagLevelOrder(root);
        System.out.println(list);


        List<List<Integer>> all = new LinkedList<>();
    }


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> all = new ArrayList<>();

        if (root == null) {
            return all;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        boolean flag = false;

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();

            Stack<TreeNode> stack = new Stack<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                System.out.println("1当前节点值是：" + node.val);
                list.add(node.val);
                stack.add(node);
            }

//            System.out.println("+++++++++++++++++++++++++++++++");
            System.out.println("当前stack的大小：" + stack.size());

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                System.out.println("2当前节点是: " + node.val);
                if (flag) {
                    System.out.println("True");
                    if (node.left != null) {
                        deque.add(node.left);
                    }

                    if (node.right != null) {
                        deque.add(node.right);
                    }
                } else {
                    System.out.println("FALSE");
                    if (node.right != null) {
                        deque.add(node.right);
                    }

                    if (node.left != null) {
                        deque.add(node.left);
                    }
                }
            }

            all.add(list);
            flag = !flag;

            System.out.println("===================");
        }

        return all;
    }
}
