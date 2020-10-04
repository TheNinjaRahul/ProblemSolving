package com.company.leetcode.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfAchievableTransferRequests {
    public static void main(String[] args) {

    }

    public static int maximumRequests(int n, int[][] r) {

        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < r.length; i++) {
            int out = r[i][0];
            int in = r[i][1];

            if (!map.containsKey(out)) map.put(out, new int[]{0, 0});
            if (!map.containsKey(in)) map.put(out, new int[]{0, 0});
            map.get(out)[0]++;
            map.get(in)[1]++;
//            c[out][0]++;
//            c[in][1]++;
        }

        int re = 0;

        for (Integer k : map.keySet()) {
            System.out.println("Key:" + k + "-->");
            System.out.print(Arrays.toString(map.get(k)));
        }

        for (Integer key : map.keySet()) {
            int in = map.get(key)[1];
            int out = map.get(key)[0];
            if (out == 0) continue;
            if (in == out) {
                re += out;
            } else if (out > in) {
                re += in;
            } else if (out < in) {
                re += out;
            }
        }
//        for (int i = 0; i < map.size(); i++) {
//            if (c[i][1] == c[i][0]) {
//                re += c[i][1];
//            } else if (c[i][1] > c[i][0]) {
//                re += c[i][1] - c[i][0];
//            } else if (c[i][1] > c[i][0]) {
//                re += c[i][0] - c[i][1];
//            }
//        }
        return re;
    }
}
