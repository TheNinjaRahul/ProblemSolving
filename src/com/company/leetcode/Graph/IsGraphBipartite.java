package com.company.leetcode.Graph;

import java.util.*;

public class IsGraphBipartite {
    public static void main(String[] args) {
        int[][] edges = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        IsGraphBipartite isGraphBipartite = new IsGraphBipartite();
        System.out.println(isGraphBipartite.isBipartite(edges));
    }

    public boolean isBipartite(int[][] graph) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] a : graph) {
            if (!map.containsKey(a[0])) map.put(a[0], new LinkedList<>());
            if (!map.containsKey(a[1])) map.put(a[1], new LinkedList<>());
            map.get(a[0]).add(a[1]);
            map.get(a[1]).add(a[0]);
        }

        System.out.println(map);
        int[] visited = new int[map.size()];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int color = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int temp = q.remove();
                int expectedColor = color == 1 ? -1 : 1;
                if (visited[temp] == 0) {
                    visited[temp] = expectedColor;
                } else if (visited[temp] != expectedColor) {
                    return false;
                }
                for (int j : map.get(temp)) {
                    q.add(j);
                }
            }
        }

        return true;

    }


}
