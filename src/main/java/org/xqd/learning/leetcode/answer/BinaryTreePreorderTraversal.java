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
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        //TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        root.left = three;
        root.right = null;
        three.left = one;

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

    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (root != null) {
            list.add(root.val);
            if (stack.empty()) return list;

            if (root.left != null) {
                if (root.left.left != null || root.left.right != null) {
                    stack.add(root.left);
                }

                root = root.left;
            } else if (root.right != null) {
                stack.pop();
                if (root.right.left != null || root.right.right != null) {
                    stack.add(root.right);
                }

                root = root.right;
            } else {
                if(!stack.empty()){
                    root = stack.pop();
                    if(root != null && root.right != null) {
                        root = root.right;
                        stack.add(root.right);
                    } else {
                        if(!stack.empty()){
                            root = stack.pop();
                        } else {
                            return list;
                        }
                    }
                }
            }
        }

        return list;
    }
}
