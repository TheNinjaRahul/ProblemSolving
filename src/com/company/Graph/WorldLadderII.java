package com.company.Graph;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

import java.util.*;

public class WorldLadderII {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");

        WorldLadderII wl2 = new WorldLadderII();
        System.out.println(wl2.findLadders("hit", "cog", list));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dic = new HashSet<>(wordList);
        Map<String, List<String>> adjMap = new HashMap<>();
        Map<String, Integer> parentLevelMap = new HashMap<>();
        parentLevelMap.put(beginWord, 1);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int maxLevel = 0;
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.remove();
                if (temp.equals(endWord)) maxLevel = level;
                adjMap.put(temp, new LinkedList<>());
                getAllChild(level, parentLevelMap, adjMap, queue, temp, dic);
            }
            level++;
        }

        List<List<String>> list = new LinkedList<>();
        List<String> current = new LinkedList<>();
        current.add(beginWord);
        dfs(adjMap, list, beginWord, endWord, maxLevel, current);
        System.out.println(list);
//        System.out.println(maxLevel);
//        System.out.println(adjMap);
        return list;
    }

    private void dfs(Map<String, List<String>> adjMap, List<List<String>> list, String begin, String end, int maxLevel, List<String> current) {
        if (begin.equals(end)) {
            list.add(new LinkedList<String>(current));
            return;
        }
        if (current.size() > maxLevel) return;
        for (String s : adjMap.get(begin)) {
            current.add(s);
            dfs(adjMap, list, s, end, maxLevel, current);
            current.remove(current.size() - 1);
        }
    }

    private void getAllChild(int level, Map<String, Integer> parentLevelMap, Map<String, List<String>> adjMap, Queue<String> queue, String w, Set<String> dic) {

        char[] c = w.toCharArray();

        for (int i = 0; i < c.length; i++) {
            char last = c[i];
            for (int j = 0; j < 26; j++) {
                c[i] = (char) ('a' + j);
                String found = String.valueOf(c);
                if (dic.contains(String.valueOf(c))) {
                    if (parentLevelMap.containsKey(found)) {
                        if (level != parentLevelMap.get(found) && level < parentLevelMap.get(found)) {
                            adjMap.get(w).add(found);
                        }
                    } else {
                        parentLevelMap.put(found, level + 1);
                        adjMap.get(w).add(found);
                    }
                    if (level < parentLevelMap.get(found)) {
                        queue.add(found);
                    }
                }
            }
            c[i] = last;
        }
    }
}
