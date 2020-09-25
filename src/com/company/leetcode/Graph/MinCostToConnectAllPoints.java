package com.company.leetcode.Graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        int[][] p = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(minCostConnectPoints(p));
    }

    static class edge {
        int point1;
        int point2;
        int dist;

        public edge(int point1, int point2, int dist) {
            this.point1 = point1;
            this.point2 = point2;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "edge{" +
                    "point1=" + point1 +
                    ", point2=" + point2 +
                    ", dist=" + dist +
                    '}';
        }
    }

    public static int minCostConnectPoints(int[][] points) {

        int sum = 0;
        Set<Integer> set = new HashSet<>();
        PriorityQueue<edge> queue = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x = Math.abs(points[i][0] - points[j][0]);
                int y = Math.abs(points[i][1] - points[j][1]);
                int dist = Math.abs(x + y);
                queue.add(new edge(i, j, dist));
            }
        }
        System.out.println(queue);

        while (!queue.isEmpty()) {
            edge edge = queue.remove();
            if (set.contains(edge.point1) && set.contains(edge.point2)) {
                continue;
            }

            sum += edge.dist;
            set.add(edge.point1);
            set.add(edge.point2);
        }
        return sum;
    }
}
