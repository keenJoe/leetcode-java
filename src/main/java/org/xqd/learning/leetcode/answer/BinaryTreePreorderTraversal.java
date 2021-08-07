package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XuQidong
 * @date 2021/8/7 23:00
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        root.left = one;
        root.right = two;

        List<Integer> list = preorderTraversal(root);
        System.out.println(list.toString());
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        list.add(root.val);

        if (root.left != null) {
            list.addAll(preorderTraversal(root.left));
        }

        if (root.right != null) {
            list.addAll(preorderTraversal(root.right));
        }

        return list;
    }

    public List<Integer> traversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode rootLeft = null;
        TreeNode rootRight = null;
        if (root.left != null) {
            rootLeft = root.left;
            list.add(rootLeft.val);
            list.addAll(traversal(rootLeft));
        } else if (root.right != null) {
            rootRight = root.right;
            list.add(rootRight.val);
            list.addAll(traversal(rootRight));
        }

        return list;
    }
}
