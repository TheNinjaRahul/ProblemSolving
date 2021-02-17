package com.company.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrintMinCoinChange {
    public static void main(String[] args) {

    }

    public static int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);
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

        System.out.println(map);
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
