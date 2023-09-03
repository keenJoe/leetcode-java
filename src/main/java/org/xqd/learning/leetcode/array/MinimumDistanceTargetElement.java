package org.xqd.learning.leetcode.array;


import java.util.Arrays;

/**
 * 1848. Minimum Distance to the Target Element
 */
public class MinimumDistanceTargetElement {
    public int getMinDistance(int[] nums, int target, int start) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (Math.abs(i - start) < min) {
                    min = Math.abs(i - start);
                }
            }
        }

        return min;
    }


//    public int getMinDistance(int[] nums, int target, int start) {
//        Arrays.sort(nums);
//
//        int minIndex = Integer.MAX_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            int j = bsearch(nums, target, i);
//            if (j != -1) {
//                if (j < minIndex) {
//                    minIndex = j;
//                }
//            }
//        }
//
//        return Math.abs(minIndex - start);
//    }
//
//    private int bsearch(int[] A, int key, int start) {
//        int L = start, R = A.length - 1;
//        while (L < R) {
//            int M = (L + R) / 2;
//            if (A[M] < key) {
//                L = M + 1;
//            } else {
//                R = M;
//            }
//        }
//        return (L == R && A[L] == key) ? L : -1;
//    }
}
