package com.company.leetcode.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class SortestPathInMatrix {
    public static void main(String[] args) {
        SortestPathInMatrix sp = new SortestPathInMatrix();
        int[][] a = {{0, 1}, {1, 0}};
        System.out.println(sp.shortestPathBinaryMatrix(a));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        if (m == 0) return -1;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        if (grid[0][0] == 0) {
            q.add(new int[]{0, 0});
        } else {
            return -1;
        }

        int[] x = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] y = {0, 0, 1, -1, 1, -1, -1, 1};


        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] temp = q.remove();
                for (int j = 0; j < x.length; j++) {
                    int cx = temp[0] + x[j];
                    int cy = temp[1] + y[j];
                    if (isValid(cx, cy, m, n, visited, grid)) {
                        visited[cx][cy] = true;
                        if (cx == m - 1 && cy == n - 1) {
                            return level + 1;
                        }
                        q.add(new int[]{cx, cy});
                    }
                }
            }
            level++;
        }

        return -1;

    }

    private boolean isValid(int cx, int cy, int m, int n, boolean[][] visited, int[][] grid) {
        if (cx >= 0 && cx < m && cy >= 0 && cy < n && grid[cx][cy] == 0 && !visited[cx][cy]) {
            return true;
        }
        return false;
    }
}
