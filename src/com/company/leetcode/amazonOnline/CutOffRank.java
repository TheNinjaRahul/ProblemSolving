package com.company.leetcode.amazonOnline;

import java.util.*;
import java.util.stream.Collectors;

public class CutOffRank {
    public static void main(String[] args) {
        System.out.println(cutOffRank(new int[]{2, 2, 3, 4, 5}, 4));
        System.out.println(cutOffRank(new int[]{100, 50, 50, 25}, 3));
    }

    public static int cutOffRank(int[] score, int cutoffRank) {
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], map.getOrDefault(score[i], 0) + 1);
        }

        System.out.println(map);
        int count = 0;
        for (int key : map.keySet()) {
            if (key == 0) break;
            count += map.get(key);
            if (count >= cutoffRank) break;
        }
        return count;

    }
}
