package com.company.leetcode.matrix;

import com.company.GFG.Matrix.MatrixUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] d = {{'X', 'O', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        MatrixUtil.printMatrix(d);
        System.out.println("-------------");
        solve(d);
        MatrixUtil.printMatrix(d);
    }

    public static void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                    if (board[i][j] == 'O') {
                        dfs(i, j, board);
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j] == 'A'){
                    board[i][j]='O';
                }
            }
        }

    }

    private static void dfs(int i, int j, char[][] board) {
        board[i][j] = 'A';
        if (i - 1 >= 0 && board[i - 1][j] == 'O') {
            dfs(i - 1, j, board);
        }
        if (i + 1 < board.length && board[i + 1][j] == 'O') {
            dfs(i + 1, j, board);
        }
        if (j + 1 < board[0].length && board[i][j + 1] == 'O') {
            dfs(i, j + 1, board);
        }
        if (j + 1 < board[0].length && board[i][j + 1] == 'O') {
            dfs(i, j + 1, board);
        }
        if (j - 1 >= 0 && board[i][j - 1] == 'O') {
            dfs(i, j - 1, board);
        }
    }
}
