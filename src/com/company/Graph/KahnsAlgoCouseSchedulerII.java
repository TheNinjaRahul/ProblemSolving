package com.company.Graph;

import java.util.*;

public class KahnsAlgoCouseSchedulerII {
    public static void main(String[] args) {

    }

    public int[] findOrder(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (!map.containsKey(prerequisites[i][0])) map.put(prerequisites[i][0], new LinkedList<>());
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] inCount = new int[n];

        Queue<Integer> q = new LinkedList<>();

        for (Integer key : map.keySet()) {
            for (Integer j : map.get(key)) {
                inCount[j]++;
            }
        }

        for (int i = 0; i < inCount.length; i++) {
            if (inCount[i] == 0) {
                q.add(i);
            }
        }

        int res[] = new int[n];
        int ij = n - 1;

        int freq = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                freq++;
                int temp = q.remove();
                res[ij--] = temp;
                if (map.containsKey(temp)) {
                    for (Integer j : map.get(temp)) {
                        inCount[j]--;
                    }
                }

                inCount[temp]--;
            }

            for (int i = 0; i < inCount.length; i++) {
                if (inCount[i] == 0) {
                    q.add(i);
                }
            }
        }
        return freq == n ? res : new int[]{};
    }

}
