package com.company.leetcode.slidingWindow;

import java.util.*;

public class SubarraysWithKDifferentIntegers {

    public static void main(String[] args) {
        SubarraysWithKDifferentIntegers sa = new SubarraysWithKDifferentIntegers();
        System.out.println(sa.subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));
        System.out.println(sa.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));

    }

    public int subarraysWithKDistinct(int[] a, int k) {
        return subarraysWithAtMostNDistinctNumbers(a, k) - subarraysWithAtMostNDistinctNumbers(a, k - 1);
    }

    private int subarraysWithAtMostNDistinctNumbers(int[] a, int k) {
        int start = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

//        map.put(a[0], map.getOrDefault(a[0], 0) + 1);
        for (int end = 0; end < a.length; end++) {
            map.put(a[end], map.getOrDefault(a[end], 0) + 1);
            while (map.size() > k) {
                removeFromMap(map, a[start]);
                start++;
            }
            count += end - start + 1;
        }
        return count;
    }

    private void removeFromMap(Map<Integer, Integer> map, int i) {
        map.put(i, map.get(i) - 1);
        if (map.get(i) == 0) {
            map.remove(i);
        }
    }
}
