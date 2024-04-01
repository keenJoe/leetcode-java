package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * 145. Binary Tree Postorder Traversal
 *
 * @author qidongxu
 */
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) throws InterruptedException {
        int result = 1; // 初始值为1

        for (int i = 2; i <= 100000000; i++) {
            // 左移相应位数，并加上下一个数
            result <<= Integer.bitCount(i); // 左移的位数为下一个数的二进制表示中1的个数
            System.out.println(result);
            result += i;
            System.out.println(result);
            System.out.println("========");
            Thread.sleep(2000);
        }

        System.out.println("从1到一亿连续相乘的结果为：" + result);
    }

//    public static void main(String[] args) {
//        TreeNode rootRightLeft = new TreeNode(3);
//        TreeNode rootRight = new TreeNode(2, rootRightLeft, null);
//        TreeNode root = new TreeNode(1, null, rootRight);
//        List<Integer> integers = postorderTraversal(root);
//        System.out.println(integers);
//    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (root != null) {
            TreeNode mostRight = root.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != root) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    mostRight.right = root;
                    root = root.left;
                    continue;
                } else {
                    mostRight.right = null;
                    //将当前节点的左节点的右子树逆序打印
                    addNodeIntoList(root.left, list);
                }
            }

            root = root.right;
        }
        addNodeIntoList(cur, list);

        return list;
    }

    private static void addNodeIntoList(TreeNode root, List<Integer> list){
        TreeNode node = convertTreeNode(root);
        while (node != null) {
            list.add(node.val);
            node = node.right;
        }
        convertTreeNode(node);
    }

    private static TreeNode convertTreeNode(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null) {
            TreeNode next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }


    public static List<Integer> postorderTraversal2(TreeNode root) {
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


    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.add(root);
//                root = root.left;
//            }
//
//            root = stack.pop();
//            TreeNode node = root.right;
//            if (node == null) {
//                list.add(root.val);
//                //拿出栈顶的node，但是又会陷入第二个while的循环中！！！
//            }

            //root.left 后获取的root可能是null
//            while (root.right != null) {
//                stack.add(root);
//                root = root.left;
//            }

            TreeNode cur = stack.peek();
            if (cur.left == null && cur.right == null) {
                list.add(stack.pop().val);
            }

            if (cur.right != null) {
                stack.add(cur.right);
                cur.right = null;
            }

            if (cur.left != null) {
                stack.add(cur.left);
                cur.left = null;
            }

        }

        return list;
    }
}
