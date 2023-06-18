package org.xqd.learning.leetcode.hashtable;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 3. Longest Substring Without Repeating Characters
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abcabcbb";
        lengthOfLongestSubstring(str);
    }

    public int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLen = 0;
        while (right < s.length()) { // 遍历整个字符串
            if (!set.contains(s.charAt(right))) { // 如果右指针指向的字符没有出现在set中
                set.add(s.charAt(right)); // 将字符加入set中
                right++; // 右指针向右移动
                maxLen = Math.max(maxLen, set.size()); // 计算当前子串长度并更新最大长度
            } else {
                //需要注意，在else中，right值并没有变化。因为要删数据，直到删除不包含重复字符
                set.remove(s.charAt(left)); // 左指针向右移动，从set中删除字符，直到不包含重复字符
                left++;
            }
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        int start = 0, end = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();

        for (int i = 0; i < array.length; i++) {
            end = i;

            Integer index = map.get(array[i]);
            if (index != null) {
                start = Math.max(index + 1, start);
            }

            if (end - start + 1 > length) {
                length = end - start + 1;
            }

            map.put(array[i], i);
        }

        return length;
    }

    private static int checkIndex(Map<Character, Integer> map) {
        List<Integer> list = new ArrayList();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());

        int length = 0;
        for (int i = 1; i < collect.size(); i++) {
            if (collect.get(i) - collect.get(i - 1) != 1) {
                length = 1;
            } else {
                length++;
            }
        }

        return length;
    }
}
