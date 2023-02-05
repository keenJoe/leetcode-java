package org.xqd.learning.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 */
public class PascalsTriangleII {
    public static void main(String[] args) {
        List<Integer> row = getRow(3);
        System.out.println(row);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();

        if (rowIndex == 0) {
            list.add(1);
            return list;
        }

        if (rowIndex == 1) {
            list.add(1);
            list.add(1);
            return list;
        }

        int[][] array = new int[rowIndex + 1][rowIndex + 1];
        array[0][0] = 1;

        array[1][0] = 1;
        array[1][1] = 1;

        for (int i = 2; i < array.length; i++) {
            array[i][0] = 1;
            array[i][i] = 1;

            for (int j = 1; j < i; j++) {
                array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
            }
        }

        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(array[rowIndex][i]);
        }

        return list;
    }

    public static List<Integer> getRow2(int rowIndex) {
        if (rowIndex == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }

        if (rowIndex == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            return list;
        }

        List<Integer> upRow = getRow(rowIndex - 1);
        Integer[] currentRow = new Integer[upRow.size() + 1];
        currentRow[0] = 1;
        currentRow[upRow.size()] = 1;

        for (int i = 0; i < upRow.size() - 1; i++) {
            currentRow[i + 1] = upRow.get(i) + upRow.get(i + 1);
        }

        return Arrays.asList(currentRow);
    }

    public List<Integer> getRow1(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rowIndex; i++) {
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

        return result.get(rowIndex);
    }
}
