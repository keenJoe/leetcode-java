package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.Stack;

/**
 * 100. Same Tree
 */
public class SameTree {
    /**
     * 先用递归的方式
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null && p == null) return true;
        if (q == null || p == null) return false;

        return r(p, q);
    }

    public boolean r(TreeNode p, TreeNode q) {
        if (q == null && p == null) return true;
        if (q == null || p == null) return false;

        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();

        while ((p != null && q != null) || (!stackP.isEmpty() && !stackQ.isEmpty())) {
            while (p != null && q != null) {
                if(p.val != q.val) {
                    return false;
                }

                stackP.add(p);
                stackQ.add(q);

                p = p.left;
                q = q.left;
            }

            p = stackP.pop();
            q = stackQ.pop();

            p = p.right;
            q = q.right;
        }

        return true;
    }
}
