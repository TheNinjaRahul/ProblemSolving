package com.company.Graph;

import java.util.*;

public class UnHolyPath {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2}, {1, 6}, {2, 3}, {2, 4}, {2, 5}};
        int[] temples = new int[]{2, 3, 4};

        System.out.println(Solution(temples, edges, 6, 3));
    }

    static int Solution(int[] temples, int[][] edges, int n, int k) {
        boolean[] temple = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] a : edges) {
            if (!map.containsKey(a[0])) map.put(a[0], new LinkedList<>());
            if (!map.containsKey(a[1])) map.put(a[1], new LinkedList<>());
            map.get(a[0]).add(a[1]);
            map.get(a[1]).add(a[0]);
        }

        Set<Integer> templeSet = new HashSet<>();
        for (int t : temples) {
            map.remove(t);
            templeSet.add(t);
        }


//        int count = 0;
        My count = new My();
        boolean[] visted = new boolean[n + 1];
//        visted[1] = true;

        dfs(1, map, visted, templeSet, count);

        return count.count - 1;

    }

    private static void dfs(int start, Map<Integer, List<Integer>> map, boolean[] visted, Set<Integer> templeSet, My count) {

        if (visted[start]) return;
        if (templeSet.contains(start)) return;
        visted[start] = true;
        count.count++;
        if (map.containsKey(start)) {
            for (int i : map.get(start)) {
                dfs(i, map, visted, templeSet, count);
            }
        }
        visted[start] = true;
    }

    static class My {
        int count = 0;
    }

}
