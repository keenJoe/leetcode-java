package org.xqd.learning.leetcode.answer.top100;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 102. Binary Tree Level Order Traversal
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node15 = new TreeNode(15, null, null);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode root = new TreeNode(3, node9, null);

        List<List<Integer>> lists = levelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;

        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        lists.add(rootList);

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(root);

        while (queue.size() > 0) {

            Queue<TreeNode> childQueue = new LinkedBlockingQueue<>();
            List<Integer> childList = new ArrayList<>();

            while (queue.peek() != null) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    childQueue.add(treeNode.left);
                    childList.add(treeNode.left.val);
                }
                if (treeNode.right != null) {
                    childQueue.add(treeNode.right);
                    childList.add(treeNode.right.val);
                }
            }

            if (childList.size() > 0) {
                lists.add(childList);
            }

            queue = childQueue;
        }

        return lists;
    }


}
