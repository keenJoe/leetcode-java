package org.xqd.learning.leetcode.sort;

/**
 * @author XuQidong
 * @date 2021/11/4 00:08
 */
public class SelectingSort {
    public static void main(String[] args) {
        //int[] array = {3, 4, 1, 5, 2, 7, 9, 8};
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        new SelectingSort().sortBySelecting(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * 每次循环找到一个最小值，然后将这个最小值放到当前循环的起始位置
     *
     * @param array
     */
    public void sortBySelecting(int[] array) {
        for (int i = 0; i < array.length; i++) {
//            int j = i + 1;
//            while (j < array.length) {
//                if(array[j] < array[i]) {
//                    int t = array[i];
//                    array[i] = array[j];
//                    array[j] = t;
//                }
//                j++;
//            }
            int min = i;

            for (int j = i + 1; j < array.length; j++) {

                /**
                 * 但是很明显，这里可以继续优化
                 * 每次比较都做交换，这个根本没有必要。
                 * 只需要找出最小位置即可，然后做一次交换。
                 * 所以N个元素只需要做N次交换。
                 */
                if (array[j] < array[min]) {
                    min = j;
//                    int t = array[i];
//                    array[i] = array[j];
//                    array[j] = t;
                }
            }

            swap(array, i, min);
        }
    }

    private void swap(int[] array, int j, int i) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
