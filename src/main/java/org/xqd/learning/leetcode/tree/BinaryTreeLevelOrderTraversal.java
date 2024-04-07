package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.*;

/**
 * 102. Binary Tree Level Order Traversal
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

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
            list.add(childList);
        }

        return list;
    }


    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> all = new ArrayList<>();

        if (root == null) return all;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

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

            all.add(list);
        }

        return all;
    }
}
