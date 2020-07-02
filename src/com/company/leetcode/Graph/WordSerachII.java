package com.company.leetcode.Graph;

import java.util.*;

public class WordSerachII {
    public static void main(String[] args) {

        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};

        System.out.println(findWords(board, words));

    }

    public static List<String> findWords(char[][] board, String[] words) {
        Map<Character, List<String>> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!map.containsKey(board[i][j])) map.put(board[i][j], new LinkedList<>());

                map.get(board[i][j]).add(i + ":" + j);
            }
        }

        System.out.println(map);

        Set<String> list = new HashSet<>();
        for (String input : words) {
            if (map.containsKey(input.charAt(0))) {
                for (String index : map.get(input.charAt(0))) {
                    String[] indexs = index.split(":");
                    if (findWordPresentOrNot(board, Integer.parseInt(indexs[0]), Integer.parseInt(indexs[1]), input, 0)) {
                        list.add(input);
//                        for(int i=0;i<board.length;i++){
//                            System.out.println(String.valueOf(board[i]));
//                        }
                    }
                }

            }
        }
        List<String> list1=new LinkedList<>();
        list1.addAll(list);
        return list1;
    }

    private static boolean findWordPresentOrNot(char[][] board, int i, int j, String word, int searchIndexWord) {
        if (searchIndexWord == word.length()) return true;
        if (i >= board.length || i < 0 || j < 0 || j >= board[0].length) return false;

        char prev = board[i][j];
        boolean result=false;
        if (board[i][j] == word.charAt(searchIndexWord)) {
            board[i][j] = '$';
            result = findWordPresentOrNot(board, i + 1, j, word, searchIndexWord + 1) ||
                    findWordPresentOrNot(board, i - 1, j, word, searchIndexWord + 1) ||
                    findWordPresentOrNot(board, i, j + 1, word, searchIndexWord + 1) ||
                    findWordPresentOrNot(board, i, j - 1, word, searchIndexWord + 1);
        }
        board[i][j] = prev;
        if (result) return result;
        return false;
    }
}
