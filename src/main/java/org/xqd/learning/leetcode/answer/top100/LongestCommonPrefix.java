package org.xqd.learning.leetcode.answer.top100;

import java.util.Stack;

/**
 * LeetCode 14. Longest Common Prefix
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return null;

        int shortestLength = 0;
        String shortestStr = strs[0];
        for (String str : strs) {
            if (str.length() < shortestStr.length()) {
                shortestStr = str;
            }
        }

        shortestLength = shortestStr.length();

        String longestCommonPrefix = "";
        for (int i = 0; i < shortestLength; i++) {
            String common = shortestStr.substring(i, i + 1);
            for (String str : strs) {
                if (!str.substring(i, i + 1).equals(common)) {
                    if (i > 1) {
                        return shortestStr.substring(0, i);
                    } else {
                        return "";
                    }
                }
            }
        }


        return "";
    }

    public static String longestCommonPrefix1(String[] strs) {
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
