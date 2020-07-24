package com.company.GFG.graph;

import java.util.*;

public class DetectCycleInGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(0);
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        adj.add(list1);
        adj.add(list2);
        adj.add(list3);
        System.out.println(isCyclic(adj, adj.size()));
    }

    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int i = 0;
        for (ArrayList<Integer> e : adj) {
            map.put(i++, e);
        }
        System.out.println(map);

        Set<Integer> inprogress = new HashSet<>();
        Set<Integer> completed = new HashSet<>();
        boolean result = false;
        for (int k = 0; k < adj.size(); k++) {
            result |= dfs(k, inprogress, completed, map);
            if (result) return result;
        }
        return false;

    }

    private static boolean dfs(int vertex, Set<Integer> inprogress, Set<Integer> completed, Map<Integer, ArrayList<Integer>> map) {
        if (inprogress.contains(vertex) && !completed.contains(vertex)) {
            return true;
        }
        inprogress.add(vertex);
        boolean result = false;
        if (map.get(vertex) != null) {
            for (Integer i : map.get(vertex)) {
                result |= dfs(i, inprogress, completed, map);
                if (result) return result;
            }
        }
        completed.add(vertex);
        return result;
    }
}
