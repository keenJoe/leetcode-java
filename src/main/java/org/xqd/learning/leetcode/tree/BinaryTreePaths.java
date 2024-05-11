package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.*;

/**
 * 257. Binary Tree Paths
 */
public class BinaryTreePaths {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        List<String> list = new ArrayList<>();
        for (List<Integer> integers : ret) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < integers.size(); i++) {
                if (i != integers.size() - 1) {
                    builder.append(integers.get(i)).append("->");
                } else {
                    builder.append(integers.get(i));
                }
            }
            list.add(builder.toString());
        }
        return list;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        //前序遍历
        path.offerLast(root.val);
        if (root.left == null && root.right == null) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left);
        dfs(root.right);
        //这一步最关键
        path.pollLast();
    }
}
