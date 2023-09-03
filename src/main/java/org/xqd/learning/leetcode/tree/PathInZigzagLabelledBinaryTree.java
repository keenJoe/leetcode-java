package org.xqd.learning.leetcode.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1104. Path In Zigzag Labelled Binary Tree
 */
public class PathInZigzagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
//        int size = 1;
//        int level = 1;
//        LinkedList<Integer> res = new LinkedList<>();
//        while ((size << 1) <= label) {
//            size <<= 1;
//            level++;
//        }
//        while (label != 0) {
//            res.addFirst(label);
//            label = ((1 << level) - 1 + (1 << (level - 1)) - label) / 2;
//            level--;
//        }
//        return res;
//
//
//
//        double sqrt = Math.sqrt(14);
//        double floor = Math.floor(sqrt);
//        //floor为偶数，左小右大；为奇数，左大右小
//        int levelEnd = (int) (Math.pow(2, floor + 1) - 1);
//        boolean flag = floor % 2 == 0;
//
//        List<Integer> list = new ArrayList<>();
//        int level = 0;
//        int pre = 0;
//        int cur = 1;
//        int levelStart = 0;
//        int mid = 0;
//
//        while (level < floor) {
//            //当level=0时，levelStart = 8
//            levelStart = mid != 0 ? mid + 1 : (int) Math.pow(2, floor);
//            mid = levelStart + (levelEnd - levelStart) / 2;
//
//            if (flag) {
//
//            } else {
//                //向左走
//                if (label > mid) {
//                    //如果pre不为0，那么就不是根节点，需要计算cur
//                    if (pre != 0) {
//
//                    }
//
//                    list.add(cur);
//                    if (cur == label) {
//                        break;
//                    }
//                } else {
//
//                }
//            }
//
//            level++;
//        }

        return null;
    }

    public static void main(String[] args) {

//        int level = 4;
//        int label = 14;
//        label = ((1 << level) - 1 + (1 << (level - 1)) - label) / 2;
//        System.out.println(label);
        double sqrt = Math.sqrt(14);
        System.out.println(sqrt);
        int level = (int) Math.floor(sqrt);
        System.out.println(level);
    }
}
