package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.Arrays;

/**
 * @author qidongxu
 * <p>
 * 108. Convert Sorted Array to Binary Search Tree
 */
public class ConvertSortedArray2BinarySearchTree {

    /**
     * 能用递归解决的问题也一定能用迭代解决
     * @param nums
     * @return
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        int[] a = Arrays.copyOfRange(nums, 0, mid);
        int[] b = Arrays.copyOfRange(nums, mid + 1, nums.length);

        root.left = sortedArrayToBST(a);
        root.right = sortedArrayToBST(b);

        return root;
    }
}
