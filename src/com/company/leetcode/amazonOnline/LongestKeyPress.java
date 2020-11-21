package com.company.leetcode.amazonOnline;

import java.util.*;

public class LongestKeyPress {
    public static void main(String[] args) {
        LongestKeyPress lkp = new LongestKeyPress();
        System.out.println(lkp.slowestKey(new int[]{1, 2}, "ab"));
    }

    public char slowestKey(int[] rt, String keysPressed) {
        Map<Integer, Set<Character>> map = new TreeMap<>(Collections.reverseOrder());
        map.put(rt[0], new TreeSet<>(Collections.reverseOrder()));
        map.get(rt[0]).add(keysPressed.charAt(0));
        int lastTime = rt[0];
        System.out.println(map);
        for (int i = 1; i < rt.length; i++) {
            if (!map.containsKey(rt[i]- lastTime)) map.put(rt[i] - lastTime, new TreeSet<>(Collections.reverseOrder()));
            map.get(rt[i] - lastTime).add(keysPressed.charAt(i));
            lastTime = rt[i];
        }
        System.out.println(map);
        for (int key : map.keySet()) {
            for (char c : map.get(key)) {
                return c;
            }
        }
        return 'a';
    }
}
