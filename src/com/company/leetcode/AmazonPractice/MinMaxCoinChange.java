package com.company.leetcode.AmazonPractice;

import java.util.Arrays;

public class MinMaxCoinChange {
    public static void main(String[] args) {
        System.out.println(changeMin(3, new int[]{2}));
        System.out.println(changeMaxWays(3, new int[]{1, 2, 5}));
    }

    private static int changeMaxWays(int val, int[] a) {
        int dp[][] = new int[a.length + 1][val + 1];

        for (int i = 0; i < a.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return recMaxWays(val, a, a.length - 1, dp);
    }

    private static int recMaxWays(int val, int[] a, int i, int[][] dp) {
        if (val == 0) return 1;
        if (val < 0) return 0;
        if (i < 0) return 0;

        if (dp[i][val] != -1) {
            return dp[i][val];
        }

        int ans = 0;
        if (a[i] <= val) {
            ans = recMaxWays(val - a[i], a, i, dp) + recMaxWays(val, a, i - 1, dp);
        } else {
            ans = recMaxWays(val, a, i - 1, dp);
        }
        dp[i][val] = ans;
        return ans;
    }

    public static int changeMin(int val, int[] a) {
        int dp[][] = new int[a.length + 1][val + 1];
//        for (int i = 0; i < a.length; i++) {
//            dp[0][i] = Integer.MAX_VALUE - 10;
//        }

        for (int i = 0; i < a.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return rec(val, a, a.length - 1, dp);
    }

    private static int rec(int val, int[] a, int i, int[][] dp) {
        if (val <= 0) {
            return 0;
        }
        if (i < 0) {
            return Integer.MAX_VALUE - 1;
        }
        if (dp[i][val] != -1) {
            return dp[i][val];
        }
        int ans = Integer.MAX_VALUE - 1;
        if (a[i] <= val) {
            int m = 1 + rec(val - a[i], a, i, dp);
            if (m != Integer.MAX_VALUE) {
                ans = Math.min(m, rec(val, a, i - 1, dp));
            } else {
                ans = rec(val, a, i - 1, dp);
            }
        } else {
            ans = rec(val, a, i - 1, dp);
        }
        dp[i][val] = ans;
        return ans;
    }
}
