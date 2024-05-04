package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.*;

/**
 * 257. Binary Tree Paths
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        Deque<Integer> deque = new ArrayDeque<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                deque.addLast(root.val);
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;
            if (root == null) {
                StringBuilder builder = new StringBuilder();
                Iterator<Integer> iterator = deque.iterator();
                while (iterator.hasNext()) {
                    builder.append(iterator.next());
                    builder.append("->");
                }
                deque.removeLast();
            }
        }

        return null;
    }
}
