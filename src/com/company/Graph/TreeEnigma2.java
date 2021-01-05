package com.company.Graph;

import java.util.*;

public class TreeEnigma2 {
    public static void main(String[] args) {
        int a[] = {1, 1, 2, 2, 3, 3};
        int b[] = {2, 3, 4, 5, 6, 7};
        int currentValue[] = {0, 1, 0, 1, 1, 1, 1};
        int expectedValue[] = {0, 0, 0, 0, 1, 0, 1};
        System.out.println(solveEnigmaProblem(a, b, currentValue, expectedValue));
    }

    private static int solveEnigmaProblem(int[] a, int[] b, int[] currentValue, int[] expectedValue) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) map.put(a[i], new LinkedList<>());
            if (!map.containsKey(b[i])) map.put(b[i], new LinkedList<>());
            map.get(a[i]).add(b[i]);
            map.get(b[i]).add(a[i]);
        }

        System.out.println(map);

        Set<Integer> set = new HashSet<>();
        return egigma(1, currentValue, expectedValue, map, set);

    }

    private static int egigma(int node, int[] currentValue, int[] expectedValue, Map<Integer, List<Integer>> map, Set<Integer> set) {
        if (set.contains(node)) return 0;
        int withoutFlip = 0, wfa = 0, wfb = 0;
        if (currentValue[node - 1] == expectedValue[node - 1]) {

        }

        flip(node, map, currentValue, expectedValue, set);
        set.add(node);

        return 0;
    }

    private static void flip(int node, Map<Integer, List<Integer>> map, int[] currentValue, int[] expectedValue, Set<Integer> set) {
        if (set.contains(node)) return;
        if (currentValue[node - 1] == 0) {
            currentValue[node - 1] = 1;
        } else {
            currentValue[node - 1] = 0;
        }
        set.add(node);
        if (map.containsKey(node)) {
            for (int i : map.get(node)) {
                flip(i, map, currentValue, expectedValue, set);
            }
        }
        set.remove(node);
    }
}
