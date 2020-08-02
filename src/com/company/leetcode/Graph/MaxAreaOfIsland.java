package com.company.leetcode.Graph;

import java.beans.PropertyEditorSupport;

/**
 * https://leetcode.com/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] data = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(data));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int x[] = {-1, 1, 0, 0};
        int y[] = {0, 0, 1, -1};
        int max = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 2;
                    visited[i][j] = true;
                    int area = dfs(i, j, grid, visited, x, y);
                    max = Math.max(area, max);
                }
            }
        }
        return max;
    }

    private static int dfs(int i, int j, int[][] grid, boolean[][] visited, int[] x, int[] y) {
        int result = 1;
        for (int k = 0; k < x.length; k++) {
            int a = i + x[k];
            int b = j + y[k];
            if (check(a, b, grid, visited)) {
                visited[a][b] = true;
                grid[i][j] = 2;
                result += dfs(a, b, grid, visited, x, y);
            }
        }
        return result;
    }

    private static boolean check(int a, int b, int[][] grid, boolean[][] visited) {
        return a >= 0 && a < grid.length && b >= 0 && b < grid[0].length && !visited[a][b] && grid[a][b] == 1;
    }
}
