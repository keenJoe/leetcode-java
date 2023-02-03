package org.xqd.learning.leetcode.sort;

/**
 * @author XuQidong
 * @date 2021/12/8 17:13
 */
public class MergingSort {
    public static void main(String[] args) {
        int[] array = {3, 4, 1, 5, 2, 7, 9, 8};
        //new InsertingSort().sortByInserting2(array);
        sort(array, 0, array.length - 1);

        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void sort(int[] array, int left, int right) {
        if (left == right) {
            return;
        }

        int m = left + ((right - left) >> 1);
        sort(array, left, m);
        sort(array, m + 1, right);
        merge(array, left, m, right);
    }

    public static void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = 0;

        int leftStart = start;
        int rightStart = mid + 1;

        while (leftStart <= mid && rightStart <= end) {
            temp[i++] = array[leftStart] <= array[rightStart] ? array[leftStart++] : array[rightStart++];
        }

        //如果右侧数组越界
        while (leftStart <= mid) {
            temp[i++] = array[leftStart++];
        }

        while (rightStart <= end) {
            temp[i++] = array[rightStart++];
        }

        for (int j = 0; j < temp.length; j++) {
            array[start + j] = temp[j];
        }
    }
}
