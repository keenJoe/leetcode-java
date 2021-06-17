package org.xqd.learning.leetcode.answer;

import java.util.Arrays;

/**
 * @author XuQidong
 * @date 2021/3/23 20:38
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        String s = "abcbacbb";
        int length = lengthOfLongestSubstringN(s);
        System.out.println(length);
    }

    public static int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            System.out.println("j:" + j);
            System.out.println(s.charAt(j) + ":" + exist[s.charAt(j)]);

            while (exist[s.charAt(j)]) {
                exist[s.charAt(i)] = false;
                System.out.println(s.charAt(i) + ":" + exist[s.charAt(i)]);
                i++;
                System.out.println("i:" + i);
            }

            exist[s.charAt(j)] = true;
            System.out.println(s.charAt(j) + ":" + exist[s.charAt(j)]);
            maxLen = Math.max(j - i + 1, maxLen);
            System.out.println(maxLen);
            System.out.println("********");
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstringN(String s) {
        int[] charMap = new int[256];
        Arrays.fill(charMap, -1);
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            System.out.println("j: " + j);

            // 和上一个相比，这次直接定位到重复字符的位置，而不需要考虑前面的其他字符
            // 因为前面的字符也没有用了
            // 这个有点难啊
            // 这里需要处理字符串的各种类型
            if (charMap[s.charAt(j)] >= i) {
                i = charMap[s.charAt(j)] + 1;
                System.out.println("i: " + i);
            }
            charMap[s.charAt(j)] = j;
            maxLen = Math.max(j - i + 1, maxLen);
            System.out.println("*********");
        }
        return maxLen;
    }
}
