package org.xqd.learning.leetcode.answer.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XuQidong
 * @date 2022/5/21 23:02
 * <p>
 * LeetCode 3. Longest Substring Without Repeating Characters
 *
 * TODO
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        boolean isInterrupted = false;
        int repeated = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.get(c) == null) {
                map.put(c, i);

                if (isInterrupted && i - repeated >= (end - start + 1)) {
                    start = repeated + 1;
                    end = i;
                }

                if (!isInterrupted) {
                    end = i;
                }
            } else {
                isInterrupted = true;
                repeated = map.get(c);
                map.put(c, i);
            }
        }

        System.out.println(start);
        System.out.println(end);
        return end - start + 1;
    }

    public static void main(String[] args) {
//        String s = "pwwkew";
        String s = "nfpdmpi";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
