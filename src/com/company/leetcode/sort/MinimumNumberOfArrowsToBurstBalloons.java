package com.company.leetcode.sort;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {

    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> {
            int diff = a[0] - b[0];
            if (diff == 0) {
                return a[1] - b[1];
            }
            return diff;
        });

        for (int i = 0; i < points.length; i++) {
            System.out.println(Arrays.toString(points[i]));
        }


        int i = 1;
        int count = 0;
        int end = points[0][0];
        while (i < points.length) {
            while (i < points.length && end >= points[i][0]) {
                i++;
            }
            count++;
            if (i < points.length) {
                end = points[i][1];
            } else {
                break;
            }
        }

        return count;
    }

}
