package com.company.leetcode.Graph;

import java.util.*;

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */
public class AllPathSourceToTarget {
    public static void main(String[] args) {
//        int[][] data = {{1, 2}, {3}, {3}, {}};
        int[][] data = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(allPathsSourceTarget(data));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        curr.add(0);
        dfs(0, graph, graph.length - 1, lists, curr);
        return lists;
    }

    private static void dfs(int current, int[][] graph, int target, List<List<Integer>> lists, List<Integer> curr) {
        if (current == target) {
            lists.add(new LinkedList<>(curr));
            return;
        }

        for (Integer val : graph[current]) {
            curr.add(val);
            dfs(val, graph, target, lists, curr);
            curr.remove(curr.size() - 1);
        }
    }

    public static List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (!map.containsKey(i)) map.put(i, new LinkedList<>());
                map.get(i).add(graph[i][j]);
            }
        }

        List<List<Integer>> masterList = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        for (Integer c : map.get(0)) {
            for (List<Integer> mini : dfs(c, graph.length - 1, map, visited)) {
                if (mini.size() != 0) {
                    mini.add(0, 0);
                    masterList.add(mini);
                }
            }
        }
        return masterList;
    }

    private static List<List<Integer>> dfs(Integer current, int target, Map<Integer, List<Integer>> map, boolean[] visited) {
        List<List<Integer>> master = new LinkedList<>();
        if (current == target) {
            List<Integer> mini = new LinkedList<>();
            mini.add(current);
            master.add(mini);
            return master;
        }
//        if (visited[current]) return master;
////        visited[current] = true;
        for (Integer c : map.get(current)) {
            for (List<Integer> mini : dfs(c, target, map, visited)) {
                if (mini.size() != 0) {
                    mini.add(0, current);
                    master.add(mini);
                }
            }
        }
        return master;
    }
}
