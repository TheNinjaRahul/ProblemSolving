package com.company.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] d = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(merge(d));
    }

    public static int[][] merge(int[][] ar) {
        Arrays.sort(ar, (a, b) -> {
            int d = a[0] - b[0];
            if (d == 0) {
                return a[1] - b[1];
            } else {
                return d;
            }
        });


        for (int[] l : ar) {
            System.out.println(Arrays.toString(l));
        }

        List<int[]> list = new ArrayList<>();
        int starti = 0, endi = 0, end = -1;
        while (endi < ar.length) {
            if (end == -1) {
                end = ar[endi][1];
                continue;
            }

            if (end < ar[endi][0]) {
                list.add(new int[]{ar[starti][0], end});
                starti = endi;
                end = ar[starti][1];
            } else {
                end = Math.max(end, ar[endi][1]);
            }
            endi++;
        }
        list.add(new int[]{ar[starti][0], end});
        for (int[] l : list) {
            System.out.println(Arrays.toString(l));
        }
        return null;
    }

}
