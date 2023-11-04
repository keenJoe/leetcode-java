package org.xqd.learning.leetcode.dp2;

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
        return 0;
    }

    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            }

            int temp = prices[i] - buy;
            if (temp > maxProfit) {
                maxProfit = temp;
            }
        }

        return maxProfit;
    }

    public int process(int[] prices) {
        int length = prices.length;
        int[][] array = new int[length][length];

        for (int sellIndex = 1; sellIndex < length; sellIndex++) {
            int col = sellIndex;
            for (int row = 0; row < length - sellIndex; row++) {
                int p1 = Math.max(array[row][col - 1], array[row + 1][col]);
                int p2 = Math.max(p1, prices[col] - prices[row]);
                array[row][col] = p2;

                col += 1;
            }
        }

        return array[0][prices.length - 1];
    }


    public int process2(int[] prices, int bIndex, int sIndex) {
        if (bIndex == prices.length || sIndex == prices.length) {
            return 0;
        }

        int profit = prices[sIndex] - prices[bIndex];

        int p1 = Math.max(process2(prices, bIndex, sIndex - 1), profit);
        int p2 = Math.max(process2(prices, bIndex + 1, sIndex), p1);
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
