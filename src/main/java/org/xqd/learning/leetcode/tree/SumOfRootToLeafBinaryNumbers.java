package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.*;

/**
 * 1022. Sum of Root To Leaf Binary Numbers
 */
public class SumOfRootToLeafBinaryNumbers {
    public static void main(String[] args) throws InterruptedException {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(0);
        head.right = new TreeNode(1);

        head.left.left = new TreeNode(0);
        head.left.right = new TreeNode(1);
        head.right.left = new TreeNode(0);
        head.right.right = new TreeNode(1);
        sumRootToLeaf(head);
    }


    public static int sumRootToLeaf(TreeNode root) throws InterruptedException {
        LinkedList<Integer> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        TreeNode pre = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                queue.add(root.val);
                stack.add(root);
                pre = root;
                root = root.left;
            }

            if (pre.right == null) {
                sum += binary2Decimal(queue);
                queue.removeLast();
                stack.pop();
            } else {
                root = stack.pop().right;
            }

//            //跳出循环，说明向左已经走到头
//            TreeNode peek = stack.peek();
//            System.out.println(peek.val);
//            TreeNode right = peek.right;
//            //从根节点到当前的节点算作一种情况
//            if (right == null) {
//                if (peek.left == null) {
//                    sum += binary2Decimal(queue);
//                    System.out.println("当前的sum值：" + sum);
//                }
//
//                stack.pop();
//                stack.pop();
//                root = stack.pop().right;
//                //弹出当前节点的元素
//                queue.removeLast();
//            } else {
//                pre = peek;
//                //当前节点还有右节点，需要继续向右走
//                root = right;
//            }

            Thread.sleep(1000);
            System.out.println("=============");
        }

        return sum;

//        LinkedList<Integer> list = new LinkedList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        int sum = 0;
//
//        Set<TreeNode> set = new HashSet<>();
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                stack.add(root);
//                root = root.left;
//            }
//
//            TreeNode peek = stack.peek();
//            if (peek.right != null && !set.contains(peek.right)) {
//                root = peek.right;
//            } else {
//                TreeNode node = stack.pop();
//                list.add(node.val);
//                set.add(node);
//            }
//        }
//
//        return sum;
    }

    public static int binary2Decimal(Queue<Integer> queue) {
        StringBuilder builder = new StringBuilder();
        for (Integer integer : queue) {
            builder.append(String.valueOf(integer));
        }

        System.out.println("当前的字符串是: " + builder.toString());
        int decimalValue = Integer.parseInt(builder.toString(), 2);
        return decimalValue;
    }
}
