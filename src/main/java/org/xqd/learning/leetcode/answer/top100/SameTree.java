package org.xqd.learning.leetcode.answer.top100;

import org.xqd.learning.leetcode.pojo.TreeNode;

/**
 * LeetCode 100. Same Tree
 */
public class SameTree {
    public static void main(String[] args) {

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            if (p.val != q.val) {
                return false;
            }

            /**
             * 自己在这里纠结了超级久
             */
            boolean sameTree = isSameTree(p.left, q.left);
            if (sameTree) return isSameTree(p.right, q.right);
        }

        return false;
    }
}
