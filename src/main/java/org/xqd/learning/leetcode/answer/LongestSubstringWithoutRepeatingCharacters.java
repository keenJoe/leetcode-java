package org.xqd.learning.leetcode.answer;

/**
 * @author XuQidong
 * @date 2021/3/23 20:38
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        String s = "abcbacbb";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    public static int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            System.out.println("j:" + exist[s.charAt(j)]);
            while (exist[s.charAt(j)]) {
                exist[s.charAt(i)] = false;
                System.out.println("i:" + exist[s.charAt(i)]);
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(j - i + 1, maxLen);
            System.out.println(maxLen);
            System.out.println("********");
        }
        return maxLen;
    }
}
