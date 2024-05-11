package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //完全不在同一棵树，且两个节点和root不相等
        if ((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val)) {
            return root;
        }

        //边界问题啊
        if (root.val == q.val || root.val == p.val) {
            return root;
        }

        TreeNode ancestor = null;
        if (root.val < p.val && root.val < q.val) {
            ancestor = lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            ancestor = lowestCommonAncestor(root.left, p, q);
        }

        return ancestor;
    }
}
