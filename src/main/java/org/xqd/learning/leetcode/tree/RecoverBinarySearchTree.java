package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 99. Recover Binary Search Tree
 */
public class RecoverBinarySearchTree {

    TreeNode first = null;
    TreeNode second = null;
    TreeNode last = null;

    public void recoverTree1(TreeNode root) {
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


    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode a = null;
        TreeNode b = null;

        TreeNode dummy = root;
        while (!stack.isEmpty() || root != null) {
            //模拟在递归中一直向左遍历
            while (root != null) {
                stack.add(root);
                root = root.left;
//                list.add(root.val);
            }
            //已经走到最左的节点
            TreeNode node = stack.peek();
//            list.add(node.val);
            if (pre != null && pre.val > node.val) {
                if (a == null) {
                    a = pre;
                }
                b = node;
            }

            pre = node;
            root = node.right;
        }

        int temp = b.val;
        b.val = a.val;
        a.val = temp;
    }
}
