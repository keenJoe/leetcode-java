package org.xqd.learning.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1921. Eliminate Maximum Number of Monsters
 */
public class EliminateMaximumNumberOfMonsters {
    public int eliminateMaximum(int[] dist, int[] speed) {
        //第i位置的monster需要多少分钟才能到达city，value越小则达到越快，应该优先击毙
        Map<Integer, Integer> map = new TreeMap<>();
        //distance equals zero, loss
        for (int i = 0; i < dist.length; i++) {
            int quotient = dist[i] / speed[i];
            int remainder = dist[i] % speed[i];
            if (remainder != 0) {
                quotient++;
            }
            map.put(i, quotient);
        }

        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        int count = 0;
        for (int i = 0; i < collect.size(); i++) {
            Map.Entry<Integer, Integer> monster = collect.get(i);
            if (monster.getValue() - 1 >= count) {
                count++;
            } else {
                return count;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] dist = new int[]{4, 8, 6, 8, 2, 7, 4};
        int[] speed = new int[]{1, 3, 3, 1, 10, 1, 1};

        Map<Integer, Integer> map = new TreeMap<>();
        //distance equals zero, loss
        for (int i = 0; i < dist.length; i++) {
            int quotient = dist[i] / speed[i];
            int remainder = dist[i] % speed[i];
            if (remainder != 0) {
                quotient++;
            }
            map.put(i, quotient);
        }

        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        System.out.println(collect);

        int count = 1;
        for (int i = 0; i < collect.size(); i++) {
            Map.Entry<Integer, Integer> monster = collect.get(i);
            if (monster.getValue() >= count) {
                count++;
            } else {
                //
            }
        }
    }
}
