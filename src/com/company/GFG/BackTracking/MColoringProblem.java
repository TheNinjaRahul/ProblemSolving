package com.company.GFG.BackTracking;

import java.util.*;

public class MColoringProblem {
    public static void main(String[] args) {
        List<Integer>[] G = new List[4];
        List<Integer> l0 = new LinkedList<>();
        l0.add(1);
        l0.add(2);
        l0.add(3);

        List<Integer> l1 = new LinkedList<>();
        l1.add(0);
        l1.add(2);

        List<Integer> l2 = new LinkedList<>();
        l2.add(1);
        l2.add(0);
        l2.add(3);

        List<Integer> l3 = new LinkedList<>();
        l3.add(2);
        l3.add(0);

        G[0] = l0;
        G[1] = l1;
        G[2] = l2;
        G[3] = l3;

        System.out.println(graphColoring(G, new int[]{0, 1, 2, 3}, 0, 0));

    }


    public static boolean graphColoring(List<Integer>[] G,
                                        int[] color, int i, int C) {

        Map<Integer, Integer> assignedColor = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int j = 0; j < G.length; j++) {
            map.put(j, new LinkedList<>());
            for (Integer v : G[j]) {
                map.get(j).add(v);
            }
        }

        System.out.println(map);

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {

            if (assignedColor.containsKey(entry.getKey())) {
                continue;
            }

            for (int j = 0; j < color.length; j++) {
                if (!isNeiboughrHaveThisColor(j, entry.getValue(), assignedColor)) {
                    assignedColor.put(entry.getKey(), j);
                    if (assignedColor.size() == G.length) {
                        return true;
                    } else {
                        dfs(entry.getValue(), assignedColor, map, color);
                    }
                }
            }
        }

        return false;
    }

    private static void dfs(List<Integer> value, Map<Integer, Integer> assignedColor, Map<Integer, List<Integer>> map, int[] color) {
        if (assignedColor.size() == map.size()) return;
        for (Integer v : value) {
            if (!assignedColor.containsKey(v)) {
                for (int j = 0; j < color.length; j++) {
                    if (assignedColor.containsKey(v)) continue;
                    if (!isNeiboughrHaveThisColor(j, map.get(v), assignedColor)) {
                        assignedColor.put(v, j);
                        if (assignedColor.size() == map.size()) {
                            return;
                        } else {
                            dfs(map.get(v), assignedColor, map, color);
                        }
                    }
                }
            }
        }
    }

    private static boolean isNeiboughrHaveThisColor(int j, List<Integer> values, Map<Integer, Integer> assignedColor) {
        for (Integer i : values) {
            if (assignedColor.getOrDefault(i, -1) == j) {
                return true;
            }
        }
        return false;
    }
}
