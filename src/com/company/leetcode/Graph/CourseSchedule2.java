package com.company.leetcode.Graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule2 {
    public static void main(String[] args) {

        int[][] data2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(findOrder(4, data2));

        int[][] data = {{1, 0}};
        System.out.println(findOrder(2, data));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjlist = new LinkedList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjlist[i] = new LinkedList<>();
        }

        for (int[] pre : prerequisites) {
            adjlist[pre[0]].add(pre[1]);
        }

        int visited[] = new int[numCourses];
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && dfs(visited, adjlist, i, list)) return new int[0];
        }

//        Collections.reverse(list);
        System.out.println(list);
        return list.stream().mapToInt(Integer::intValue).toArray();

    }

    private static boolean dfs(int[] visited, List<Integer>[] adjlist, int node, List<Integer> list) {
        if (visited[node] == 1) return true;
        visited[node] = 1;
        for (int i : adjlist[node]) {
            if (visited[i] == 2) continue;
            if (dfs(visited, adjlist, i, list)) return true;
        }
        if (visited[node] != 2) list.add(node);
        visited[node] = 2;
        return false;
    }
}
