package com.company.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseScheduleDetectCycle {
    public static void main(String[] args) {
        CourseScheduleDetectCycle cs = new CourseScheduleDetectCycle();

        int d2[][] = {{1, 0}, {1, 2}, {0, 1}};
        System.out.println(cs.canFinish(3, d2));
        int d[][] = {{1, 0}};
        System.out.println(cs.canFinish(2, d));
        int data[][] = {{1, 0}, {0, 1}};

        System.out.println(cs.canFinish(2, data));
//        System.out.println(cs.canFinish());
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (!map.containsKey(prerequisites[i][0])) map.put(prerequisites[i][0], new LinkedList<>());
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        System.out.println(map);
        int color[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (color[i] == 0) {
                if (isCycle(i, map, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCycle(int vertex, Map<Integer, List<Integer>> map, int[] color) {
        if (color[vertex] == 1) {
            return true;
        }
        color[vertex] = 1;
        if (map.containsKey(vertex)) {
            for (Integer node : map.get(vertex)) {
                if (color[vertex] == 2) continue;
                if (isCycle(node, map, color)) {
                    return true;
                }
            }
        }

        color[vertex] = 2;
        return false;
    }
}
