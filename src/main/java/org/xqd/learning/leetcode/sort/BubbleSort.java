package org.xqd.learning.leetcode.sort;

/**
 * @author XuQidong
 * @date 2021/11/4 00:10
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {3, 4, 1, 5, 2, 7, 9, 8};
        new BubbleSort().sortByBubble(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * 1. 每次都比较紧邻的两个位置的值大小，如果前一个位置的值大，就要做交换。每一次遍历都会将一个最大值放到最末尾
     * 2. int j = 0 很重要。开始我设置了 int j = i; 如果第一个位置的值比后面位置的值大，除了第二个，那么不能被交换
     * 3. 遍历多少次呢，有多少个元素遍历多少次
     * @param array
     */
    public void sortByBubble(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = 0;
            while (j + 1 < array.length - i) {
                if(array[j] > array[j+1]) {
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }

                j++;
            }
        }
    }
}
