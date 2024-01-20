package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. Maximum Depth of Binary Tree
 *
 * @author qidongxu
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        int i = 1;
        int temp = i;
        i++;
        i = temp;
        System.out.println(i);

        int count = 0;
        for (int i1 = 0; i1 < 100; i1++) {
            count = count++;
            System.out.println(count);
        }
        System.out.println("count = " + count);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepthWithBreadth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }

                size--;
            }
            depth++;
        }
        return depth;
    }
}
