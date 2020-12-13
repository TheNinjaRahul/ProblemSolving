package com.company.codility;

import java.util.Map;
import java.util.TreeMap;

public class FindRank {
    public static void main(String[] args) {
//        int d = 1_000_000_000;
//        System.out.println(d);
        FindRank f = new FindRank();

        System.out.println("5=" + f.solution(new int[]{3, 4, 3, 0, 2, 2, 3, 0, 0}));
        System.out.println("0=" + f.solution(new int[]{4, 2, 0}));
        System.out.println("3=" + f.solution(new int[]{4, 4, 3, 3, 1, 0}));
        System.out.println("7=" + f.solution(new int[]
                {1_000_000_000, 1_000_000_000, 1_000_000_000, 1_000_000_000,
                        999999999, 999999999, 999999999, 999999999, 999999999,
                        999999998, 999999998}));

    }

    public int solution(int[] ranks) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int r : ranks) {
            map.put(r, map.getOrDefault(r, 0) + 1);
        }

        int ans = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                ans += map.get(key);
            }
        }
        return ans;
    }
}
