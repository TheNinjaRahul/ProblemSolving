package com.company.GFG.graph;

import java.util.ArrayList;

public class FindPossiblePathsFromGivenSourceToDestination {
    public static void main(String[] args) {
        int[][] d = {{}, {2, 3, 5}, {4, 5}, {5}, {3}, {}};
        ArrayList<ArrayList<Integer>> g = GraphUtil.ConvetToArrayLists(d);
        System.out.println(countPaths(g, 1, 5));
    }

    static int countPaths(ArrayList<ArrayList<Integer>> g, int s, int d) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        boolean[] visited = new boolean[g.size()];
        curr.add(s);
        dfs(s, d, curr, lists, g, visited);
        return lists.size();
    }

    private static void dfs(int s, int d, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> lists, ArrayList<ArrayList<Integer>> g, boolean[] visited) {
        if (s == d) {
            lists.add(new ArrayList<>(curr));
            System.out.println(curr);
            return;
        }
        for (Integer i : g.get(s)) {
            curr.add(i);
            dfs(i, d, curr, lists, g, visited);
            curr.remove(curr.size() - 1);
        }
    }
}
