package com.company.leetcode.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRightInterval {
    public static void main(String[] args) {
        int[][] d = {{3, 4}, {2, 3}, {1, 2}};
        System.out.println(Arrays.toString(findRightInterval(d)));
    }

    public static int[] findRightInterval(int[][] a) {

        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < a.length; i++) {
            map.put(a[i][0], i);
        }
        System.out.println(map);

        Arrays.sort(a, (c, b) -> c[0] - b[0]);

        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        int ans[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            Integer res = binarySearch(a[i], a);
            if (res == a.length) {
                ans[i] = -1;
            } else if (res == 0) {
                if (a[i][1] <= a[0][0]) {
                    ans[i] = map.get(a[0][0]);
                } else {
                    ans[i] = -1;
                }
            } else {
                ans[i] = map.get(res);
            }
        }
        return ans;
    }

    private static int binarySearch(int[] ints, int[][] a) {
        int target = ints[1];
        int start = 0, end = a.length - 1, mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (a[mid][0] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public int[] findRightInterval2(int[][] a) {

        int ans[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int minIndex = -1;
            int val = Integer.MAX_VALUE;
            for (int j = 0; j < a.length; j++) {
                if (i == j) continue;

                if (a[i][1] <= a[j][0]) {
                    if (val > a[j][0]) {
                        val = a[j][0];
                        minIndex = j;
                    }
                }
            }
            ans[i] = minIndex;
        }
        return ans;
    }
}
