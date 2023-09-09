package org.xqd.learning.leetcode.array;


import java.util.Arrays;

/**
 * 2594. Minimum Time to Repair Cars
 */
public class MinimumTime2RepairCars {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        int left = 1;
        int right = (int) (ranks[0] * Math.pow(cars, 2));

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 0; i < ranks.length; i++) {
                count += Math.sqrt(mid / ranks[i]);
            }

            if (count > cars) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
