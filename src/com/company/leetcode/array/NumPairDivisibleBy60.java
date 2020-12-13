package com.company.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class NumPairDivisibleBy60 {
    public static void main(String[] args) {
//        System.out.println(numPairsDivisibleBy5(new int[]{13, 12, 16, 14, 13, 1, 15, 15}));
        System.out.println(numPairsDivisibleBy60(new int[]{60, 60, 60}));

        System.out.println(numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
    }

    public static int numPairsDivisibleBy5(int[] time) {
        int[] a = new int[5];
        for (int i : time) {
            a[i % 5]++;
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(i + "=" + a[i]);
        }
        int i = 1, j = 4, count = 0;
        while (i < j) {
            int min = Math.max(a[i], a[j]);
            int max = Math.max(a[i], a[j]);
            if (min > 0) {
                count += max;
            }
            i++;
            j--;
        }
        return count + a[0] / 2;
    }

    public static int numPairsDivisibleBy60(int[] time) {

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : time) {
            int diff = 60 - (i % 60);
            if (diff == 60) {
                diff = 0;
            }
            if (map.containsKey(diff)) {
                count += map.get(diff);
            }
            map.put(i % 60, map.getOrDefault(diff, 0) + 1);
        }
        return count;
    }
}
