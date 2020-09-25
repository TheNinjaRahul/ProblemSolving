package com.company.leetcode.dp;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public static void main(String[] args) {

//        int d2[] = {186, 419, 83, 408};
//        System.out.println(coinChange(d2, 6249));
        int data[] = {1, 2, 5};
        System.out.println(coinChange(data, 11));


    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if (dp[amount] == amount + 1) return -1;
        return dp[amount];
    }

    public static int coinChange2(int[] coins, int amount) {
        int result = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] <= amount) {
                int r = rec(amount - coins[i], coins, map);
                if (coins[i] - amount == 0) {
                    return 1;
                }
                if (r != -1) {
                    result = Math.min(result, r + 1);
                }
            }
        }

        if (result == Integer.MAX_VALUE) return -1;
        return result;
    }

    private static int rec(int amount, int[] coins, Map<Integer, Integer> map) {
        int result = Integer.MAX_VALUE;
        if (amount == 0) return 1;
        if (map.containsKey(amount)) {
            return map.get(amount);
        }

        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] <= amount) {
                if (coins[i] - amount == 0) {
                    return 1;
                }
                int r = rec(amount - coins[i], coins, map);
                if (r != -1) {
                    result = Math.min(result, r + 1);
                }
            }
        }

        if (result == Integer.MAX_VALUE) {
            map.put(amount, -1);
            return -1;
        } else {
            map.put(amount, result);
            return result;
        }
    }
}
