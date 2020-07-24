package com.company.leetcode.Graph;

import javax.swing.*;
import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int data2[][] = {{1, 0}};
        System.out.println(canFinish(2, data2));

//        int data[][] = {{1, 0}, {1, 2}, {0, 1}};
//        System.out.println(canFinish(3, data));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjlist = new LinkedList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjlist[i] = new LinkedList<>();
        }

        for (int[] pre : prerequisites) {
            adjlist[pre[0]].add(pre[1]);
        }

        int visited[] = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(visited, adjlist, i)) return false;
        }

        return true;
    }

    private static boolean dfs(int[] visited, List<Integer>[] adjlist, int node) {
        if (visited[node] == 1) return false;
        visited[node] = 1;
        for (int i : adjlist[node]) {
            if (!dfs(visited, adjlist, i)) return false;
        }
        visited[node] = 2;
        return true;
    }
}
