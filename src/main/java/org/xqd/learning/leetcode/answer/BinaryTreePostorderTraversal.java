package org.xqd.learning.leetcode.answer;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XuQidong
 * @date 2021/8/8 00:55
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        if (root.left != null) {
            list.addAll(postorderTraversal(root.left));
        }

        if (root.right != null) {
            list.addAll(postorderTraversal(root.right));
        }

        list.add(root.val);

        return list;
    }
}
