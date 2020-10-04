package com.company.Graph;

import java.util.*;

public class CourseScheduleII {

    public static void main(String[] args) {
        CourseScheduleII cs = new CourseScheduleII();
//        int d2[][] = {{1, 0}, {1, 2}, {0, 1}};
//        System.out.println(Arrays.toString(cs.findOrder(3, d2)));
        int d[][] = {{1, 0}};
        System.out.println(Arrays.toString(cs.findOrder(2, d)));
//        int data[][] = {{1, 0}, {0, 1}};
//        System.out.println(Arrays.toString(cs.findOrder(2, data)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (!map.containsKey(prerequisites[i][0])) map.put(prerequisites[i][0], new LinkedList<>());
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        System.out.println(map);
        LinkedList<Integer> result = new LinkedList<>();
        int color[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (color[i] == 0) {
                if (isCycle(i, map, color, result)) {
                    return new int[]{};
                } else {
//                    result.add(i);
                }
            }
        }
        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        System.out.println(result);
        return r;
    }

    private boolean isCycle(int vertex, Map<Integer, List<Integer>> map, int[] color, LinkedList<Integer> result) {
        if (color[vertex] == 1) {
            return true;
        }
        if (color[vertex] == 2) return false;
        color[vertex] = 1;
        if (map.containsKey(vertex)) {
            for (Integer node : map.get(vertex)) {
                if (color[vertex] == 2) continue;
                if (isCycle(node, map, color, result)) {
                    return true;
                }
            }
        }
        color[vertex] = 2;
        result.add(vertex);
        return false;
    }
}
