package com.company.GFG.dp;

import java.util.Arrays;

public class KnapSack01 {
    public static void main(String[] args) {
        int[] v3 = {1, 2, 3, 2, 2};
        int w3[] = {8, 4, 0, 5, 3};
        System.out.println(knapSack2(4, w3, v3, 5) + " " + knapSack(4, w3, v3, 5));


        int[] v2 = {60, 100, 120};
        int[] w2 = {10, 20, 30};
        System.out.println(knapSack2(50, w2, v2, 3) + " " + knapSack(50, w2, v2, 3));

        int[] v1 = {1, 2, 3};
        int[] w1 = {4, 5, 1};
        System.out.println(knapSack2(4, w1, v1, 3) + " " + knapSack(4, w1, v1, 3));
    }


    static int knapSack2(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }


        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    static int knapSack(int W, int wt[], int val[], int n) {
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return recKnapSack(W, wt, val, n - 1, dp);
    }

    private static int recKnapSack(int w, int[] wt, int[] val, int n, int[][] dp) {
        if (n == -1 || w == 0) return 0;
        int cv = 0;
        if (dp[n][w] != -1) {
            return dp[w][n];
        }
        if (wt[n] <= w) {
            cv = val[n] + recKnapSack(w - wt[n], wt, val, n - 1, dp);
        }
        int ans = Math.max(cv, recKnapSack(w, wt, val, n - 1, dp));
        dp[n][w] = ans;
        return ans;
    }
}
