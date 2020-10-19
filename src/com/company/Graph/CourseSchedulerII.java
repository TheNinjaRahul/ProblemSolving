package com.company.Graph;

import java.util.*;
import java.util.stream.Collectors;

public class CourseSchedulerII {

    public static void main(String[] args) {
        CourseSchedulerII cs = new CourseSchedulerII();
        int d[][] = {{1, 0}};
        System.out.println(Arrays.toString(cs.findOrder(2, d)));
    }

    public int[] findOrder(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (!map.containsKey(prerequisites[i][0])) map.put(prerequisites[i][0], new LinkedList<>());
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        System.out.println(map);
        if (detectCycle(map, n)) {
            return new int[]{};
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, map, stack, visited);
            }
        }

        int[] l = new int[stack.size()];
        List<Integer> list = new LinkedList<>();
        int i = 0;
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        i = list.size() - 1;
        for (int j = 0; j < list.size(); j++) {
            l[j] = list.get(i--);
        }
        return l;
    }

    private boolean detectCycle(Map<Integer, List<Integer>> map, int n) {
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (dfs(map, visited, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(Map<Integer, List<Integer>> map, int[] visited, int current) {
        if (visited[current] == 2) return false;
        if (visited[current] == 1) return true;
        visited[current] = 1;

        if (map.containsKey(current)) {
            for (Integer adj : map.get(current)) {
                if (dfs(map, visited, adj)) {
                    return true;
                }
            }
        }
        visited[current] = 2;
        return false;
    }


    public void dfs(Integer key, Map<Integer, List<Integer>> map, Stack<Integer> stack, boolean[] visited) {
        if (visited[key]) return;
        visited[key] = true;
        if (map.containsKey(key)) {
            for (Integer adj : map.get(key)) {
                dfs(adj, map, stack, visited);
            }

        }
        stack.push(key);
    }
}
