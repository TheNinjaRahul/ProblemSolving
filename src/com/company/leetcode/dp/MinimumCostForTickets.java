package com.company.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostForTickets {

    public static void main(String[] args) {
        int data2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int c[] = {2, 7, 15};
        System.out.println(mincostTickets(data2, c));

        int data[] = {1, 4, 6, 7, 8, 20};
        int cost[] = {2, 7, 15};
        System.out.println(mincostTickets(data, cost));
    }

    public static int mincostTickets(int[] days, int[] costs) {
        Map<Integer, Integer> map = new HashMap<>();
        return rec(days, costs, 0, map);
    }

    private static int rec(int[] days, int[] costs, int i, Map<Integer, Integer> map) {
        if (i >= days.length) return 0;

        if (map.containsKey(i)) {
            return map.get(i);
        }
        int op1 = costs[0] + rec(days, costs, i + 1, map);


        int k = i;
        for (; k < days.length; k++) {
            if (days[k] >= days[i] + 7) {
                break;
            }
        }
        int op2 = costs[1] + rec(days, costs, k, map);

        k = i;
        for (; k < days.length; k++) {
            if (days[k] >= days[i] + 30) {
                break;
            }
        }
        int op3 = costs[2] + rec(days, costs, k, map);

        int ans = Math.min(op1, Math.min(op2, op3));
        map.put(i, ans);
        return ans;

    }

}
