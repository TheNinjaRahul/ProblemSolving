package com.company.GFG.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {

    }

    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
        Set<Integer> v = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (v.contains(i)) {
                continue;
            }
            dfs(v, stack, i, adj);
        }
        System.out.println(stack);

        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = stack.pop();
        }
        return data;
    }

    private static void dfs(Set<Integer> v, Stack<Integer> stack, int i, ArrayList<ArrayList<Integer>> adj) {
        if (v.contains(i)) {
            return;
        }
        v.add(i);
        for (Integer in : adj.get(i)) {
            if (v.contains(in)) {
                continue;
            }
            dfs(v, stack, in, adj);
        }
        stack.push(i);
    }
}
