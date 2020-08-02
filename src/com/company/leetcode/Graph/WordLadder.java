package com.company.leetcode.Graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String[] s = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> list = Arrays.asList(s);
        System.out.println(ladderLength("hit", "cog", list));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Boolean> map = new HashMap<>();
        for (String s : wordList) {
            map.put(s, false);
        }

        int level = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.remove();
                if (temp.equals(endWord)) {
                    return level;
                }
                getAllPossibleNext(queue, temp, map);
            }
            level++;
        }
        return 0;
    }

    private static void getAllPossibleNext(Queue<String> queue, String temp, Map<String, Boolean> map) {
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            for (int j = 0; j < temp.length(); j++) {
                char str[] = temp.toCharArray();
                str[j] = c;
                String s = String.valueOf(str);
                if (map.containsKey(s) && !map.get(s)) {
                    map.put(s, true);
                    queue.add(s);
                }
            }
        }
    }
}
