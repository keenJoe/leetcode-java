package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author XuQidong
 * @date 2021/8/7 23:00
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) throws InterruptedException {
        TreeNode root = new TreeNode(1);
//        TreeNode two = new TreeNode(2);
//        TreeNode one = new TreeNode(1);
//        TreeNode five = new TreeNode(5);
//        two.left = one;
//        one.left = five;
//        root.left = two;
        TreeNode four = new TreeNode(4);
        root.left = four;
        four.left = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        root.right = three;

        List<Integer> list = preorderTraversal1(root);
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

    public static List<Integer> preorderTraversal1(TreeNode root) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        stack.add(root);

        while (!stack.empty()) {
            System.out.println(root.val);
            list.add(root.val);

            if (root.left != null) {
                root = root.left;
                stack.add(root);
            } else if (root.right != null) {
                stack.pop();
                root = root.right;
                stack.add(root);
            }
        }

        return list;
    }
}
