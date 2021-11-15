package org.xqd.learning.leetcode.exercise;

/**
 * @author XuQidong
 * @date 2021/11/4 00:08
 */
public class SelectingSort {
    public static void main(String[] args) {
        int[] array = {3, 4, 1, 5, 2, 7, 9, 8};
        new SelectingSort().sortBySelecting(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * 每次循环找到一个最小值，然后将这个最小值放到当前循环的起始位置
     * @param array
     */
    public void sortBySelecting(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = i + 1;
            while (j < array.length) {
                if(array[j] < array[i]) {
                    int t = array[i];
                    array[i] = array[j];
                    array[j] = t;
                }
                j++;
            }
        }
    }
}
