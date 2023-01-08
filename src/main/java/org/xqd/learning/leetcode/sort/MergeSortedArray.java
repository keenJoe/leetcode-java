package org.xqd.learning.leetcode.sort;

/**
 * 88. Merge Sorted Array
 */
public class MergeSortedArray {

    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n > 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
        } else if (m > 0 && n > 0) {
            int j = 0;
            for (int i = 0; i < nums2.length; i++) {
                int n2 = nums2[i];

                //TODO
            }
        }
    }
}
