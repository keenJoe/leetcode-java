package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean fromLeft = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> childList = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                childList.add(node.val);
                stack.add(node);
            }

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (fromLeft) {
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                } else {
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                }
            }

            fromLeft = !fromLeft;
            list.add(childList);
        }

        return list;
    }
}
