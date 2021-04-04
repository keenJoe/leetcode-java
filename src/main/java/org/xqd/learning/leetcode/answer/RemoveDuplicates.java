package org.xqd.learning.leetcode.answer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XuQidong
 * @date 2021/2/5 22:30
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            String key = String.valueOf(nums[i]);
            System.out.println("current key is " + key);
            if (!map.containsKey(key)) {
                map.put(key, 1);
            }
        }

        System.out.println(map);

        return map.size();
    }
}
