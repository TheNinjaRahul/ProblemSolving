package com.company.leetcode.Graph;

public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid={{0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                {
                    if(i==0 || grid[i-1][j]==0) count++;
                    if(i==grid.length-1 || grid[i+1][j]==0) count++;
                    if(j==0 || grid[i][j-1]==0) count++;
                    if(j==grid[0].length-1 || grid[i][j+1]==0) count++;
                }
            }
        }
        return count;
    }

    private static int getPerimeter(int[][] grid, int i, int j) {
        int count = 0;
        if (i >= 0 && i < grid.length) {
            if (i == 0) {
                count++;
            } else {
                if (grid[i - 1][j] == 0) {
                    count++;
                }
            }

            if (i == grid.length - 1) {
                count++;
            } else {
                if (grid[i + 1][j] == 0) {
                    count++;
                }
            }
        }

        if (j >= 0 && j < grid[0].length) {
            if (j == 0) {
                count++;
            } else {
                if (grid[i][j - 1] == 0) {
                    count++;
                }
            }

            if (j == grid[0].length - 1) {
                count++;
            } else {
                if (grid[i][j + 1] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
