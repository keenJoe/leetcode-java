package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.graph.CourseScheduleII;
import org.xqd.learning.leetcode.pojo.Node;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 117. Populating Next Right Pointers in Each Node II
 */
public class PopulatingNextRightPointersInEachNodeII {

    /**
     * 使用广度优先搜索，但是运行效果不好
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node cur = root;
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(cur);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node node = deque.pollFirst();
                if (i + 1 == size) {
                    node.next = null;
                } else {
                    Node next = deque.peekFirst();
                    node.next = next;
                }

                if (node.left != null) {
                    deque.add(node.left);
                }

                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }

        return root;
    }
}
