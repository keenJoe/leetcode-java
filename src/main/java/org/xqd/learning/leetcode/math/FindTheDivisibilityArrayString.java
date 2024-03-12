package org.xqd.learning.leetcode.math;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/**
 * 2575. Find the Divisibility Array of a String
 */
public class FindTheDivisibilityArrayString {
    public static void main(String[] args) {
        String str = "998244353";
        divisibilityArray(str, 3);
    }

    public static int[] divisibilityArray(String word, int m) {
//        int len = word.length();
//        int[] div = new int[len];
//
//        Map<Integer, Long> map = new HashMap<>();
//        for (int i = 0; i < len; i++) {
//            long num = 0;
//            for (int j = i; j >=0; j--) {
//                num = num * 10 + word.charAt(j) - '0';
//                System.out.println(num);
//                if (num % m == 0 && i == 0) {
//                    div[i] = 1;
//                }
//            }
//            for (int j = 0; j < i + 1; j++) {
//                num = num * 10 + word.charAt(j) - '0';
//                if (num % m == 0) {
//                    div[j] = 1;
//                }
//            }
//            int j = word.charAt(i) - '0';
//            if (i == 0) {
//                num = j;
//            } else {
//                num = map.get(i - 1) * 10 + j;
//            }
//
//            map.put(i, num);
//
//            if (num % m == 0) {
//                div[i] = 1;
//            }
//        }
//
//        return div;

        int len = word.length();
        int[] div = new int[len];

        Map<Integer, Long> map = new HashMap<>();
        long num = 0;
        for (int i = 0; i < len; i++) {

            int j = word.charAt(i) - '0';
            num = (num * 10 + j) % m;

            if (num == 0) {
                div[i] = 1;
            }
        }

        return div;
    }
}
