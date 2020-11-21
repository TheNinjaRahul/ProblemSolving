package com.company.leetcode.Graph;

import java.util.*;

public class MinimumHeightTrees {
    public static void main(String[] args) {
        MinimumHeightTrees m = new MinimumHeightTrees();
        System.out.println(m.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
        System.out.println(m.findMinHeightTrees(1, new int[][]{}));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int min = Integer.MAX_VALUE;
        if (edges.length == 0 && n == 1) {
            List<Integer> list = new LinkedList<>();
            list.add(0);
            return list;
        }

        List<Integer> leaves = new LinkedList<>();
        List<Set<Integer>> adj = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }

        for (int a[] : edges) {
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }

        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new LinkedList<>();

            for (int i : leaves) {
                int t = adj.get(i).iterator().next();
                adj.get(t).remove(i);
                if (adj.get(t).size() == 1) {
                    newLeaves.add(t);
                }
            }
            leaves = newLeaves;
        }

        return leaves;

    }

    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {

        int min = Integer.MAX_VALUE;
        if (edges.length == 0 && n == 1) {
            List<Integer> list = new LinkedList<>();
            list.add(0);
            return list;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            if (!map.containsKey(edges[i][0])) map.put(edges[i][0], new LinkedList<>());
            if (!map.containsKey(edges[i][1])) map.put(edges[i][1], new LinkedList<>());
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        Map<Integer, List<Integer>> result = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int level = 0;
            Queue<Integer> q = new LinkedList<>();
            boolean visited[] = new boolean[n];
            if (!map.containsKey(i)) {
                continue;
            }
            visited[i] = true;
            for (int node : map.get(i)) {
                visited[node] = true;
                q.add(node);
            }

            visited[i] = true;

            boolean exceed = false;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    int temp = q.remove();

                    if (map.containsKey(temp)) {
                        for (int node : map.get(temp)) {
                            if (!visited[node]) {
                                visited[node] = true;
                                q.add(node);
                            }
                        }
                    }
                }
                level++;
                if (level > min) {
                    exceed = true;
                    break;
                }
            }
            if (!exceed) {
                if (!result.containsKey(level)) result.put(level, new LinkedList<>());
                result.get(level).add(i);
            }


        }

        return result.get(result.keySet().iterator().next());

    }
}
