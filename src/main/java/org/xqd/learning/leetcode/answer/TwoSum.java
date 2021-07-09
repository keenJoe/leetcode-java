package org.xqd.learning.leetcode.answer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XuQidong
 * @date 2021/1/26 10:20
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 5};
        int[] twoSum = twoSum(array, 7);
        for (int i : twoSum) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            if (map.containsKey(target - x)) {
                return new int[]{map.get(target - x), i};
            }
            map.put(x, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
