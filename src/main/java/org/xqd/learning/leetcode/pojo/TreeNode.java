package org.xqd.learning.leetcode.pojo;

/**
 * @author XuQidong
 * @date 2021/3/26 02:20
 */
public class TreeNode {
    public int val;

    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }

    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}