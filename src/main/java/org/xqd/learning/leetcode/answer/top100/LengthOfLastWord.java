package org.xqd.learning.leetcode.answer.top100;

import org.junit.jupiter.api.Test;

/**
 * @author XuQidong
 * @date 2022/7/26 14:44
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        lengthOfLastWord("Hello World");
    }

    //@Test
    public static int lengthOfLastWord(String s) {
        if (s == null || s.equals("")) return 0;

        String[] array = s.split("\\ ");
        for (String s1 : array) {
            System.out.println(s1);
        }

        return array[array.length - 1].length();
    }
}
