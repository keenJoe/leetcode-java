package org.xqd.learning.leetcode.array;


/**
 * 2511. Maximum Enemy Forts That Can Be Captured
 */
public class MaximumEnemyFortsThatCanBeCaptured {
    public int captureForts(int[] forts) {
        int start = -1;
        int end = -1;
        int maximum = -1;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1) {
                start = i;
                if (start != -1 && end != -1 && start > end) {
                    end = -1;
                }
            }

            if (forts[i] == -1) {
                end = i;
                if (start != -1 && end != -1 && start < end) {
                    start = -1;
                }
            }

            if (start != -1 && end != -1) {
                int temp = Math.abs(start - end) - 1;
                if (temp > maximum) {
                    maximum = temp;
                }
            }
        }

        return maximum;
    }
}
