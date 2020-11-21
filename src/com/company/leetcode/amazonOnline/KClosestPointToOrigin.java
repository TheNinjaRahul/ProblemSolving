package com.company.leetcode.amazonOnline;

import java.util.*;

public class KClosestPointToOrigin {

    public static void main(String[] args) {
        KClosestPointToOrigin k = new KClosestPointToOrigin();
        k.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        k.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
    }

    class Pair {
        int dist;
        int point[];

        public Pair(int d, int[] p) {
            dist = d;
            point = p;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> b.dist - a.dist);

        for (int i = 0; i < points.length; i++) {
            int d = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            q.add(new Pair(d, points[i]));

            if (q.size() > k) {
                q.remove();
            }
        }

        int[][] output = new int[k][2];
        int size=q.size();
        for (int i = 0; i <size; i++) {
            int[] p = q.remove().point;
            output[i] = p;
        }
        return output;
    }
}
