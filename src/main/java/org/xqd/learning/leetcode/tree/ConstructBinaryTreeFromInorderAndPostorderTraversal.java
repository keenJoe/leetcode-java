package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode node = buildTree(inorder, postorder);
        System.out.println(node);
    }

    private static Map<Integer, Integer> map = new HashMap<>();
    private static int rootIndex;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        rootIndex = inorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] inorder, int[] postorder, int start, int end) {
        if (start > end || rootIndex < 0) return null;

        TreeNode node = new TreeNode(postorder[rootIndex]);
        Integer inorderRootIndex = map.get(postorder[rootIndex]);
        rootIndex--;

        //巧妙之处在于先构建右子树，后构建左子树
        node.right = build(inorder, postorder, inorderRootIndex + 1, end);
        node.left = build(inorder, postorder, start, inorderRootIndex - 1);
        return node;
    }

    //搜索的范围不能发生变化
    private static TreeNode build1(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) return null;

        System.out.println("当前根结点索引：" + end);
        TreeNode node = new TreeNode(postorder[end]);
        System.out.println("当前根结点是：" + postorder[end]);
        Integer inorderRootIndex = map.get(postorder[end]);
        System.out.println("=============");

        node.left = build(inorder, postorder, start, inorderRootIndex - 1);
        node.right = build(inorder, postorder, inorderRootIndex + 1, end - 1);
        return node;
    }
}
