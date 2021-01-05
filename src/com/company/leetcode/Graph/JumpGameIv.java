package com.company.leetcode.Graph;

import java.util.*;

public class JumpGameIv {
    public static void main(String[] args) {
        int[] a = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        System.out.println(minJumps(a));
    }

    public static int minJumps(int[] a) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) map.put(a[i], new LinkedList<>());
            map.get(a[i]).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int level = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.remove();
                if (temp == a.length - 1) return level;
                if (map.containsKey(a[temp]) && map.get(a[temp]).size() > 1) {
                    for (int k : map.get(a[temp])) {
                        if (!set.contains(k)) {
                            queue.add(k);
                            set.add(k);
                        }
                    }
                }
                if (temp - 1 >= 0 && temp - 1 < a.length) {
                    if (!set.contains(temp - 1)) {
                        queue.add(temp - 1);
                        set.add(temp - 1);
                    }
                }
                if (temp + 1 < a.length && temp + 1 >= 0) {
                    if (!set.contains(temp + 1)) {
                        queue.add(temp + 1);
                        set.add(temp + 1);
                    }
                }
                map.remove(a[temp]);
            }
            level++;
        }
        return 0;
    }


}
