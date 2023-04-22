package org.xqd.learning.leetcode.utils;

import org.xqd.learning.leetcode.pojo.TreeNode;

import java.util.stream.Stream;

/**
 * @author qidongxu
 */
public class TreeUtil {
    public static TreeNode generateBinaryTree(Integer[] array) {
//        Stream.<int[]>of(array).forEach(item -> {
//
//        });

        TreeNode root = null;
        for (int i = 0; i < array.length; i++) {
            if (array[0] == null) {
                return root;
            }

            if (array[0] != null) {
                root = new TreeNode();
            }

            root.setVal(array[0]);

        }

        return root;
    }
}
