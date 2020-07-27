package com.company.GFG.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class FindMotherOfVertex {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        g.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        g.add(list2);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        g.add(list3);
        ArrayList<Integer> list4 = new ArrayList<>();
        g.add(list4);
        System.out.println(findMother(g, g.size()));
    }

    static int findMother(ArrayList<ArrayList<Integer>> g, int n) {
        int v = 0;
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, g.get(i), g);
                v = i;
            }
        }
        Arrays.fill(visited, false);
        dfs(v, visited, g.get(v), g);
        if (check(visited)) return v;
        return -1;
    }

    private static void dfs(int current, boolean[] visited, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> g) {
        if (visited[current]) return;
        visited[current] = true;
        for (int i : list) {
            if (!visited[i]) {
                dfs(i, visited, g.get(i), g);
            }
        }
    }

    private static boolean check(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }


}
