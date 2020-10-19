package com.company.Graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Set<String> weAddedYet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int level = 1;
        while (!queue.isEmpty()) {
            // System.out.println(queue);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String w = queue.remove();
                if (w.equals(endWord)) return level;
                getAllPossibleWords(queue, w, weAddedYet, set);
            }
            level++;
        }

        return 0;
    }

    private void getAllPossibleWords(Queue<String> queue, String w, Set<String> addedYet, Set<String> dic) {
        char[] c = w.toCharArray();

        for (int i = 0; i < c.length; i++) {
            char last=c[i];
            for (int j = 0; j < 26; j++) {
                c[i] = (char) ('a' + j);
                // System.out.println(String.valueOf(c));
                if (dic.contains(String.valueOf(c)) && !addedYet.contains(String.valueOf(c))) {
                    queue.add(String.valueOf(c));
                    addedYet.add(String.valueOf(c));
                }
            }
            c[i]=last;
        }
    }
}
