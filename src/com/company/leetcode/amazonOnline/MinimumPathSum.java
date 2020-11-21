package com.company.leetcode.amazonOnline;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        MinimumPathSum l = new MinimumPathSum();
        int[][] a = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(l.minPathSum(a));
    }

    int min = Integer.MAX_VALUE;
    int x[] = {1, -1, 0, 0};
    int y[] = {0, 0, 1, -1};

    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        boolean v[][] = new boolean[grid.length][grid[0].length];
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], -1);
        }


        dfs(0, 0, grid, 0, v, dp);

        return dp[grid.length - 1][dp[0].length - 1];
    }

    public int dfs(int i, int j, int grid[][], int cost, boolean[][] v, int[][] dp) {
        if (dp[i][j] != -1) return dp[i][j];

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            min = Math.min(min, cost + grid[i][j]);
            return min;
        }
        v[i][j] = true;
        int m = Integer.MAX_VALUE;
        for (int k = 0; k < 4; k++) {
            int cx = x[k] + i;
            int cy = y[k] + j;

            if (cx >= 0 && cx < grid.length && cy >= 0 && cy < grid[0].length && !v[cx][cy]) {
                m = Math.min(m, dfs(cx, cy, grid, cost + grid[i][j], v, dp));
            }
        }
        dp[i][j] = m;
        v[i][j] = false;
        return m;
    }
}
