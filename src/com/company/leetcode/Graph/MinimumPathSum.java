package com.company.leetcode.Graph;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int data[][] = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(minPathSum(data));
        System.out.println(minPathSum(new int[][]{{1, 2, 3}}));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length - 1;
        if (m == -1) return 0;
        int n = grid[0].length - 1;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[m][n] = grid[m][n];

        for (int i = m - 1; i >= 0; i--) {
            dp[i][n] = grid[i][n] + dp[i + 1][n];
        }

        for (int i = n - 1; i >= 0; i--) {
            dp[m][i] = grid[m][i] + dp[m][i + 1];
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }

    private static void print(int[][] dp) {
        for (int[] a : dp) {
            System.out.println(Arrays.toString(a));
        }
    }
}
