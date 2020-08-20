package com.company.leetcode.backtracking;

import java.util.Arrays;

public class Sudoku {

    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        char[][] b = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        s.solveSudoku(b);
        s.print(b);
    }

    public void print(char[][] b) {
        for (char[] c : b) {
            System.out.println(Arrays.toString(c));
        }
    }

    public void solveSudoku(char[][] board) {
        int row = -1;
        int col = -1;

        boolean isBoardFull = true;


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    isBoardFull = false;
                    row = i;
                    col = j;
                    break;
                }
            }
            if (!isBoardFull) {
                break;
            }
        }

        if (isBoardFull) return;

        for (int i = 1; i <= 9; i++) {
            if (isSafe(row, col, i, board)) {
                board[row][col] = String.valueOf(i).charAt(0);
                solveSudoku(board);
                if (isBoardFull(board)) {
                    return;
                } else {
                    board[row][col] = '.';
                }

            }
        }

    }

    private boolean isBoardFull(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(int row, int col, int num, char[][] board) {

        char c = String.valueOf(num).charAt(0);

        //check row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == c) {
                return false;
            }
        }

        //check col
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == c) {
                return false;
            }
        }

        // checkBox
        // Get begining cell of the local 3x3 grid
        int blkrow = (row / 3) * 3, blkcol = (col / 3) * 3;

        // Remove 3x3 grid values
        for (int i = blkrow; i < blkrow + 3; i++) {
            for (int j = blkcol; j < blkcol + 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }

        return true;

    }
}
