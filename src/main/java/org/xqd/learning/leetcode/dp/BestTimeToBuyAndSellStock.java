package org.xqd.learning.leetcode.dp;

import java.util.Arrays;

/**
 * 121. Best Time to Buy and Sell Stock
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int[] array = {7, 1, 5, 3, 6, 4};
        int i = bestTimeToBuyAndSellStock.maxProfit(array);
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        int length = prices.length;
//        int[] array = new int[length + 1];
//        for (int i = 0; i < length; i++) {
//            int bIndex = i;
//            array[i] = process(prices, bIndex, length - 1);
//        }
//
//        return Arrays.stream(array).max().getAsInt();
        return process(prices, 0, length - 1);
    }


    public int process(int[] prices, int bIndex, int sIndex) {
        if (bIndex == sIndex) {
            return 0;
        }

        int profit = prices[sIndex] - prices[bIndex];

        int p1 = Math.max(process(prices, bIndex, sIndex - 1), profit);
        int p2 = Math.max(process(prices, bIndex + 1, sIndex), p1);
        return p2;
    }

    public int process1(int[] prices, int bIndex, int sIndex) {
        int buy = prices[bIndex];

        int sell = prices[sIndex];
        for (int i = sIndex; i < prices.length; i++) {
            if (prices[i] > sell) {
                sell = prices[i];
            }
        }

        return sell - buy;
    }
}
