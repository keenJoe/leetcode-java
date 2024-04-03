package org.xqd.learning.leetcode.tree;


import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private Map<Integer, Integer> indexMap = null;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        //遍历inorder，构建位置索引
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(i, inorder[i]);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        //终止条件
        if (preLeft > preRight) {
            //返回一个空树
            return null;
        }

        //当前树的根结点索引
        int rootIndex = preLeft;
        //确认根结点在中序遍历的位置
        int inorderRootIndex = indexMap.get(preorder[rootIndex]);
        //左子树的数量
//        int step = inorderRootIndex - rootIndex;(错误的写法)
        int step = inorderRootIndex - inLeft;
        //构建根节点
        TreeNode root = new TreeNode(preorder[rootIndex]);
        //构建左子树
        root.left = build(preorder, inorder, rootIndex + 1, rootIndex + step, inLeft, inorderRootIndex - 1);
        //构建右子树
        root.right = build(preorder, inorder, rootIndex + step + 1, preRight, inorderRootIndex + 1, inRight);

        return root;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.add(root);
        int indexInorder = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preValue = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[indexInorder]) {
                node.left = new TreeNode(preValue);
                stack.add(node.left);
            } else {
                //while循环中不能用node，因为node会变化。需要每次拿栈顶的node
                //要用stack.peek().val
                while (!stack.isEmpty() && node.val == inorder[indexInorder]) {
                    node = stack.pop();
                    indexInorder++;
                }

                node.right = new TreeNode(preValue);
                stack.add(node.right);
            }
        }

        return root;
    }
}
