package com.company.leetcode.matrix;

public class GameOfLife {
    int[] x = {0, 0, 1, -1, -1, -1, 1, 1};
    int[] y = {1, -1, 0, 0, -1, 1, 1, -1};

    public static void main(String[] args) {
        GameOfLife g = new GameOfLife();
        int[][] a = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        g.gameOfLife(a);
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                process(i, j, ans, board);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ans[i][j];
            }
        }
    }

    private void process(int i, int j, int[][] ans, int[][] board) {
        int live = findLiveCells(i, j, board);
        if (board[i][j] == 1) {
            if (live < 2) {
                ans[i][j] = 0;
            } else if (live <= 3) {
                ans[i][j] = 1;
            } else if (live > 3) {
                ans[i][j] = 0;
            }
        } else {
            if (live == 3) {
                ans[i][j] = 1;
            }
        }
    }

    private int findLiveCells(int i, int j, int[][] board) {
        int live = 0;
        for (int k = 0; k < x.length; k++) {
            int xv = i + x[k];
            int yv = j + y[k];
            if (xv >= 0 && xv < board.length && yv >= 0 && yv < board[0].length && board[xv][yv] == 1) {
                live++;
            }
        }
        return live;
    }
}
