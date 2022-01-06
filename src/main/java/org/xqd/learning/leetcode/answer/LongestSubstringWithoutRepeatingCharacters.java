package org.xqd.learning.leetcode.answer;

import java.util.LinkedList;

/**
 * @author XuQidong
 * @date 2021/10/19 06:38
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcbacbb";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) return 0;
        int maxLength = 0;

        char[] array = s.toCharArray();
        LinkedList<Character> characterLinkedList = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            char c = array[i];

            if(!characterLinkedList.contains(c)) {
                characterLinkedList.add(c);
                maxLength++;
            } else {
                //need to know the position of c in the linked list

            }
        }

        return maxLength;
    }
}
