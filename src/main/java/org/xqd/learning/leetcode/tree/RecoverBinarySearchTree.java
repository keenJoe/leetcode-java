package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

public class RecoverBinarySearchTree {

    TreeNode first = null;
    TreeNode second = null;
    TreeNode last = null;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (last != null && last.val > root.val) {
            if (first == null)
                first = last;
            second = root;
        }
        last = root;
        dfs(root.right);
    }
}
