package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XuQidong
 * @date 2021/8/8 00:45
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args){

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        if (root.left != null) {
            list.addAll(inorderTraversal(root.left));
        }

        list.add(root.val);

        if (root.right != null) {
            list.addAll(inorderTraversal(root.right));
        }

        return list;
    }
}
