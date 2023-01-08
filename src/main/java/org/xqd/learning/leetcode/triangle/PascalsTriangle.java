package org.xqd.learning.leetcode.triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> list = generate(6);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.println(integer);
            }

            System.out.println("**********");
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows > 1) {
            generate(numRows - 1);
        } else {
            List<Integer> list = new ArrayList<>();
//            if (i == 0) {
//                list.add(1);
//                result.add(0, list);
//            } else if (i == 1) {
//                list.add(1);
//                list.add(1);
//                result.add(1, list);
//            }
        }

        return null;
    }


    //for
    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();

            if (i == 0) {
                list.add(1);
                result.add(0, list);
            } else if (i == 1) {
                list.add(1);
                list.add(1);
                result.add(1, list);
            } else {
                List<Integer> upList = result.get(i - 1);
                System.out.println(upList.toString());

                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        list.add(1);
                    } else {
                        System.out.println("当前 I " + j);
                        Integer up1 = upList.get(j - 1);
                        Integer up2 = upList.get(j);
                        list.add(up1 + up2);
                    }
                }

                result.add(i, list);
            }
        }

        return result;
    }
}
