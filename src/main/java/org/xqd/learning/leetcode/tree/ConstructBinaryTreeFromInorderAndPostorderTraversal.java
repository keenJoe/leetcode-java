package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private int rootIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        rootIndex = n - 1;

        return build(inorder, postorder, 0, n - 1, map);
    }

    private TreeNode build(int[] inorder, int[] postorder, int start, int end, Map<Integer, Integer> map) {
        if (start > end) return null;

        TreeNode root = new TreeNode(postorder[rootIndex]);
        Integer inorderRootIndex = map.get(postorder[rootIndex]);
        rootIndex--;

        //构建右子树
        root.right = build(inorder, postorder, inorderRootIndex + 1, end, map);
        //构建左子树
        root.left = build(inorder, postorder, start, inorderRootIndex - 1, map);

        return root;
    }
}
