package com.company.leetcode.array;

import java.util.*;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        KClosestPointsToOrigin kc = new KClosestPointsToOrigin();
        int[][] p = {{2, 10}, {-9, -9}, {0, 8}, {-2, -2}, {8, 9}, {-10, -7}, {-5, 2}, {-4, -9}};
        int[][] output = kc.kClosest(p, 7);
        for (int[] i : output) {
            System.out.println(Arrays.toString(i));
        }
    }

    class Pair implements Comparable<Pair> {
        int dist;
        int x;
        int y;

        public Pair(int dist, int x, int y) {
            this.dist = dist;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "dist=" + dist +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int compareTo(Pair o) {
            return this.dist - o.dist;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Pair> q = new PriorityQueue<>();

        for (int i = 0; i < points.length; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            q.offer(new Pair(dist, points[i][0], points[i][1]));
            if (q.size() > K) q.remove();
        }
//
//        while (!q.isEmpty()) {
//            System.out.println(q.remove());
//        }


//        System.out.println(q);
        int[][] r = new int[K][2];
        int i = 0;
        while (!q.isEmpty()) {
            K--;
            Pair temp = q.remove();
            r[i][0] = temp.x;
            r[i][1] = temp.y;
            i++;
        }
        return r;
    }

}
