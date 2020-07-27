package com.company.leetcode.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class KnitghtMinStepsToRequireTarget {
    public static void main(String[] args) {
        int[] k2 = {5, 7};
        int[] t2 = {15, 20};
        System.out.println(minStepToReachTarget(k2, t2, 20));

        int[] k = {4, 5};
        int[] t = {1, 1};
        System.out.println(minStepToReachTarget(k, t, 6));
    }

    public static int minStepToReachTarget(int knightpos[], int targetpos[], int N) {
        int[] x = {-2, -2, -1, 1, 2, 2, -1, 1};
        int[] y = {1, -1, 2, 2, 1, -1, -2, -2};

        boolean visited[][] = new boolean[N + 1][N + 1];
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(knightpos);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] temp = queue.remove();
                if (temp[0] == targetpos[0] && temp[1] == targetpos[1]) return count;
                for (int c = 0; c < x.length; c++) {
                    int xa = temp[0] + x[c];
                    int xb = temp[1] + y[c];
                    if (check(xa, xb, N) && !visited[xa][xb]) {
                        visited[xa][xb] = true;
                        queue.add(new int[]{xa, xb});
                    }
                }
            }
            count++;
        }
        return 0;
    }

    private static boolean check(int i, int j, int n) {
        return (i >= 1 && i <= n && j >= 1 && j <= n);
    }
}
