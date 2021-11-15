package org.xqd.learning.leetcode.exercise;

import java.util.Arrays;

/**
 * @author XuQidong
 * @date 2021/11/4 00:08
 */
public class InsertingSort {
    public static void main(String[] args) {
        int[] array = {3, 4, 1, 5, 2, 7, 9, 8};
        new InsertingSort().sortByInserting(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public void sortByInserting(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[i];
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            if (i != j) {
                arr[j] = temp;
            }
        }

        System.out.println("**********");
        //return arr;
    }

    private void swap(int[] array, int j, int i) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
