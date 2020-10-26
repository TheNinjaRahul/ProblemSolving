package com.company.leetcode.amazonOnline;

import java.util.*;

public class TopKFreqWords {
    public static void main(String[] args) {

    }

    class Pair {
        String word;
        int freq;

        public Pair(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> {
            int diff = b.freq - a.freq;
            if (diff == 0) {
                return a.word.compareTo(b.word);
            } else {
                return diff;
            }
        });

        for (String key : map.keySet()) {
            q.add(new Pair(key, map.get(key)));
        }

        List<String> output = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            Pair p = q.remove();
            output.add(p.word);
        }

        Collections.sort(output);

        return output;
    }
}
