package com.company.GFG.dp;

import java.util.Arrays;

public class KnapSack01 {
    public static void main(String[] args) {
        int[] v3 = {1, 2, 3, 2, 2};
        int w3[] = {8, 4, 0, 5, 3};
        System.out.println(knapSack(4, w3, v3, 5));


        int[] v2 = {60, 100, 120};
        int[] w2 = {10, 20, 30};
        System.out.println(knapSack(50, w2, v2, 3));

        int[] v1 = {1, 2, 3};
        int[] w1 = {4, 5, 1};
        System.out.println(knapSack(4, w1, v1, 3));
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
