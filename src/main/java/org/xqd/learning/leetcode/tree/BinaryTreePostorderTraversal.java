package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.*;

/**
 * 145. Binary Tree Postorder Traversal
 *
 * @author qidongxu
 */
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        TreeNode rootRightLeft = new TreeNode(3);
        TreeNode rootRight = new TreeNode(2, rootRightLeft, null);
        TreeNode root = new TreeNode(1, null, rootRight);
        List<Integer> integers = postorderTraversal(root);
        System.out.println(integers);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        Set<TreeNode> set = new HashSet<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            TreeNode peek = stack.peek();
            if (peek.right != null && !set.contains(peek.right)) {
                root = peek.right;
            } else {
                TreeNode node = stack.pop();
                list.add(node.val);
                set.add(node);
            }
        }

        return list;
    }

    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();

            if (cur.right != null) {
                stack.add(cur.right);
                cur.right = null;
            }

            if (cur.left != null) {
                stack.add(cur.left);
                cur.left = null;
            }

            if (cur.left == null && cur.right == null) {
                list.add(stack.pop().val);
            }
        }

        return list;
    }
}
