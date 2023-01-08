package org.xqd.learning.leetcode.answer.dp;


/**
 * 516. Longest Palindromic Subsequence
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {

    }

    public int longestPalindromeSubseq(String s) {
        if (s == null || "".equals(s) || s.length() == 0) return 0;

        return f(s.toCharArray(), 0, s.length() - 1);
    }

    private int f(char[] toCharArray, int start, int end) {
        if (start == end) return 1;

        if (start == end - 1) {
            return toCharArray[start] == toCharArray[end] ? 2 : 1;
        }

        int r1 = f(toCharArray, start, end - 1);
        int r2 = f(toCharArray, start + 1, end);
        int r3 = f(toCharArray, start + 1, end - 1);
        int r4 = toCharArray[start] == toCharArray[end] ? 2 + f(toCharArray, start + 1, end - 1) : 0;
        return Math.max(Math.max(r1, r2), Math.max(r3, r4));
    }

    private int f1(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int[][] array = new int[length - 1][length - 1];

        for (int i = 0; i < length; i++) {
            array[i][i] = 1;
            if (i < length - 1) {
                array[i][i + 1] = chars[i] == chars[i + 1] ? 2 : 1;
            }
        }


        for (int start = length - 3; start >= 0; start--) {
            for (int end = start + 2; end < length; end++) {
                array[start][end] = Math.max(array[start][end - 1], array[start + 1][end]);
                if (chars[start] == chars[end]) {
                    array[start][end] = Math.max(array[start][end], 2 + array[start + 1][end - 1]);
                }
            }
        }

        return array[0][length - 1];
    }


}
