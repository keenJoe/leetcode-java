package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.Node;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 116. Populating Next Right Pointers in Each Node
 */
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) return null;

        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node node = deque.removeFirst();
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }

                //队列的最后一个节点
                if (i == size - 1) {
                    node.next = null;
                } else {
                    node.next = deque.getFirst();
                }
            }
        }

        return root;
    }
}
