package com.company.leetcode.array;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {

        int data5[] = {2, 1, 2, 0, 1};
        System.out.println(maxProfit(data5));

        int data4[] = {2, 2, 5};
        System.out.println(maxProfit(data4));

        int data[] = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(data));

        int[] data3 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(data3));

        int[] data2 = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(data2));


    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;
        int buyValue = prices[0];
        int profitTillNow = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buyValue == Integer.MIN_VALUE) {
                buyValue = prices[i];
                continue;
            }
            if (buyValue > prices[i]) {
                buyValue = prices[i];
                continue;
            }
            if (buyValue <= prices[i] && i + 1 < prices.length && prices[i] <= prices[i + 1]) {
                continue;
            } else {
                profitTillNow += prices[i] - buyValue;
                buyValue = Integer.MIN_VALUE;
            }
        }
        return profitTillNow;
    }
}
