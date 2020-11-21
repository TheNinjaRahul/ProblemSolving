package com.company.leetcode.Graph;

import java.util.*;

public class CriticalConnectionsinANetwork {
    public static void main(String[] args) {
        CriticalConnectionsinANetwork cc = new CriticalConnectionsinANetwork();
        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> l1 = new LinkedList<>();
        l1.add(0);
        l1.add(1);
        connections.add(l1);
        List<Integer> l2 = new LinkedList<>();
        l2.add(2);
        l2.add(1);
        connections.add(l2);
        List<Integer> l3 = new LinkedList<>();
        l3.add(0);
        l3.add(2);
        connections.add(l3);
        List<Integer> l4 = new LinkedList<>();
        l4.add(3);
        l4.add(1);
        connections.add(l4);

        System.out.println(cc.criticalConnections(4, connections));
    }

    int time = 0;
    int[] disc;
    int[] low;
    List<Integer>[] graph;
    List<List<Integer>> result;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
//        System.out.println(connections);
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> list : connections) {
            graph[list.get(0)].add(list.get(1));
            graph[list.get(1)].add(list.get(0));
        }
        System.out.println(graph);
        boolean[] visited = new boolean[n];
        disc = new int[n];
        low = new int[n];
        result = new LinkedList<>();

        dfs(0, -1, visited);
        return result;
    }

    private void dfs(int current, int parent, boolean[] visited) {
        disc[current] = low[current] = time++;
        visited[current] = true;
        for (int child : graph[current]) {
            if (child == parent) continue;
            if (visited[child] == false) {
                dfs(child, current, visited);
                low[current] = Math.min(low[current], low[child]);
                if (low[current] < low[child]) {
                    result.add(new ArrayList<>(Arrays.asList(current, child)));
                }
            } else {
                low[current] = Math.min(low[current], disc[child]);
            }
        }
    }

    public List<List<Integer>> criticalConnections2(int n, List<List<Integer>> connections) {
        System.out.println(connections);

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (List<Integer> list : connections) {
            if (!map.containsKey(list.get(0))) map.put(list.get(0), new LinkedList<>());
            if (!map.containsKey(list.get(1))) map.put(list.get(1), new LinkedList<>());

            map.get(list.get(0)).add(list.get(1));
            map.get(list.get(1)).add(list.get(0));
        }

        int[] disc = new int[n];
        int[] low = new int[n];
        int[] parent = new int[n];
        List<List<Integer>> result = new LinkedList<>();

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        for (int key : map.keySet()) {
            if (disc[key] == -1) {
                dfs(key, disc, low, parent, result, map);
            }
        }
        return result;
    }

    private void dfs(int u, int[] disc, int[] low, int[] parent, List<List<Integer>>
            result, Map<Integer, List<Integer>> map) {
        disc[u] = time;
        low[u] = time;
        time++;

        for (int v : map.get(u)) {
            if (disc[v] == -1) {
                parent[v] = u;
                dfs(v, disc, low, parent, result, map);
                low[u] = Math.min(low[u], low[v]);

                if (low[u] < low[v]) {
                    result.add(new ArrayList<>(Arrays.asList(u, v)));
                }
            } else {
                if (v != parent[u]) {
                    low[u] = Math.min(low[u], disc[v]);
                }
            }
        }
    }

}
