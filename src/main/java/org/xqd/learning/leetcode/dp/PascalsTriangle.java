package org.xqd.learning.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> list = generate2(6);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.println(integer);
            }

            System.out.println("**********");
        }

        System.out.println("============");

        List<List<Integer>> list1 = generate1(6);
        for (List<Integer> integers : list1) {
            for (Integer integer : integers) {
                System.out.println(integer);
            }

            System.out.println("**********");
        }
    }

    public static List<List<Integer>> generate2(int numRows) {
        int n = numRows;
        List<List<Integer>> generate = generate(numRows);
        if (n > 2) {
            int size = generate.size();
            List<Integer> last = generate.get(size - 1);
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int i = 1; i <= n - 2; i++) {
                current.add(last.get(i - 1) + last.get(i));
            }
            current.add(1);
            generate.add(current);
        }

        return generate;
    }

    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(1);
            result.add(list);
            return result;
        }

        if (numRows == 2) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(1);
            result.add(list);

            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            list1.add(1);
            result.add(list1);
            return result;
        }

        /**
         * 当 n = 3 时，1 <= i <= n-2，i 的值等于上一层，这里是n=2，的i-1和i 的元素和
         */
        int n = numRows - 1;
        List<List<Integer>> generate = generate(n);

        if (n > 2) {
            int size = generate.size();
            List<Integer> last = generate.get(size - 1);
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int i = 1; i <= n - 2; i++) {
                current.add(last.get(i - 1) + last.get(i));
            }
            current.add(1);
            generate.add(current);
        }

        return generate;
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
