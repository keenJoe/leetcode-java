package org.xqd.learning.leetcode.dp2;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        generate1(5);
    }


    public List<List<Integer>> generate(int numRows) {
        return null;
    }

    /**
     * 当numRows = 1和2的时候，值固定
     */
    public static List<List<Integer>> generate1(int numRows) {
        if (numRows == 1) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> one = new ArrayList<>();
            one.add(1);
            list.add(one);
            return list;
        }

        if (numRows == 2) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> one = new ArrayList<>();
            one.add(1);
            one.add(1);
            list.add(one);
            return list;
        }


        List<List<Integer>> list = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(1);
        list.add(one);

        List<Integer> two = new ArrayList<>();
        two.add(1);
        two.add(1);
        list.add(two);

//        for (int i = 3; i <= numRows; i++) {
//            List<Integer> preList = list.get(i - 2);
//            List<Integer> curList = new ArrayList<>();
//            curList.add(1);
//            for (int j = 1; j < i - 1; j++) {
//                curList.add(preList.get(j-1) + preList.get(j));
//            }
//            curList.add(1);
//            list.add(curList);
//        }
        List<List<Integer>> list1 = generate1(numRows - 1);


        return list;
    }
}
