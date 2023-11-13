package org.xqd.learning.leetcode.array;

/**
 * 11. Container With Most Water
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int area = 0;
        while (start < end) {
            int h = Math.min(height[start], height[end]);
            area = Math.max(h * (end - start), area);
            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }

//        for (int i = 0; i <= height.length - 1; i++) {
//            int start = 0;
//            while (start <= end) {
//                int h = Math.min(height[start], height[end]);
//                area = Math.max(h * (end - start), area);
//                start++;
//            }
//            end--;
//        }

        return area;
    }
}
