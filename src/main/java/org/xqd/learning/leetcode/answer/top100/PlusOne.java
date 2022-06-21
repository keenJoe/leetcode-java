package org.xqd.learning.leetcode.answer.top100;

import java.util.Arrays;

/**
 * LeetCode 66. Plus One
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int carry = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            int n = digits[i];

            int r;
            if (i == digits.length - 1) {
                r = n + 1;
            } else {
                r = n + carry;
            }

            if (r > 9) {
                r = 0;
                carry = 1;
            } else {
                carry = 0;
            }

            result[i + 1] = r;
        }

        int[] finalResult = new int[digits.length];
        if (carry == 1) {
            result[0] = carry;
        } else {
            return Arrays.copyOfRange(result, 1, result.length);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 9, 9, 9};
        int[] result = plusOne(array);

        for (int i : result) {
            System.out.println(i);
        }
    }
}
