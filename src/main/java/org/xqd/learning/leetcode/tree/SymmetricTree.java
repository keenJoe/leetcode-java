package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 101. Symmetric Tree
 * @author qidongxu
 */
public class SymmetricTree {

    public boolean isSymmetric1(TreeNode root) {
        return check(root,root);
    }

    public boolean check(TreeNode root1, TreeNode root2){
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

    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, root.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null && p == null) return true;
        if (q == null || p == null) return false;

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
}
