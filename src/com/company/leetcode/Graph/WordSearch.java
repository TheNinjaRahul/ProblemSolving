package com.company.leetcode.Graph;

import java.util.Arrays;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}}; //{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        System.out.println(exist(board,"ABCCED"));
        System.out.println(exist(board, "AAB"));
    }


    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean result = findWordPresentOrNot(board, i, j, word, 0);
                    if (result) {
                        for (int k = 0; k < board.length; k++) {
                            System.out.println(String.valueOf(board[k]));
                        }
                        return true;
                    }
                    for (int k = 0; k < board.length; k++) {
                        System.out.println(String.valueOf(board[k]));
                    }
                }

            }
        }


        return false;
    }

    private static boolean findWordPresentOrNot(char[][] board, int i, int j, String word, int searchIndexWord) {
        if (searchIndexWord == word.length()) return true;
        if (i >= board.length || i < 0 || j < 0 || j >= board[0].length) return false;

        char prev = board[i][j];
        if (board[i][j] == word.charAt(searchIndexWord)) {
            board[i][j] = '$';
            boolean result = findWordPresentOrNot(board, i + 1, j, word, searchIndexWord + 1) ||
                    findWordPresentOrNot(board, i - 1, j, word, searchIndexWord + 1) ||
                    findWordPresentOrNot(board, i, j + 1, word, searchIndexWord + 1) ||
                    findWordPresentOrNot(board, i, j - 1, word, searchIndexWord + 1);

            if (result) return result;
        }
        board[i][j] = prev;
        return false;
    }
}
