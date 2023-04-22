package org.xqd.learning.leetcode.tree;


import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.*;

/**
 * 112. Path Sum
 *
 * @author qidongxu
 */
public class PathSum {
    public static void main(String[] args) {
//        TreeNode head = new TreeNode(5);
//        head.left = new TreeNode(4);
//        head.right = new TreeNode(8);
//
//        head.left.left = new TreeNode(11);
//        head.left.left.left = new TreeNode(7);
//        head.left.left.right = new TreeNode(2);
//
//        head.right.left = new TreeNode(13);
//        head.right.right = new TreeNode(4);
//
//        head.right.right.right = new TreeNode(1);

        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
//        head.right = new TreeNode(3);

        boolean b = hasPathSum(head, 5);
        System.out.println(b);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        Deque<Integer> deque = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

//        Set<TreeNode> set = new HashSet<>();
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                deque.addFirst(root.val);
//                stack.add(root);
//                root = root.left;
//            }
//
//            int sum = deque.stream().mapToInt(i -> i).sum();
//            System.out.println("当前和：" + sum);
//            System.out.println("当前的栈元素：" + stack);
//
//            if (sum == targetSum) {
//                return true;
//            }
//
//            root = stack.peek();
//            if (root.right == null) {
//                deque.removeFirst();
//                stack.pop();
//                root = stack.peek();
//
//                if (set.contains(root)) {
//                    return false;
//                }
//
//                set.add(root);
//            }
//
//            root = root.right;
//        }


        return false;
    }
}
