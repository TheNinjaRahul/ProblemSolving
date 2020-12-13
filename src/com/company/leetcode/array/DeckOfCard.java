package com.company.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class DeckOfCard {
    public static void main(String[] args) {
        System.out.println(hasGroupsSizeX(new int[]{1, 1}));
        System.out.println(hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        System.out.println(map);
        if (map.size() == 1) {
            return map.get(map.keySet().iterator().next()) % 2 == 0;
        }

        int size = 0;
        for (int i : map.keySet()) {
            if (size == 0) {
                size = map.get(i);
                continue;
            } else {
                if (map.get(i) != size) return false;
            }
        }
        return true;
    }

}
