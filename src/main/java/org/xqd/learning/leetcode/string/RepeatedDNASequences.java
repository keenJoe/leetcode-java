package org.xqd.learning.leetcode.string;

import java.util.*;

/**
 * 187. Repeated DNA Sequences
 */
public class RepeatedDNASequences {

    public static void main(String[] args) {
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(str.substring(0, 9));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        int start = 0;
        int end = 10;
        int length = s.length();

        while (end <= length) {
            String substring = s.substring(start, end);
            map.merge(substring, 1, Integer::sum);
            start++;
            end++;
        }

        List<String> list = new ArrayList<>();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }

        return list;
    }
}
