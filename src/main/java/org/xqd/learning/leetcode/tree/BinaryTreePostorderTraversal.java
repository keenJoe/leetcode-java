package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 145. Binary Tree Postorder Traversal
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
}
