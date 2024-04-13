package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. Symmetric Tree
 *
 * @author qidongxu
 */
public class SymmetricTree {

    public boolean isSymmetric2(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);

        while (!queue.isEmpty()) {
            TreeNode l = queue.poll();
            TreeNode r = queue.poll();

            if (l == null && r == null) {
                continue;
            }

            if (l.val != r.val) {
                return false;
            }

            queue.add(l.left);
            queue.add(r.right);

            queue.add(l.right);
            queue.add(r.left);
        }

        return true;
    }

    public boolean isSymmetric1(TreeNode root) {
        return isSameTree(root.left, root.right);
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (q == null && p == null) return true;
        if (q == null || p == null) return false;

        if (p.val != q.val) {
            return false;
        }

        return isSameTree1(p.left, q.right) && isSameTree1(p.right, q.left);
    }


    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, root.right);
    }

    private boolean isSameTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return true;

        if (left.val != right.val) return false;

        return isSameTree(left.left, right.right) && isSameTree(left.right, right.left);
    }
}
