package org.xqd.learning.leetcode.answer.top100;

public class LengthOfLastWord {
    public static void main(String[] args) {

    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.equals("")) return 0;

        String[] array = s.split("\\ ");

        return array[array.length - 1].length();
    }
}
