package org.xqd.learning.leetcode.tree;

import org.xqd.learning.leetcode.pojo.TreeNode;

/**
 * LeetCode 98. Validate Binary Search Tree
 */
public class ValidateBinarySearchTree {
    /**
     * 目前这个方法只能保证 root 和它的 child 能构成 BST，但是不能保证整个 tree 是 BST
     *
     * @return
     */
//    public boolean isValidBST(TreeNode root) {
//        if (root == null || (root.left == null && root.right == null)) return true;
//
//        if ((root.right != null && root.right.val <= root.val) || (root.left != null && root.left.val >= root.val)) {
//            return false;
//        }
//
//        return isValidBST(root.left) && isValidBST(root.right);
//    }

    public static class Info {
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public static boolean isValidBST1(TreeNode root) {
        return getChildrenInfo(root).isBST;
    }

    public static Info getChildrenInfo(TreeNode xNode) {
        if (xNode == null) {
            //因为既不知道最大值，也不知道最小值，最多返回一个 true
            return null;
        }

        Info leftInfo = getChildrenInfo(xNode.left);
        Info rightInfo = getChildrenInfo(xNode.right);

        boolean isBST = true;
        if (leftInfo != null && !leftInfo.isBST) {
            isBST = false;
        }

        if (rightInfo != null && !rightInfo.isBST) {
            isBST = false;
        }

        if (leftInfo != null && leftInfo.max >= xNode.val) {
            isBST = false;
        }

        if (rightInfo != null && rightInfo.min <= xNode.val) {
            isBST = false;
        }

        int max = xNode.val;
        int min = xNode.val;

        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
        }

        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
        }

        /**
         * 这是自己原来的版本
         */
//        if (leftInfo != null && leftInfo.max >= xNode.val) {
//            isBST = false;
//            max = leftInfo.max;
//        } else if (leftInfo != null) {
//            min = leftInfo.max;
//        }
//
//        if (rightInfo != null && rightInfo.min <= xNode.val) {
//            isBST = false;
//            min = rightInfo.min;
//        } else if (rightInfo != null) {
//            max = rightInfo.min;
//        }

        return new Info(isBST, max, min);
    }

    public int compare(TreeNode root) {
        if ((root.left == null && root.right == null)) return root.val;

        int rv = root.val;
        if (root.left != null) {
            int left = compare(root.left);
            if (left > rv) rv = left;
        }

        if (root.right != null) {
            int right = compare(root.right);
            if (right < rv) rv = right;
        }

        return rv;
    }

    public boolean isValidBST(TreeNode root) {
        //如果先判断最下面的子树是否符合条件呢？
        return isValidBSTWithMinAndMax(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTWithMinAndMax(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        int value = root.val;
        return min < value && max > value && isValidBSTWithMinAndMax(root.left, min, value) && isValidBSTWithMinAndMax(root.right, value, max);
    }
}
