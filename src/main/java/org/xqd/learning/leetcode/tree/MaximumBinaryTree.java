package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.Arrays;

/**
 * 654.Maximum Binary Tree
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        int rootIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[rootIndex]) {
                rootIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[rootIndex]);

        int[] a = Arrays.copyOfRange(nums, 0, rootIndex);
        int[] b = Arrays.copyOfRange(nums, rootIndex + 1, nums.length);

        root.left = constructMaximumBinaryTree(a);
        root.right = constructMaximumBinaryTree(b);

        return root;
    }
}
