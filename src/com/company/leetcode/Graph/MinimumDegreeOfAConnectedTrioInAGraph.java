package com.company.leetcode.Graph;

import java.util.*;

public class MinimumDegreeOfAConnectedTrioInAGraph {
    Set<Set<Integer>> ans = new HashSet<>();

    public static void main(String[] args) {

    }

    public int minTrioDegree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] a : edges) {
            if (!map.containsKey(a[0])) map.put(a[0], new LinkedList<>());
            if (!map.containsKey(a[1])) map.put(a[1], new LinkedList<>());
            map.get(a[0]).add(a[1]);
            map.get(a[1]).add(a[0]);
        }

        for (int key : map.keySet()) {
            Set<Integer> visited = new TreeSet<>();
            dfs(key, map, key, visited, 0);
        }

        return ans.size();
    }

    private void dfs(int key, Map<Integer, List<Integer>> map, int src, Set<Integer> visited, int level) {
        if (level == 3) {
            if (key == src) {
                ans.add(visited);
            }
            return;
        }
        visited.add(key);
        if (map.containsKey(key)) {
            for (int child : map.get(key)) {
                if (!visited.contains(child)) {
                    dfs(child, map, src, visited, level + 1);
                }
            }
        }
    }

}
