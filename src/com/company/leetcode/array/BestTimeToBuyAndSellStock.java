package com.company.leetcode.array;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] data = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(data));
    }

    public static int maxProfit(int[] prices) {
        int min[] = new int[prices.length];
        int max[] = new int[prices.length];

        min[0] = prices[0];
        int minValue = prices[0];
        int maxValue = prices[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            minValue = Math.min(minValue, prices[i]);
            min[i] = minValue;
        }
        for (int i = prices.length - 2; i >= 0; i--) {
            maxValue = Math.max(maxValue, prices[i]);
            max[i] = maxValue;
        }

        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            result = Math.max(result, max[i] - min[i]);
        }
        return result;
    }
}
