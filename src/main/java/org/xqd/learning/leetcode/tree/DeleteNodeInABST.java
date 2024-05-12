package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

/**
 * 450. Delete Node in a BST
 */
public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode leftTree = null;
        TreeNode rightTree = null;

        TreeNode temp = root;
        TreeNode pre = null;

        while (temp != null) {
            if (key < temp.val) {
                pre = temp;
                temp = temp.left;
            } else if (key > temp.val) {
                pre = temp;
                temp = temp.right;
            } else {
                leftTree = temp.left;
                rightTree = temp.right;
                if (pre != null) {
                    if (pre.val > temp.val) {
                        pre.left = null;
                    } else {
                        pre.right = null;
                    }
                }
                temp = null;
            }
        }

        if (leftTree != null && rightTree == null) {
            if (pre == null) {
                root = leftTree;
            } else {
                if (leftTree.val > pre.val) {
                    pre.right = leftTree;
                } else {
                    pre.left = leftTree;
                }
            }
        }

        if (leftTree == null && rightTree != null) {
            if (pre == null) {
                root = rightTree;
            } else {
                if (rightTree.val > pre.val) {
                    pre.right = rightTree;
                } else {
                    pre.left = rightTree;
                }
            }
        }

        if (leftTree != null && rightTree != null) {
            if (pre != null) {
                if (leftTree.val > pre.val) {
                    pre.right = leftTree;
                } else {
                    pre.left = leftTree;
                }
            }

            TreeNode temp1 = leftTree;
            while (leftTree != null) {
                if (leftTree.right == null) {
                    leftTree.right = rightTree;
                    break;
                } else {
                    leftTree = leftTree.right;
                }
            }

            if (pre == null) {
                root = temp1;
            }
        }

        if(pre == null && leftTree == null && rightTree == null) {
            return null;
        }


        return root;
    }
}
