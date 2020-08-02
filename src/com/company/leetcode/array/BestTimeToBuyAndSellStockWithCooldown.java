package com.company.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        int data[] = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(data));
    }


    public static int maxProfit(int[] prices) {
        Map<String, Integer> map = new HashMap<>();
        return rec(0, 0, prices, map);
    }


    private static int rec(int i, int buyOrSell, int[] prices, Map<String, Integer> map) {

        if (i >= prices.length) return 0;
        String key = i + ":" + buyOrSell;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int profit = 0;
        if (buyOrSell == 0) {
            int buy = rec(i + 1, 1, prices, map) - prices[i];
            int noBuy = rec(i + 1, 0, prices, map);
            profit = Math.max(buy, noBuy);
        } else {
            int sell = rec(i + 2, 0, prices, map) + prices[i];
            int noSell = rec(i + 1, 1, prices, map);
            profit = Math.max(sell, noSell);
        }

        map.put(key, profit);
        return profit;
    }
}
