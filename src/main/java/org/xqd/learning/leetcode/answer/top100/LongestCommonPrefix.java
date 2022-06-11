package org.xqd.learning.leetcode.answer.top100;

import java.util.Stack;

/**
 * LeetCode 14. Longest Common Prefix
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return null;

        String shortestStr = strs[0];
        for (String str : strs) {
            if (str.length() < shortestStr.length()) {
                shortestStr = str;
            }
        }

        Stack<String> prefix = new Stack<>();
        for (int i = shortestStr.length(); i > 0; i--) {
            prefix.add(shortestStr.substring(0, i));
        }

        boolean isBroken = false;
        String longestPrefix = "";

        for (String s : prefix) {
            for (String str : strs) {
                if (!str.startsWith(s)) {
                    isBroken = true;
                    break;
                }
            }

            if (isBroken) {
                isBroken = false;
                continue;
            }

            if (s.length() > longestPrefix.length()) {
                longestPrefix = s;
            }
        }

        return longestPrefix;
    }
}
