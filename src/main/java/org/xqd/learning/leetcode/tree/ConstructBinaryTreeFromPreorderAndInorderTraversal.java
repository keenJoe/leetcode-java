package org.xqd.learning.leetcode.tree;


import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private Map<Integer, Integer> indexMap = null;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        int n = inorder.length;

        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) return null;

        int rootIndex = preLeft;
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int rootIndexInInorder = indexMap.get(preorder[rootIndex]);
        //计算左子树的长度
        int size = rootIndexInInorder - inLeft;

        //递归构建左子树
        root.left = build(preorder, inorder, preLeft + 1, preLeft + size, inLeft, rootIndexInInorder - 1);
        //递归构建右子树
        root.right = build(preorder, inorder, preLeft + 1 + size, preRight, rootIndexInInorder + 1, inRight);

        return root;
    }
}
