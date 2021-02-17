package com.company.leetcode.array;

import java.util.Arrays;

public class CoinChange2 {
    public static void main(String[] args) {
        int[] a = {1, 2, 5};
        System.out.println(change(5, a));
    }

    public static int change(int amount, int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        int dp[][] = new int[a.length + 1][amount + 1];

        dp[0][0] = 1;
        for (int i = 1; i < a.length + 1; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (j >= a[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][(j - a[i - 1])];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        for (int[] i : dp) {
            System.out.println(Arrays.toString(i));
        }
        return dp[a.length][amount];
    }
}
