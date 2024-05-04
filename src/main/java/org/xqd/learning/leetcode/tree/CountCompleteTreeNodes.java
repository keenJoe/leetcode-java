package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 222. Count Complete Tree Nodes
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        int count = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            count += size;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                if (node.left != null) {
                    deque.addLast(node.left);
                }

                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
        }
        return count;
    }
}
