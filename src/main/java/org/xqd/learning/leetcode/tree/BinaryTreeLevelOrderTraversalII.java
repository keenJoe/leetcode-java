package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> all = new ArrayList<>();
        if (root == null) return all;

        Deque<List<Integer>> allDeque = new ArrayDeque<>();

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        allDeque.addFirst(list);

        while (!deque.isEmpty()) {
            int size = deque.size();
            list = new ArrayList<>();
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

        for (int i = 0; i < allDeque.size(); i++) {
            all.add(allDeque.pollFirst());
        }

        return all;
    }
}
