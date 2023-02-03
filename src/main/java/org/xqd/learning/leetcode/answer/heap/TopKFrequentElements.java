package org.xqd.learning.leetcode.answer.heap;

import java.util.*;

/**
 * @author XuQidong
 * @date 2022/5/18 12:32
 * LeetCode 347.Top K Frequent Elements
 * <p>
 * Example 1
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * <p>
 * Example 2
 * Input: nums = [1], k = 1
 * Output: [1]
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int[] topKFrequent = topKFrequent(nums, 1);
        System.out.println(Arrays.toString(topKFrequent));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.merge(num, 1, Integer::sum);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());
        list.sort((m1, m2) -> m2.getValue() - m1.getValue());

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = list.get(i).getKey();
        }

        Arrays.sort(answer);

        return answer;
    }
}
