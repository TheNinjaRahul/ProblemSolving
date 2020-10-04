package com.company.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {

        int[][] connection2 = new int[][]{{0, 1, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 1}, {1, 0, 0, 0, 0}};
        System.out.println(isCyclickGraph(connection2));
        int[][] connection = new int[][]{{0, 1, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 1}, {1, 0, 1, 0, 0}};
        System.out.println(isCyclickGraph(connection));
    }

    private static boolean isCyclickGraph(int[][] connection) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < connection.length; i++) {
            map.put(i, new LinkedList<>());
            for (int j = 0; j < connection[0].length; j++) {
                if (connection[i][j] == 1) {
                    map.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[map.size()];
        for (Integer key : map.keySet()) {
            if (containCycle(key, map, visited)) return true;
        }
        return false;
    }

    private static boolean containCycle(Integer key, Map<Integer, List<Integer>> map, boolean[] visited) {
        if (visited[key]) return true;
        visited[key] = true;
        for (Integer j : map.get(key)) {
            if (containCycle(j, map, visited)) return true;
        }
        visited[key] = false;
        return false;
    }
}
