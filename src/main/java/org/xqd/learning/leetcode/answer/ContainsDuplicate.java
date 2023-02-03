package org.xqd.learning.leetcode.answer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XuQidong
 * @date 2022/1/5 21:55
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 1};
        long start = System.currentTimeMillis();
        boolean b = containsDuplicate(nums);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(b);
    }

    public static boolean containsDuplicate(int[] nums) {
        //sortByBubble(nums);
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.get(num) != null) {
                return true;
            } else {
                map.put(num, num);
            }
        }

        return false;
    }

    public static void sortByBubble(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = 0;
            while (j + 1 < array.length - i) {
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }

                j++;
            }
        }
    }
}
