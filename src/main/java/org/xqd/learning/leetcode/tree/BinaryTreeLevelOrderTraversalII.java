package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 107. Binary Tree Level Order Traversal II
 */

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        int depth = calDepth(root);

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> childList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                childList.add(node.val);
                if (node.left != null) {
                    deque.addLast(node.left);
                }

                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            list.add(--depth, childList);
        }

        return list;
    }

    private int calDepth(TreeNode root) {
        int leftDepth = 0;
        if (root.left != null) {
            leftDepth = calDepth(root.left);
        }

        int rightDepth = 0;
        if (root.right != null) {
            rightDepth = calDepth(root.right);
        }

        return 1 + Math.max(leftDepth, rightDepth);
    }


    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> all = new ArrayList<>();
        if (root == null) return all;

        Deque<List<Integer>> allDeque = new ArrayDeque<>();

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
//        List<Integer> list = new ArrayList<>();
//        list.add(root.val);
//        allDeque.addFirst(list);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                list.add(node.val);
                if (node.left != null) {
                    deque.add(node.left);
                }

                if (node.right != null) {
                    deque.add(node.right);
                }
            }

            allDeque.addFirst(list);
        }

        //和使用for循环有什么区别呢？
        while (!allDeque.isEmpty()) {
            List<Integer> list = allDeque.pollFirst();
            System.out.println(list);
            all.add(list);
        }

        return all;
    }
}
