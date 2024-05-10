package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 129. Sum Root to Leaf Numbers
 */
public class SumRoot2LeafNumbers {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public int sumNumbers(TreeNode root) {
        dfs(root);
        int sum = 0;
        for (List<Integer> integers : ret) {
            StringBuilder builder = new StringBuilder();
            for (Integer integer : integers) {
                builder.append(integer);
            }
            sum += Integer.parseInt(builder.toString());
        }
        return sum;
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
