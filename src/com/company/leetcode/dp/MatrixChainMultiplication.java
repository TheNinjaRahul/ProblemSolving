package com.company.leetcode.dp;

import com.company.GFG.dp.ArrayUtil;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int data2[] = {10, 30, 5, 60};
        System.out.println(mcm(data2));
        int data[] = {40, 20, 30, 10, 30};
        System.out.println(mcm(data));
    }


    public static int mcm(int[] a) {
        int dp[][] = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(a, 1, a.length - 1, dp);
    }

    public static int solve(int[] a, int i, int j, int[][] dp) {
        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = solve(a, i, k, dp) + solve(a, k + 1, j, dp) + (a[i - 1] * a[k] * a[j]);
            min = Math.min(temp, min);
        }
        dp[i][j] = min;
        System.out.println("***********[ " + i + "," + j + "]*****************");
        ArrayUtil.print(dp);
        System.out.println("****************************");
        return min;
    }
}
