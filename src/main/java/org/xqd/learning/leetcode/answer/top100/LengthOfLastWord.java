package org.xqd.learning.leetcode.answer.top100;

public class LengthOfLastWord {
    public static void main(String[] args) {

    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.equals("")) return 0;

        String[] array = s.split("\\ ");

        return array[array.length - 1].length();
    }

    /**
     * Which of the following two methods is better?
     */

    public int lengthOfLastWordUsingFor(String s) {
        int length = 0;

        // We are looking for the last word so let's go backward
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') { // a letter is found so count
                length++;
            } else {  // it's a white space instead
                // Did we already started to count a word ? Yes so we found the last word
                // skip the whitespaces at the end of s
                if (length > 0) return length;
            }
        }
        return length;
    }

    public int lengthOfLastWordUsingWhile(String s) {
        if (s == null || s.length() == 0) return 0;
        int result = 0, i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') i--;   // Skip all whitespaces at the end of s.
        while (i >= 0 && s.charAt(i) != ' ') {      // Count the number of consecutive non-whitespace characters.
            result++;
            i--;
        }
        return result;
    }

    /**
     * 对每一个单词都判断一次，很显然这种方式性能会下降
     */
    public int lengthOfLastWordFromStart(String s) {
        int prev = 0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) != ' ') {
                if (i==0 || s.charAt(i-1) == ' ') {
                    prev=0;
                }
                prev ++;
            }

        }
        return prev;
    }
}
