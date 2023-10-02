package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import javax.swing.*;

/**
 * 623. Add One Row to Tree
 */
public class AddOneRow2Tree {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode rootNode = new TreeNode(val);
            rootNode.left = root;
            return rootNode;
        }

        int currentDepth = 0;
        TreeNode current = root;
        //找到待插入的节点
        while (currentDepth != depth) {
            if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                return null;
            }

            currentDepth += 1;
        }

        TreeNode oriLeftNode = root.left;
        TreeNode oriRightNode = root.right;

        TreeNode leftNode = new TreeNode(val);
        TreeNode rightNode = new TreeNode(val);

        root.left = leftNode;
        leftNode.left = oriLeftNode;

        root.right = rightNode;
        rightNode.right = oriRightNode;

        return current;
    }
}
