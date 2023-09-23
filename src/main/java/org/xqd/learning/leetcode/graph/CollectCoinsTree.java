package org.xqd.learning.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 2603. Collect Coins in a Tree
 */
public class CollectCoinsTree {
    public int collectTheCoins(int[] coins, int[][] edges) {
        //先确定哪些点有金币
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] == 1) {
                list.add(i);
            }
        }

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];


        }
    }
}
