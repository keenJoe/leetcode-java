package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 449. Serialize and Deserialize BST
 */
public class SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

        }

        return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }

    /**
     * 层序遍历serialize BST
     */
    public String serialize1(TreeNode root) {
        if (root == null) {
            return "";
        }

        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                list.add(String.valueOf(temp.val));
                /*
                  这里很关键
                  不需要判断left和right是否为null
                 */
                queue.add(temp.left);
                queue.add(temp.right);
            } else {
                list.add("null");
            }
        }

        return String.join(",", list);
    }

    // Decodes your encoded data to tree.

    /**
     * deserialiaze the encoded data
     * @param data
     * @return
     */
    public TreeNode deserialize1(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] nodeValues = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodeValues[0]));
        queue.add(root);

        for (int i = 1; i < nodeValues.length; i++) {
            TreeNode parent = queue.poll();

            if (!nodeValues[i].equals("null")) {
                TreeNode leftChild = new TreeNode(Integer.parseInt(nodeValues[i]));
                parent.left = leftChild;
                queue.add(leftChild);
            }
            i++;

            if (i < nodeValues.length && !nodeValues[i].equals("null")) {
                TreeNode rightChild = new TreeNode(Integer.parseInt(nodeValues[i]));
                parent.right = rightChild;
                queue.add(rightChild);
            }
        }

        return root;
    }
}
