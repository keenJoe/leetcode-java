package org.xqd.learning.leetcode.math;

/**
 * @description:
 * @author: Joe
 * @create: 2023-06-14 12:50
 **/

/**
 * 9. Palindrome Number
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        int L = 0;
        int R = chars.length - 1;

        while (L <= R) {
            if (chars[L] != chars[R]) {
                return false;
            }

            L++;
            R--;
        }

        return true;
    }
}
