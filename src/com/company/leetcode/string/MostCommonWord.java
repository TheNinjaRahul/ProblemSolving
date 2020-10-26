package com.company.leetcode.string;

import java.util.*;

public class MostCommonWord {
    class Pair {
        String word;
        int freq;

        public Pair(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        paragraph=paragraph.toLowerCase();

        for (int i = 0; i < banned.length; i++) {
            set.add(banned[i]);
        }


        String p[] = paragraph.split(" ");
        for (int i = 0; i < p.length; i++) {
            if (p[i].contains(".")){
                p[i]=p[i].split(".")[0];
            }
            if(p[i].contains(",")){
                p[i]=p[i].split(",")[0];
            }
            if (!set.contains(p[i])) {
                   map.put(p[i], map.getOrDefault(p[i], 0) + 1);
            }
        }

        System.out.println(map);

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> {
            return b.freq - a.freq;
        });

        for (String key : map.keySet()) {
            q.offer(new Pair(key, map.get(key)));
        }

        return q.poll().word;

    }
}
