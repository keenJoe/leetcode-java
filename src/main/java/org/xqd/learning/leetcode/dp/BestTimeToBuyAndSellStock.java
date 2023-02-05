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
        int[] array = new int[length + 1];
        for (int i = 0; i < length; i++) {
            array[i] = process(prices, i, i);
        }

        return Arrays.stream(array).max().getAsInt();
    }

    public int process(int[] prices, int bIndex, int sIndex) {
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
