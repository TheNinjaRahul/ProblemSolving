package com.company.leetcode.array;

import java.util.*;

public class RestoreArray {


    int ans[] = null;

    public static void main(String[] args) {

    }

    public int[] restoreArray(int[][] a) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int ai[] : a) {
            if (!map.containsKey(ai[0])) map.put(ai[0], new LinkedList<>());
            if (!map.containsKey(ai[1])) map.put(ai[1], new LinkedList<>());
            map.get(ai[0]).add(ai[1]);
            map.get(ai[1]).add(ai[0]);
        }

        int n = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for (int val : list) {
                freq.put(val, freq.getOrDefault(val, 0) + 1);
            }
        }
        for (int key : map.keySet()) {
            if (freq.get(key) == 1) {
                n = key;
            }
        }

        List<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        dfs(set, n, list, map);

        return ans;
    }

    private void dfs(Set<Integer> set, int start, List<Integer> list, Map<Integer, List<Integer>> map) {
        if (list.size() == map.size()) {
            ans = new int[map.size()];
            int k = 0;
            for (int v : list) {
                ans[k++] = v;
            }
        }

        list.add(start);
        set.add(start);
        if (map.containsKey(start)) {
            for (int s : map.get(start)) {
                if (!set.contains(s)) {
                    dfs(set, s, list, map);
                }
            }
        }
    }
}
