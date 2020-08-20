package com.company.leetcode.sort;

import java.util.Arrays;
import java.util.Map;

public class FIndOverlappingIntervals {
    public static void main(String[] args) {

        int[][] d3 = {{1, 2}, {2, 3}};
        System.out.println(m1(d3));

        int[][] d = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println(m1(d));

        int[][] d2 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(m1(d2));
    }

    public static int m1(int[][] n) {
        Arrays.sort(n, (a, b) -> {
                    return a[0] - b[0];
                }
        );

        int count = 0;
        int end = n[0][1];
        for (int i = 1; i < n.length; i++) {
            if (end > n[i][0]) {
                count++;
                end = Math.min(end, n[i][1]);
            } else {
                end = n[i][1];
            }
        }
        return count;
    }
}
