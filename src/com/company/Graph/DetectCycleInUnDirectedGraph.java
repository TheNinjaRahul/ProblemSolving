package com.company.Graph;

import java.util.*;

public class DetectCycleInUnDirectedGraph {
    public static void main(String[] args) {
        int[][] connection2 = new int[][]{{0, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 0, 1, 0}};
        System.out.println(isCyclickGraph(connection2));
        int[][] connection = new int[][]{{0, 1, 1, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {0, 0, 1, 0}};
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
        System.out.println(map);
        /*
        0: Unvisted
        1: Visitedl
        2: Processed
        */

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[map.size()];

        queue.add(0);
        visited[0] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.remove();
                for (Integer ver : map.get(temp)) {
                    if (visited[ver] == 1) return true;
                    if (visited[ver] == 2) continue;
                    visited[ver] = 1;
                    queue.add(ver);
                }
                visited[temp] = 2;
            }
        }
        return false;
    }

    private static boolean containCycle(Integer key, Map<Integer, List<Integer>> map, int[] visited) {

        if (visited[key] == 2) return true;
        if (visited[key] == 0) visited[key] = 1;

        for (Integer j : map.get(key)) {
            if (visited[j] == 1) {
                visited[j] = 2;
            } else {
                if (containCycle(j, map, visited)) return true;
            }
        }

        visited[key] = 0;
        return false;
    }
}
