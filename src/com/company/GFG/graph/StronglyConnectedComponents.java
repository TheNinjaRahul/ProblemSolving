package com.company.GFG.graph;

import java.util.*;

public class StronglyConnectedComponents {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> l0 = new ArrayList<>();
        l0.add(2);
        l0.add(3);
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(0);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(1);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(4);
        ArrayList<Integer> l4 = new ArrayList<>();

        list.add(l0);
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);

        System.out.println(kosaraju(list, 5));

    }

    public static int kosaraju(ArrayList<ArrayList<Integer>> adj, int N) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(i, new LinkedList<>());
            for (Integer v : adj.get(i)) {
                map.get(i).add(v);
            }
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            dfs(i, map, stack, visited);
        }

        Map<Integer, List<Integer>> reverseMap = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            for (Integer i : e.getValue()) {
                if (!reverseMap.containsKey(i)) reverseMap.put(i, new LinkedList<>());
                reverseMap.get(i).add(e.getKey());
            }
        }
        int count = 0;
        visited = new boolean[N];
        while (!stack.isEmpty()) {
            Integer i = stack.pop();
            if (visited[i]) continue;
            count++;
            dfs(i, reverseMap, visited);
        }
        return count;
    }

    private static void dfs(Integer current, Map<Integer, List<Integer>> reverseMap, boolean[] visited) {
        if (visited[current]) return;
        visited[current] = true;
        try {
            if (reverseMap.containsKey(current)) {
                for (Integer i : reverseMap.get(current)) {
                    if (!visited[i]) {
                        dfs(i, reverseMap, visited);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(current + ":" + reverseMap);
        }

    }

    private static void dfs(int current, Map<Integer, List<Integer>> map, Stack<Integer> stack, boolean[] visited) {
        if (visited[current]) return;
        visited[current] = true;
        for (Integer i : map.get(current)) {
            if (!visited[i]) {
                dfs(i, map, stack, visited);
            }
        }
        stack.push(current);
    }
}
