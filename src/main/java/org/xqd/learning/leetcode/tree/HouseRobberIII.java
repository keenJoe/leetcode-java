package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

public class HouseRobberIII {

    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }

    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[2];
        }

        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int[] result = new int[2];
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + node.val;

        return result;
    }

//    public int rob(TreeNode root) {
//        return Math.max(f(root, true), f(root, false));
//    }
//
//    private int f(TreeNode root, boolean b) {
//        if (root == null) return 0;
//
//        int sum = 0;
//        if (b) {
//            sum += f(root.left, false) + f(root.right, false) + root.val;
//        } else {
//            sum += Math.max(
//                    Math.max(f(root.left, true) + f(root.right, true), f(root.left, false) + f(root.right, false)),
//                    Math.max(f(root.left, true) + f(root.right, false), f(root.left, false) + f(root.right, true)));
//        }
//
//        return sum;
//    }

//    public int rob(TreeNode root) {
//        Map<TreeNode, Integer> cache = new HashMap<>();
//        return Math.max(f(root, true, cache), f(root, false, cache));
//    }
//
//    private int f(TreeNode root, boolean b, Map<TreeNode, Integer> cache) {
//        if (root == null) return 0;
//
//        if (cache.containsKey(root)) {
//            return cache.get(root);
//        }
//
//        int sum = 0;
//        if (b) {
//            sum += f(root.left, false, cache) + f(root.right, false, cache) + root.val;
//        } else {
//            sum += Math.max(
//                    Math.max(f(root.left, true, cache) + f(root.right, true, cache), f(root.left, false, cache) + f(root.right, false, cache)),
//                    Math.max(f(root.left, true, cache) + f(root.right, false, cache), f(root.left, false, cache) + f(root.right, true, cache)));
//        }
//
//        cache.put(root, sum);
//        return sum;
//    }
}
